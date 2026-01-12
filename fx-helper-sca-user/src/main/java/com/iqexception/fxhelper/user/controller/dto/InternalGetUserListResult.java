package com.iqexception.fxhelper.user.controller.dto;

import java.util.List;

public class InternalGetUserListResult {

    private List<UserInfo> userList;

    public List<UserInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }

    public InternalGetUserListResult(List<UserInfo> userList) {
        this.userList = userList;
    }
}
