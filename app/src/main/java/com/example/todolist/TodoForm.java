package com.example.todolist;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class TodoForm {

    @SerializedName("title")
    private String title;

    @SerializedName("dateTime")
    private LocalDateTime dateTime;
}
