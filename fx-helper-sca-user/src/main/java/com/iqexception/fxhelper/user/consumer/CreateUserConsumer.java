package com.iqexception.fxhelper.user.consumer;

import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountResult;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.user.stub.AccountService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${rocketmq.consumer.topic.user-create}",
        consumerGroup = "${rocketmq.consumer.group}"
)
public class CreateUserConsumer implements RocketMQListener<CreateUserMessage> {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final AccountService accountService;
    private final JsonMapper jsonMapper;

    public CreateUserConsumer(AccountService accountService, JsonMapper jsonMapper) {
        this.accountService = accountService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void onMessage(CreateUserMessage message) {

        try {
            //幂等
            InternalGetAccountResult account = accountService.getAccountQuietly(message.userId());
            if (account != null) return;
            boolean success = accountService.createAccountQuietly(message.userId());
            if (!success) {
                throw new RuntimeException("request failed! response:" + jsonMapper.serialize(message));
            }
        } catch (Exception e) {
            LOGGER.error("create user error! userId:{}", message.userId(), e);
            throw e;
        }

    }
}
