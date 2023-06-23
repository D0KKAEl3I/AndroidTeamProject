package com.example.todolist;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {

    /* GET
    특정 날짜의 투두 리스트 조회. 조회할 날짜 파라미터는 ?date=yyyyMMdd 형식으로 보냄
    [
        {
            id: 1, // 고유 식별값
            title: "제목",
            dateTime: LocalDateTime, // 날짜 형태면 됨
            completed: false // 완료 여부
        },
        {
            id: 2, // 고유 식별값
            title: "제목2",
            dateTime: LocalDateTime,
            completed: true
        }
    ]
    */
    Call<ArrayList<Todo>> getTodoList(
            @Query("date") String dateString
    );

    /*
    * GET
    *특정 투두 조회. 고유 식별값으로 조회
    * {
    *   id: 1, // 고유 식별값
    *   title: "제목",
    *   dateTime: LocalDateTime, // 날짜 형태면 됨
    *   completed: false // 완료 여부
    * }
    *  */
    Call<ArrayList<Todo>> getTodo(
            @Path("todoId") int todoId
    );


    /* POST
     * 투두 추가
     * {
     *   title: "제목3",
     *   dateTime: LocalDateTime
     * }
     */
    @POST("todo")
    Call<Todo> createTodo(
            @Body TodoForm body
    );

    /* PUT
    * 투두 수정
    * 데이터 형태는 등록과 같음
    * 패스 파라미터로 아이디 들어감
    * */
    @PUT("todo/{todoId}")
    Call<Todo> updateTodo(
            @Path("todoId") int todoId,
            @Body TodoForm body
    );

    /* DELETE
    * 투두 삭제
    * */
    @DELETE("todo/{todoId}")
    Call<Todo> deleteTodo(
            @Path("todoId") int todoId
    );

}
