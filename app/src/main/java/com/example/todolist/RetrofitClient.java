package com.example.todolist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // 서버 호스트 주소
    private static final String BASE_URL = "http://192.168.123.100:4000";

    public static RetrofitInterface getApiService() {
        return getInstance().create(RetrofitInterface.class);
    }

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
