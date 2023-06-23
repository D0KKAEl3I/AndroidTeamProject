package com.example.todolist;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class CreateTodoDialog extends BottomSheetDialogFragment {


    TextInputEditText title;


TextView date;
    MaterialButton datePicker, submit;

    TodoForm formValues = new TodoForm();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.create_todo_dialog_layout, container, false);

        title = v.findViewById(R.id.title);
        datePicker = v.findViewById(R.id.date_picker);
        submit = v.findViewById(R.id.submit);
        date = v.findViewById(R.id.date);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("클릭!");
                final java.util.Calendar c = java.util.Calendar.getInstance();
                int year = c.get(java.util.Calendar.YEAR);
                int month = c.get(java.util.Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(inflater.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        formValues.setDateTime(LocalDateTime.of(formValues.getDateTime().getYear(),formValues.getDateTime().getMonth(),formValues.getDateTime().getDayOfMonth(),hourOfDay,minute));
                    }
                },hour,minute,true);

                DatePickerDialog datePickerDialog = new DatePickerDialog(inflater.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        formValues.setDateTime( LocalDateTime.of(year,month,dayOfMonth,0,0));
                        datePicker.setText(String.format("%d년 %d월 %d일", year, month+1, dayOfMonth));
                        timePickerDialog.setTitle("시간을 선택하세요.");
                        timePickerDialog.show();
                    }
                }, year, month, day);
                datePickerDialog.setTitle("날짜를 선택하세요.");
                datePickerDialog.show();
            }
        });

        return v;
    }

}