package com.iqexception.fxhelper.account.service.builder;

import com.iqexception.fxhelper.account.dal.generator.tables.pojos.FxAccount;

public class AccountBuilder {


    public static FxAccount buildNewAccount(Long userId) {

        FxAccount account = new FxAccount();
        account.setUserId(userId);
        return account;

    }


}
