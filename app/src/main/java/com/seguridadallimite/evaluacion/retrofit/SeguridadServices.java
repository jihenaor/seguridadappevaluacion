package com.seguridadallimite.evaluacion.retrofit;

import com.seguridadallimite.evaluacion.model.Grupo;
import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.model.RequestAuth;
import com.seguridadallimite.evaluacion.model.ResponseAuth;
import com.seguridadallimite.evaluacion.model.Viaprendiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SeguridadServices {

    @POST("authenticate")
    Call<ResponseAuth> doLogin(@Body RequestAuth requestAuth);

    @GET("preguntasevaluacionaprendiz/{idaprendiz}")
    Call<List<Pregunta>> doPreguntasevaluacionaprendiz(@Path("idaprendiz") String idaprendiz);

    @GET("gruposactivosevaluacionpractica/{idinstructor}")
    Call<List<Grupo>> doGruposactivosevaluacionpractica(@Path("idinstructor") String idinstructor);

    @GET("aprendizgrupoevaluacion/{idgrupo}")
    Call<List<Viaprendiz>> doAprendizgrupoevaluacion(@Path("idgrupo") String idgrupo);


}
