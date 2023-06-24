package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(itemView.getContext() );
            bottomSheetDialog.setContentView(R.layout.update_todo_dialog_layout);
            container.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    bottomSheetDialog.show();
                }
            });
            System.out.println(item.getNo()
            );
            title.setText(item.getTitle());
            time.setText(String.format("%s시 %s분", item.getDateTime().substring(8,10), item.getDateTime().substring(10,12)));
            completed.setChecked(item.getCompleted() == 1);
            completed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    System.out.println(isChecked+" "+item.getNo());
                    Call<Object> call = RetrofitClient.getApiService().updateCompleted(new TodoCompleteForm(item.getNo(), isChecked ? 1 : 0));
                    call.enqueue(new Callback<Object>() {
                        //콜백 받는 부분
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                            System.out.println("suc"+item.getNo());
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                            System.out.println(t.getCause());
                        }
                    });
                }
            });
        }
    }
}
