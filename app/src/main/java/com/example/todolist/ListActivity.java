package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Calendar;

public class ListActivity extends AppCompatActivity {
    TextView datePicker;
    LocalDate date = LocalDate.now();

    private final int Day_fFagmemt = 1;
    private final int Month_Fragment = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FragmentView(Day_fFagmemt); // 프로그램 실행 시 Day Fragment로 이동

        // on below line we are initializing our variables.
        datePicker = findViewById(R.id.datePicker);

        // on below line we are adding
        // click listener for our edit text.
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final java.util.Calendar c = java.util.Calendar.getInstance();
                int year = c.get(java.util.Calendar.YEAR);
                int month = c.get(java.util.Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date = LocalDate.of(year,month,dayOfMonth);
                        datePicker.setText(String.format("%d년 %d월 %d일", year, month+1, dayOfMonth));
                    }
                }, year, month, day);
                datePickerDialog.setTitle("날짜를 선택하세요.");
                datePickerDialog.show();
            }
        });

//        findViewById(R.id.dayLayoutButton).setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                FragmentView(Day_fFagmemt);
//            }
//        });

//        findViewById(R.id.monthLayoutButton).setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                FragmentView(Month_Fragment);
//            }
//        });

    }

    private void FragmentView(int fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment){
            case 1:
                // Day
                DayFragment dayFragment = new DayFragment();
                transaction.replace(R.id.fragmentContainerView, dayFragment);
                transaction.commit();
                break;

            case 2:
                // Month
                MonthFragment monthFragment = new MonthFragment();
                transaction.replace(R.id.fragmentContainerView, monthFragment);
                transaction.commit();
                break;
        }
    }
}