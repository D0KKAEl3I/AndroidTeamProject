package com.example.todolist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Todo {

    @SerializedName("no")
    @Expose
    private int no;

    @SerializedName("id")
    @Expose
    private String id;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("dateTime")
    @Expose
    private String dateTime;

    @SerializedName("completed")
    @Expose
    private int completed;

    public Todo(int no,  String title, String dateTime, int completed) {
        this.no = no;
        this.id = "tlsgustn";
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


}
