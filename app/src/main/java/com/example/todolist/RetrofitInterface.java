package com.example.todolist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {
    @GET("posts/{UserID}")
    Call<data_model> test_api_get (
            @Path("UserID") String userid) ;
}
