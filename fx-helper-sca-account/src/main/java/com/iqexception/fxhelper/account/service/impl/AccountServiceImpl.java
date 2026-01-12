package com.iqexception.fxhelper.account.service.impl;

import com.iqexception.fxhelper.account.constant.BizErrorCode;
import com.iqexception.fxhelper.account.controller.dto.*;
import com.iqexception.fxhelper.account.dal.ext.FxAccountExtDao;
import com.iqexception.fxhelper.account.dal.generator.tables.pojos.FxAccount;
import com.iqexception.fxhelper.account.service.AccountService;
import com.iqexception.fxhelper.account.service.builder.AccountBuilder;
import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.BizException;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.jooq.DSLContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

    private final FxAccountExtDao accountExtDao;

    private final DSLContext jooqClient;

    public AccountServiceImpl(MessageSource messageSource,
                              JsonMapper jsonMapper,
                              DSLContext jooqClient,
                              FxAccountExtDao accountExtDao) {
        super(messageSource, jsonMapper);
        this.jooqClient = jooqClient;
        this.accountExtDao = accountExtDao;

    }

    @Override
    public Response<InternalAccountTransferResult> internalTransfer(InternalTransferRequest request) {

        Response<InternalAccountTransferResult> response = responseOk();


        try {
            jooqClient.transaction(conf -> {
                FxAccount account = accountExtDao.fetchOneByUserId(request.getFromAccountId());
                //转出账户不存在
                if (account == null) {
                    throw new BizException(BizErrorCode.ACCOUNT_FROM_NOT_EXIST);
                }

                int decr = accountExtDao.incrBalanceByAcctId(
                        request.getFromAccountId(),
                        request.getAmount().negate());

                //转出账户余额不足
                if (decr == 0) {
                    throw new BizException(BizErrorCode.ACCOUNT_BALANCE_INSUFFICIENT);
                }

                int incr = accountExtDao.incrBalanceByAcctId(
                        request.getToAccountId(),
                        request.getAmount());
                //转入账户不存在
                if (incr == 0) {
                    throw new BizException(BizErrorCode.ACCOUNT_TO_NOT_EXIST);
                }
            });

        } catch (BizException e) {
            response.setStatus(status(e.getErrorCode()));
        }


        return response;
    }

    @Override
    public Response<InternalGetAccountResult> internalGet(InternalGetAccountRequest request) {
        if (request.getAccountId() == null && request.getUserId() == null) {
            return response(ErrorCode.PARAM_ERROR);
        }
        FxAccount account;
        if (request.getAccountId() != null) {
            account = accountExtDao.fetchOneByAccountId(request.getAccountId());
        } else {
            account = accountExtDao.fetchOneByUserId(request.getUserId());
        }
        if (account == null)
            return response(ErrorCode.PARAM_ERROR);

        return responseOk(new InternalGetAccountResult(account));
    }

    @Override
    public Response<GetAccountResult> get(BaseRequest request) {
        FxAccount account = accountExtDao.fetchOneByUserId(TLVarManager.getUserId());
        if (account == null)
            return response(ErrorCode.PARAM_ERROR);

        return responseOk(new GetAccountResult(account));
    }

    @Override
    public Response<InternalAccountCreateResult> internalCreate(InternalCreateRequest request) {
        //幂等
        FxAccount account = accountExtDao.fetchOneByUserId(request.getUserId());
        if (account == null) {
            account = AccountBuilder.buildNewAccount(request.getUserId());
            accountExtDao.insert(account);
        }
        return responseOk(new InternalAccountCreateResult(account.getAccountId()));
    }

    @Override
    public BaseResponse internalIncrBalance(IncrBalanceRequest request) {
        FxAccount account = accountExtDao.fetchOneByAccountId(request.getAccountId());
        if (account == null)
            return new BaseResponse(status(ErrorCode.PARAM_ERROR));

        int ret = accountExtDao.incrBalanceByAcctId(request.getAccountId(), request.getAmount());
        return ret == 1 ? new BaseResponse(ResponseUtil.statusOk()) : new BaseResponse(status(BizErrorCode.ACCOUNT_BALANCE_INSUFFICIENT));
    }

}
