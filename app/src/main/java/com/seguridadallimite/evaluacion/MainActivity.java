package com.seguridadallimite.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.R;
import com.seguridadallimite.evaluacion.common.Constantes;
import com.seguridadallimite.evaluacion.common.SharedPeferencesManager;
import com.seguridadallimite.evaluacion.model.RequestAuth;
import com.seguridadallimite.evaluacion.model.ResponseAuth;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button btn_login;
    EditText txt_numerodocumento;
    SeguridadClient client;
    SeguridadServices service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        client = SeguridadClient.getInstance();

        service = client.getService();
    }

    private void events() {
        btn_login.setOnClickListener(this);
    }

    private void findViews() {
        btn_login = findViewById(R.id.btn_login);
        txt_numerodocumento = findViewById(R.id.txt_numerodocumento);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_login:
                gotoLogin();
                break;
        }
    }

    private void gotoLogin() {
        String documento = txt_numerodocumento.getText().toString();

        if (documento.isEmpty()) {
            txt_numerodocumento.setError("El numero de documento es requerido");
            return;
        }

        RequestAuth requestAuth = new RequestAuth();

        requestAuth.setNumerodocumento(documento);

        Call<ResponseAuth> call = service.doLogin(requestAuth);

        call.enqueue(new Callback<ResponseAuth>() {
            @Override
            public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Sesión iniciada correctamente", Toast.LENGTH_SHORT).show();

                    SharedPeferencesManager.setSomeStringValue(Constantes.PREF_NUMERO_DOCUMENTO, documento);
                    SharedPeferencesManager.setSomeStringValue(Constantes.PREF_PERFIL, response.body().getPerfil());
                    if (response.body().getPerfil().equals("A")) {
                        SharedPeferencesManager.setSomeStringValue(Constantes.PREF_NOMBRE_APRENDIZ, response.body().getAprendiz().getTrabajador().getPrimernombre());
                    }

                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(i);
                    // Destruir activity login
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Algo fue mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAuth> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
