package com.example.todolist;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class TodoForm {

    @SerializedName("title")
    private String title;

    @SerializedName("dateTime")
    private LocalDateTime dateTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TodoForm(){

    }
    public TodoForm(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }
}
