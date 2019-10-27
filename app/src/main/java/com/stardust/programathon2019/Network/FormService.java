package com.stardust.programathon2019.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FormService {

    @GET("/ApiServer/api/Form/GetByName")
    Call<ResponseBody> GetByName(@Query("formHeaderName") String name);
}
