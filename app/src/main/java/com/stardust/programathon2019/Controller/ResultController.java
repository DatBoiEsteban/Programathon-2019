package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.AreaResult;
import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Result;
import com.stardust.programathon2019.Model.ResultASQ;
import com.stardust.programathon2019.Network.AttendaceService;
import com.stardust.programathon2019.Network.ResultService;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultController {

    public static void GetResultByAttendanceId(int attendanceId, AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;


        ResultService service = session.createService(ResultService.class);
        Call<ResponseBody> call = service.GetResultByAttendanceId(attendanceId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.println(response.body());
                    if(response.body() == null) return;

                    AttendanceResult entity = objectMapper.readValue(response.body().string(), AttendanceResult.class);
                    /*System.out.println(entity.getResultList().size());
                    for(AreaResult res : entity.getResultList()){
                        System.out.println(res.getAreaId());
                        for(Result testRes : res.getResults()){
                            System.out.println(testRes.getId() + "---" + testRes.getValue());
                        }
                    }*/

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

    public static void addResult(AttendanceResult newResult, AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;
        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonStr = objectMapper.writeValueAsString(newResult);
            System.out.println( jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        ResultService service = session.createService(ResultService.class);
        Call<ResponseBody> call = service.addResults(newResult);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.isSuccessful());
                System.out.println(response.message());
                if(response.body() == null) {
                    callback.onComplete(null);
                    return;
                }

                Integer entity = null;
                try {
                    entity = objectMapper.readValue(response.body().string(), Integer.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(response.message());
                callback.onComplete(entity);

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
}
