package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Form;
import com.stardust.programathon2019.Model.FullForm;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Network.FormService;
import com.stardust.programathon2019.Network.StudentService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormController {

    /**
     * @returns Kid[]
     */
    public static void getByName(String fromName, AwaitableResponse awt){
        final Session session = SessionManager.getInstance().getSession();
        final AwaitableResponse callback  = awt;


        FormService service = session.createService(FormService.class);
        Call<ResponseBody> call = service.GetByName(fromName);
        //System.out.println(call.toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    //System.out.println("-------------------------------------------------------");
                    //System.out.println(response.body());
                    if(response.body() == null) return;

                    FullForm entity = objectMapper.readValue(response.body().string(), FullForm.class);
                    //System.out.println(entity.getName());
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
