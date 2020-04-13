package com.seguridadallimite.evaluacion.retrofit;

import com.seguridadallimite.evaluacion.model.RequestAuth;
import com.seguridadallimite.evaluacion.model.ResponseAuth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SeguridadServices {

    @POST("api/auth")
    Call<ResponseAuth> doLogin(@Body RequestAuth requestAuth);
/*
    @GET("api/preguntarniveltipoevaluacion//{idnivel}/{tipoevaluacion}")
    Call<ResponseAuth> doLogin(@Body RequestAuth requestAuth);
*/
}
