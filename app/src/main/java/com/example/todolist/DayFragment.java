package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DayFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;

    private TodoListAdapter mRecyclerAdapter;

    private ArrayList<Todo> todoList;

    public DayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DayFragment newInstance(String param1, String param2) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_day_layout, container, false);
        mRecyclerView = v.findViewById(R.id.todoListView);
loadItems();


        return v;
    }

    public void loadItems(){
        /* initiate adapter */
        mRecyclerAdapter = new TodoListAdapter();

        /* initiate recyclerview */

        Call<ArrayList<Todo>> call = RetrofitClient.getApiService().getTodoList();
        System.out.println("@@@Request");
        call.enqueue(new Callback<ArrayList<Todo>>() {
            //콜백 받는 부분
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {

                System.out.println("@@@@response");
                mRecyclerView.setAdapter(mRecyclerAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                ArrayList<Todo> result = response.body();
                System.out.println("@@@@"+result.size());
                todoList = new ArrayList<Todo>();
                for (int i = 0; i < result.size(); i++) {
                    Todo todo = result.get(i);
                    todoList.add(new Todo(todo.getNo(), todo.getTitle(), todo.getDateTime(), todo.getCompleted()));
                }
                mRecyclerAdapter.setTodoList(todoList);
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                System.out.println(t.getCause());
            }
        });
    }
}