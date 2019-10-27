package com.stardust.programathon2019.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface StudentService {

    @GET("/ApiServer/api/Student/GetMyStudents")
    Call<ResponseBody> GetMyStudents();

    @GET("/ApiServer/api/Student/GetByClassRoom")
    Call<ResponseBody> GetByClassRoom();

    @GET("/ApiServer/api/Student/GetByName")
    Call<ResponseBody> GetByName(@Query("studentName") String name );

    @GET("/ApiServer/api/Student/GetByClassName")
    Call<ResponseBody> GetByClassName();

    @GET("/ApiServer/api/Student/GetByDNI")
    Call<ResponseBody> GetByDNI();

    @POST("/ApiServer/api/Student/GetMyStudent")
    Call<ResponseBody> AddStudent();
}
