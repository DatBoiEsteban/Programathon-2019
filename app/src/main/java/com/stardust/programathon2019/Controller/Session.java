package com.stardust.programathon2019.Controller;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stardust.programathon2019.Model.Awaitable;
import com.stardust.programathon2019.Model.LoginRequest;
import com.stardust.programathon2019.Model.LoginResult;
import com.stardust.programathon2019.Model.UserInfo;
import com.stardust.programathon2019.Network.SessionService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Session {
    private boolean logged;
    private String token;
    private LoginResult login;

    public Session() {

    }



    public void login(String username, String password, Awaitable cl) {
        final Awaitable callback = cl;
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
                    System.out.println(entity.getAccess_token());
                    session.setLogged(true);
                    session.setLogin(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                callback.onComplete();
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
                session.setLogged(false);
                callback.onComplete();

            }
        });



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

    public LoginResult getLogin() {
        return login;
    }

    public void setLogin(LoginResult login) {
        this.login = login;
    }
}
