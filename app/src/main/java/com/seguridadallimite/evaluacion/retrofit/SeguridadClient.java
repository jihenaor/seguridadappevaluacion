package com.seguridadallimite.evaluacion.retrofit;

import com.seguridadallimite.evaluacion.common.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeguridadClient {
    private static SeguridadClient instance = null;
    private SeguridadServices service;
    private Retrofit retrofit;

    public SeguridadClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SeguridadServices.class);
    }

    public static SeguridadClient getInstance() {
        if (instance == null) {
            instance = new SeguridadClient();
        }

        return instance;
    }

    public SeguridadServices getService() {
        return service;
    }
}
