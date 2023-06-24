package com.example.todolist;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class TodoForm {


    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    public TodoForm() {
        this.id = "test";
        this.completed = 0;
    }

    public TodoForm( String title, String dateTime) {
        this.id = "test";
        this.title = title;
        this.dateTime = dateTime;
        this.completed = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    @SerializedName("dateTime")
    private String dateTime;

    @SerializedName("completed")
    private int completed;
}
