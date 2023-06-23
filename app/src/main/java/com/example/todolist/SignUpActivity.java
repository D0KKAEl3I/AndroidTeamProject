package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignUp;
    EditText userId, userPw, checkUserPw;

    TextView goLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignUp = findViewById(R.id.btnSignUp);
        userId = findViewById(R.id.userId);
        userPw = findViewById(R.id.userPw);
        checkUserPw = findViewById(R.id.checkUserPw);
        goLogin = findViewById(R.id.goLogin);

        goLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userId.getText().toString();
                String pw = userPw.getText().toString();
                String chkPw = checkUserPw.getText().toString();

                if (id.equals("") || id == null) {
                    ToastMessageEvent("아이디를 입력해주세요.");
                }
                else if (pw.equals("") || pw == null) {
                    ToastMessageEvent("비밀번호를 입력해주세요.");
                }
                else if (chkPw.equals("") || chkPw == null) {
                    ToastMessageEvent("비밀번호가 일치하지않습니다.");
                }
                else {
                    // 서버 통신
                    LoginForm loign = new LoginForm(id, pw);
                    Call<LoginForm> call = RetrofitClient.getApiService().login(loign);

                    call.enqueue(new Callback<LoginForm>() {
                        //콜백 받는 부분
                        @Override
                        public void onResponse(Call<LoginForm> call, Response<LoginForm> response) {
                            // 회원가입 성공 시 아래 코드 넣어주면 됨.
                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<LoginForm> call, Throwable t) {
                            boolean test = false; // responce 값으로 바꿔주면 됨.
                            if (test) {
                                // responce 동일한 아이디가 있을 때
                                ToastMessageEvent("메세지");
                            } else if (test) {
                                // 비밀번호가 잘못 되었을 때
                                ToastMessageEvent("메세지");
                            }
                        }
                    });
                }
            }
        });
    }

    private void ToastMessageEvent(String message) {
        Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}