package com.stardust.programathon2019.Network;

import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AttendanceForm;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AttendaceService {
    @GET("/ApiServer/api/Attendance/GetAllAttendances")
    Call<ResponseBody> getAllAtendances();

    @GET("/ApiServer/api/Attendance/GetById")
    Call<ResponseBody> getById(@Query("attendanceId") int id);

    @GET("/ApiServer/api/Attendance/GetByFormId")
    Call<ResponseBody> getByFormId(@Query("formId") int id);

    @GET("/ApiServer/api/Attendance/GetByStudentId")
    Call<ResponseBody> getByStudentId(@Query("studentId") int id);

    @GET("/ApiServer/api/Attendance/GetByApplicatorId")
    Call<ResponseBody> getByApplicatorId(@Query("applicatorId") int id);

    @POST("/ApiServer/api/Attendance/AddAttendance")
    Call<ResponseBody> addAttendance(@Body Attendance body);
}
