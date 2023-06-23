package com.example.todolist;

import com.google.gson.annotations.SerializedName;

public class LoginForm {

    @SerializedName("id")
    private String id;

    @SerializedName("password")
    private String password;

    public LoginForm(String userId, String userPw) {
        this.id = userId;
        this.password = userPw;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = userId;
    }

    public String getUserPw() {
        return password;
    }

    public void setUserPw(String userPw) {
        this.password = userPw;
    }
}
