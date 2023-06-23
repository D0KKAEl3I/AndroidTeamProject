package com.example.todolist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Todo {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("dateTime")
    @Expose
    private LocalDateTime dateTime;

    @SerializedName("completed")
    @Expose
    private Boolean completed;

    public Todo(String title, LocalDateTime dateTime, Boolean completed) {
        this.title = title;
        this.dateTime = dateTime;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


}
