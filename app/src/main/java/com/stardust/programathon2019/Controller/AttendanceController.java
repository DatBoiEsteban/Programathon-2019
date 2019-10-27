package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AttendanceRequest;
import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.Awaitable;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Network.AttendaceService;
import com.stardust.programathon2019.Network.StudentService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceController {

    /**
     * @returns Attendance
     */
    public static void getAttendanceByStudentId(int studentId, AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;


        AttendaceService service = session.createService(AttendaceService.class);
        Call<ResponseBody> call = service.getByStudentId(studentId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.println(response.body());
                    if(response.body() == null) return;

                    Attendance[] entity = objectMapper.readValue(response.body().string(), Attendance[].class);
                    //System.out.println(entity);
                    //System.out.println("!---------------------------");
                    callback.onComplete(entity);

                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onComplete(null);
                }
                //callback.onComplete();
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
                //callback.onComplete();
                callback.onComplete(null);

            }
        });
    }


    public static void addAttendance(AttendanceRequest attendance, Awaitable awt) {
        final Session session = SessionManager.getInstance().getSession();
        //final AwaitableResponse callback  = awt;


        AttendaceService service = session.createService(AttendaceService.class);
        Call<ResponseBody> call = service.addAttendance(attendance);
        final Awaitable callback = awt;
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.isSuccessful());
                callback.onComplete();
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
                //callback.onComplete();
                callback.onComplete();

            }
        });
    }
}
