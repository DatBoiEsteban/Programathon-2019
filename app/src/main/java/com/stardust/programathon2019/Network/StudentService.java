package com.stardust.programathon2019.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface StudentService {

    @GET("/ApiServer/api/Student/GetMyStudent")
    Call<ResponseBody> GetMyStudent();

    @GET("/ApiServer/api/Student/GetByClassRoom")
    Call<ResponseBody> GetByClassRoom();

    @GET("/ApiServer/api/Student/GetByClassName")
    Call<ResponseBody> GetByClassName();

    @GET("/ApiServer/api/Student/GetByDNI")
    Call<ResponseBody> GetByDNI();

    @POST("/ApiServer/api/Student/GetMyStudent")
    Call<ResponseBody> AddStudent();
}
