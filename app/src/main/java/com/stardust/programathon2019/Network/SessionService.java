package com.stardust.programathon2019.Network;

import com.stardust.programathon2019.Model.LoginRequest;
import com.stardust.programathon2019.Model.LoginResult;
import com.stardust.programathon2019.Model.TempUser;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SessionService {
    @POST("/ApiServer/api/login")
    Call<ResponseBody> login(@Body LoginRequest request);

    @POST("/login")
    Call<TempUser> logOut();
}
