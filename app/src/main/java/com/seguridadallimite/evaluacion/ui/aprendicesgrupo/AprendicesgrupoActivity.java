package com.seguridadallimite.evaluacion.ui.aprendicesgrupo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.R;
import com.seguridadallimite.evaluacion.model.Viaprendiz;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;
import com.seguridadallimite.evaluacion.ui.evaluacionpractica.EvaluacionpracticaActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AprendicesgrupoActivity extends AppCompatActivity {
    String idgrupo;
    ListView listViewAprendices;
    List<Viaprendiz> viaprendizs;

    SeguridadServices service;
    SeguridadClient client;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprendicesgrupo);

        idgrupo = getIntent().getStringExtra("idgrupo");

        findViews();

        retrofitInit();

        loadAprendices();
    }

    private void findViews() {
        listViewAprendices = findViewById(R.id.listViewAprendicesgrupo);
    }

    private void retrofitInit() {
        client = SeguridadClient.getInstance();

        service = client.getService();
    }

    private void loadAprendices() {
        Call<List<Viaprendiz>> call = service.doAprendizgrupoevaluacion(idgrupo);

        call.enqueue(new Callback<List<Viaprendiz>>() {
            @Override
            public void onResponse(Call<List<Viaprendiz>> call, Response<List<Viaprendiz>> response) {
                if (response.isSuccessful()) {
                    // Toast.makeText(QuizAprendizActivity.this, "Quiz consultado con exito", Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()) {
                        viaprendizs = response.body();

                        ViaprendizAdapter adapter = new ViaprendizAdapter(AprendicesgrupoActivity.this, viaprendizs);

                        listViewAprendices.setAdapter(adapter);

                        listViewAprendices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent = new Intent(AprendicesgrupoActivity.this, EvaluacionpracticaActivity.class);
                                intent.putExtra("idgrupo", viaprendizs.get(i).getIdaprendiz().toString());

                                startActivity(intent);

                                Toast.makeText(AprendicesgrupoActivity.this, viaprendizs.get(i).getNombreaprendiz(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        return;
                    }
                } else {
                    Toast.makeText(AprendicesgrupoActivity.this, "Problemas de conexion 1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Viaprendiz>> call, Throwable t) {
                Log.i("On login", t.getMessage());
                Toast.makeText(AprendicesgrupoActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}