package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    TextView textView;
    EditText userId, userPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btnLogin);
        textView = findViewById(R.id.txtSignUp);
        userId = findViewById(R.id.userId);
        userPw = findViewById(R.id.userPw);

        //btn_login Button의 Click이벤트
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userId.getText().toString();
                String pw = userPw.getText().toString();

                if (id.equals("") || id == null) {
                    ToastMessageEvent("아이디를 입력해주세요.");
                }
                else if (pw.equals("") || pw == null) {
                    ToastMessageEvent("비밀번호를 입력해주세요.");
                }
                else {
                    // 서버 통신
                    LoginForm loign = new LoginForm(id, pw);
                    Call<ResponseLogin> call = RetrofitClient.getApiService().login(loign);
                    call.enqueue(new Callback<ResponseLogin>() {
                        //콜백 받는 부분
                        @Override
                        public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                            // 로그인 성공 시 아래 코드 넣어주면 됨.
                            if(response.body().getLogin().equals("pass")){
                            Intent intent = new Intent(MainActivity.this,ListActivity.class);
                            startActivity(intent);
                            } else{
                                ToastMessageEvent("로그인 실패");
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseLogin> call, Throwable t) {
                            boolean test = false; // responce 값으로 바꿔주면 됨.
                            ToastMessageEvent("로그인 실패");
                        }
                    });
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ToastMessageEvent(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}