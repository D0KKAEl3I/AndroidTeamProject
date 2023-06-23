package com.example.todolist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @SerializedName("token")
    @Expose
    private int token;


}
