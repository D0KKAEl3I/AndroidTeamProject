package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {
    private ArrayList<Todo> todoList;

    @NonNull
    @Override
    public TodoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListAdapter.ViewHolder holder, int position) {
        holder.onBind(todoList.get(position));
    }

    public void setTodoList(ArrayList<Todo> list){
        this.todoList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout container;
         TextView title;
         TextView time;
         CheckBox completed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.todo_container);
            title = itemView.findViewById(R.id.todo_title);
            time =  itemView.findViewById(R.id.todo_time);
            completed =  itemView.findViewById(R.id.todo_completed);
        }

        void onBind(Todo item){
            container.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                }
            });
            title.setText(item.getTitle());
            time.setText(String.format("%s시 %s분", item.getDate().getHour(), item.getDate().getMinute()));
            completed.setChecked(item.getCompleted());
        }
    }
}
