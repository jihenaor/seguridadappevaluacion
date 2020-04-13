package com.seguridadallimite.evaluacion.retrofit;

import com.seguridadallimite.evaluacion.common.SharedPeferencesManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = SharedPeferencesManager.getSomeStringValue("xx");

        Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token).build();

        return chain.proceed(request);
    }
}
