package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    Button btn_login;
    EditText userId, userPw, checkUserPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        btn_login = findViewById(R.id.btnLogin);
        userId = findViewById(R.id.userId);
        userPw = findViewById(R.id.userPw);
        checkUserPw = findViewById(R.id.checkUserPw);

        //btn_login Button의 Click이벤트
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userId.getText().toString() == null && userId.getText().toString() == "") {
                    Toast.makeText(SignUpActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (userPw.getText().toString() == null && userPw.getText().toString() == "") {
                    Toast.makeText(SignUpActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (userPw.getText().toString().equals(checkUserPw.getText().toString()) == false) {
                    Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지않습니다..", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}