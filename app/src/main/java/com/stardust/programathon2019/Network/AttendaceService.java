package com.stardust.programathon2019.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AttendaceService {
    @GET("/ApiServer/api/Atendance/GetAllAtendances")
    Call<ResponseBody> getAllAtendances();

    @GET("/ApiServer/api/Atendance/GetById")
    Call<ResponseBody> getById(@Query("attendanceId") int id);

    @GET("/ApiServer/api/Atendance/GetByFormId")
    Call<ResponseBody> getByFormId(@Query("formId") int id);

    @GET("/ApiServer/api/Atendance/GetByStudentId")
    Call<ResponseBody> getByStudentId(@Query("studentId") int id);

    @GET("/ApiServer/api/Atendance/GetByApplicatorId")
    Call<ResponseBody> getByApplicatorId(@Query("applicatorId") int id);
}
