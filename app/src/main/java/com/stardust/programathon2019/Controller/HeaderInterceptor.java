package com.stardust.programathon2019.Controller;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor{



    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
        Request request = builder.build();
        return chain.proceed(request);
    }
}
