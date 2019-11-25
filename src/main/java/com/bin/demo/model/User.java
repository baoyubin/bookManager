package com.bin.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class User {

    private Integer userId;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String userPwd;

    private Integer userSno;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserSno() {
        return userSno;
    }

    public void setUserSno(Integer userSno) {
        this.userSno = userSno;
    }
}