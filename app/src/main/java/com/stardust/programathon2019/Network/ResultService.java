package com.stardust.programathon2019.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ResultService {

    @GET("/ApiServer/api/Result/GetResultByAttendanceId")
    Call<ResponseBody> GetResultByAttendanceId(@Query("attendanceId") Integer attendanceId);
}
