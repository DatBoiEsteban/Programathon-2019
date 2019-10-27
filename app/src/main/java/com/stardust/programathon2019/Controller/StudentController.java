package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Model.LoginResult;
import com.stardust.programathon2019.Network.StudentService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

public class StudentController {

    public static void getMyStudents(){
        final Session session = SessionManager.getInstance().getSession();

        StudentService service = session.createService(StudentService.class);
        Call<ResponseBody> call = service.GetMyStudent();
        //System.out.println(call.toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    if(response.body() == null) return;

                    Kid[] entity = objectMapper.readValue(response.body().string(), Kid[].class);
                    System.out.println(entity);
                    //session.setLogged(true);
                    //session.setLogin(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //callback.onComplete();
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
                session.setLogged(false);
                //callback.onComplete();

            }
        });

    }

}
