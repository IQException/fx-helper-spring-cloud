package com.iqexception.fxhelper.user.service.impl;

import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.RmqHelper;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.user.constant.BizErrorCode;
import com.iqexception.fxhelper.user.controller.dto.*;
import com.iqexception.fxhelper.user.dal.ext.FxUserExtDao;
import com.iqexception.fxhelper.user.dal.generator.tables.pojos.FxUser;
import com.iqexception.fxhelper.user.service.UserService;
import com.iqexception.fxhelper.user.service.builder.UserBuilder;
import com.iqexception.fxhelper.user.stub.AccountService;
import com.iqexception.fxhelper.user.wx.WxApi;
import com.iqexception.fxhelper.user.wx.model.Code2SessionResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    private static final int TOKEN_TTL_SECONDS = 60 * 60 * 24 * 7;

    private final WxApi wxApi;

    private final FxUserExtDao userExtDao;

    private final AccountService accountService;

    @Value("${rocketmq.producer.topic.create}")
    private String RMQ_TOPIC_CREATE_USER;

    public UserServiceImpl(MessageSource messageSource,
                           JsonMapper jsonMapper,
                           StringRedisTemplate redisTemplate,
                           RmqHelper rmqHelper,
                           WxApi wxApi,
                           FxUserExtDao userExtDao,
                           AccountService accountService) {

        super(messageSource, jsonMapper, redisTemplate, rmqHelper);
        this.wxApi = wxApi;
        this.userExtDao = userExtDao;
        this.accountService = accountService;
    }


    @Override
    public Response<UserLoginResult> login(Request<UserLoginParam> request) {

        Code2SessionResponse resp = wxApi.code2Session(request.getParam().getCode());

        String openId = resp.getOpenId();
        if (StringUtils.isBlank(openId)) {
            LOG.error("code2Session error: {}", jsonMapper.serialize(resp));
            return response(ErrorCode.SYSTEM_ERROR);
        }

        FxUser user = userExtDao.fetchOneByOpenId(openId);
        if (user != null) {
            //已存在的用户更新token
            user.setSessionKey(refreshToken(user.getUserId(), openId, user.getSessionKey()));
            userExtDao.update(user);
            return responseOk(new UserLoginResult(user.getSessionKey(), false));
        } else {
            // 创建新用户
            // insert user
            FxUser fakeUser = UserBuilder.buildUserByFakeData(openId);
            userExtDao.insert(fakeUser);
            // save token
            String token = generateAndSaveToken(fakeUser.getUserId(), openId);
            userExtDao.updateSessionKey(fakeUser.getUserId(), token);
            // 调用接口创建用户账户（若有异步接口，调用异步接口;同步接口要屏蔽掉异常，允许失败）
            accountService.createAccountQuietly(fakeUser.getUserId());
            // send message （兜底）。 在本项目中，只在此处做了这种处理，其他业务应当也这样兜底，但是简单（偷懒）起见，只做了同步调用
            rmqHelper.asyncSend(RMQ_TOPIC_CREATE_USER, Map.of("userId", fakeUser.getUserId()));

            return responseOk(new UserLoginResult(token, true));
        }

    }

    @Override
    public Response<InternalVerifyPaySecretResult> internalVerifyPaySecret(InternalVerifyPaySecretRequest request) {

        FxUser user = userExtDao.fetchOneByUserId(request.getUserId());

        if (user == null) return response(BizErrorCode.USER_NOT_EXIST);

        InternalVerifyPaySecretResult result = new InternalVerifyPaySecretResult();
        result.setResult(user.getPaySecret().equals(UserBuilder.encryptPaySecret(request.getPaySecret())));

        return responseOk(result);

    }

    @Override
    public Response<InternalCheckLoginResult> internalCheckLogin(InternalCheckLoginRequest request) {

        String tokenValue = redisTemplate.opsForValue().get(UserBuilder.buildTokenKey(request.getToken()));
        if (StringUtils.isBlank(tokenValue)) {
            LOG.error("token invalid: {}", request.getToken());
            return response(BizErrorCode.USER_SESSION_EXPIRED);
        }
        Pair<Long, String> pair = UserBuilder.parseTokenValue(tokenValue);
        return responseOk(new InternalCheckLoginResult(pair.getLeft(), pair.getRight()));
    }

    @Override
    public BaseResponse internalChangePaySecret(InternalChangePaySecretRequest request) {

        FxUser user = userExtDao.fetchOneByUserId(request.getUserId());

        if (user == null) return new BaseResponse(status(BizErrorCode.USER_NOT_EXIST));

        userExtDao.updatePaySecret(request.getUserId(), UserBuilder.encryptPaySecret(request.getPaySecret()));

        return new BaseResponse();
    }

    @Override
    public Response<InternalGetUserResult> internalGet(InternalGetUserRequest request) {
        FxUser user = userExtDao.fetchOneByUserId(request.getUserId());

        if (user == null) return response(BizErrorCode.USER_NOT_EXIST);

        return responseOk(new InternalGetUserResult(user));

    }

    @Override
    public Response<InternalGetUserListResult> internalGetUserList(InternalGetUserListRequest request) {
        List<FxUser> users = userExtDao.fetchByUserId(request.getUserIds().toArray(new Long[0]));
        return responseOk(new InternalGetUserListResult(
                users.stream().map(UserInfo::new).collect(Collectors.toList())));
    }

    public String refreshToken(Long userId, String openId, String oldToken) {
        invalidateToken(oldToken);
        return generateAndSaveToken(userId, openId);
    }

    public void invalidateToken(String token) {
        redisTemplate.delete(UserBuilder.buildTokenKey(token));
    }

    public String generateAndSaveToken(Long userId, String openId) {

        String token = UserBuilder.generateToken();
        boolean success = Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(UserBuilder.buildTokenKey(token),
                UserBuilder.buildTokenValue(userId, openId), TOKEN_TTL_SECONDS, TimeUnit.SECONDS));
        if (!success) {
            LOG.error("token exists! token: {}", token);
            throw new RuntimeException("token exists!");
        }
        return token;
    }
}
