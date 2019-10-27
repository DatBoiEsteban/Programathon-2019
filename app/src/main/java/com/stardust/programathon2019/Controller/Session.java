package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.LoginRequest;
import com.stardust.programathon2019.Model.LoginResult;
import com.stardust.programathon2019.Network.SessionService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Session {
    private boolean logged;
    private String token;

    public Session() {

    }



    public boolean login(String username, String password) {

        final Session session = this;

        SessionService service = ServiceGenerator.createService(SessionService.class);
        Call<ResponseBody> call = service.login(new LoginRequest(username,password));
        //System.out.println(call.toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    if(response.body() == null) return;

                    LoginResult entity = objectMapper.readValue(response.body().string(), LoginResult.class);
                    //System.out.println(entity.getAccess_token());
                    session.setLogged(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
                session.setLogged(false);

            }
        });

        return logged;
    }



    public <S> S createService(Class<S> serviceClass){
        if(logged)
            return ServiceGenerator.createService(serviceClass,token);
        else
            return ServiceGenerator.createService(serviceClass);

    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
