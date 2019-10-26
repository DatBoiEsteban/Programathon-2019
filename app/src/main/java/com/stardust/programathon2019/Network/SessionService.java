package com.stardust.programathon2019.Network;

import com.stardust.programathon2019.Model.TempUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SessionService {
    @POST("/ApiServer/api/login")
    Call<TempUser> login();

    @POST("/login")
    Call<TempUser> logOut();
}
