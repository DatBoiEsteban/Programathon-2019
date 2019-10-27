package com.stardust.programathon2019.Network;

import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.ResultASQ;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ResultService {

    @GET("/ApiServer/api/Result/GetResultByAttendanceId")
    Call<ResponseBody> GetResultByAttendanceId(@Query("attendanceId") Integer attendanceId);
    @POST("/ApiServer/api/Result/updateResult")
    Call<ResponseBody> updateResults(@Body List<ResultASQ> results);

    @Headers("Content-Type:application/json-patch+json")
    @POST("/ApiServer/api/Result/AddResults")
    Call<ResponseBody> addResults(@Body AttendanceResult results);
}
