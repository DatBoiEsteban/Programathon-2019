package com.stardust.programathon2019.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClassRoomService {

    @POST("/ApiServer/api/ClassRoom/GetMyClassRoom")
    Call<ResponseBody> GetMyClassRoom();
}
