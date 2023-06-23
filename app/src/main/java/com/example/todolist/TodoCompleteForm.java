package com.example.todolist;

import com.google.gson.annotations.SerializedName;

public class TodoCompleteForm {

    @SerializedName("no")
    private int no;

    @SerializedName("completed")
    private int completed;

    public TodoCompleteForm(int no, int completed) {
        this.no = no;
        this.completed = completed;
    }
}
