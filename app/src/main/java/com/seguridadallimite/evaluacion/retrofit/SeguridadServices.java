package com.seguridadallimite.evaluacion.retrofit;

import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.model.RequestAuth;
import com.seguridadallimite.evaluacion.model.ResponseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SeguridadServices {

    @POST("api/auth")
    Call<ResponseAuth> doLogin(@Body RequestAuth requestAuth);

    @GET("api/preguntarniveltipoevaluacion/{idnivel}/{tipoevaluacion}")
    Call<List<Pregunta>> doPreguntaniveltipoevaluacion(@Path("idnivel") String idnivel,
                                                       @Path("tipoevaluacion") String tipoevaluacion);
}
