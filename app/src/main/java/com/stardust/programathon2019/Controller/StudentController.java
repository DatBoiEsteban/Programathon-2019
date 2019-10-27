package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Model.LoginResult;
import com.stardust.programathon2019.Network.StudentService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

public class StudentController {

    /**
     * @returns Kid[]
     */
    public static void getMyStudents(AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;



        StudentService service = session.createService(StudentService.class);
        Call<ResponseBody> call = service.GetMyStudents();
        //System.out.println(call.toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    //System.out.println("-------------------------------------------------------");
                    System.out.println(response.body());
                    if(response.body() == null) return;

                    Kid[] entity = objectMapper.readValue(response.body().string(), Kid[].class);
                    callback.onComplete(entity);
                    //System.out.println(entity.toString());
                    //System.out.println("------------------------******-----------------------------");
                    //session.setLogged(true);
                    //session.setLogin(entity);
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

    /**
     * @returns Kid[]
     */
    public static void getStudentByName(String name,AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;


        StudentService service = session.createService(StudentService.class);
        Call<ResponseBody> call = service.GetByName(name);
        //System.out.println(call.toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.println(response.body());
                    if(response.body() == null) return;

                    Kid[] entity = objectMapper.readValue(response.body().string(), Kid[].class);
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

    /**
     * @returns Kid[]
     */
    public static void getStudentByDNI(int dni,AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;


        StudentService service = session.createService(StudentService.class);
        Call<ResponseBody> call = service.GetByDNI(dni);
        //System.out.println(call.toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    System.out.println("-------------------------------------------------------");
                    System.out.println(response.body());
                    if(response.body() == null) return;

                    Kid entity = objectMapper.readValue(response.body().string(), Kid.class);
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

}
