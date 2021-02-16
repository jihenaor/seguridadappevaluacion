package com.seguridadallimite.evaluacion.ui.evaluacionpractica;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.R;
import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.model.Respuesta;
import com.seguridadallimite.evaluacion.model.RespuestaWs;
import com.seguridadallimite.evaluacion.model.Viaprendiz;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;
import com.seguridadallimite.evaluacion.ui.aprendicesgrupo.AprendicesgrupoActivity;
import com.seguridadallimite.evaluacion.ui.aprendicesgrupo.ViaprendizAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvaluacionpracticaActivity extends AppCompatActivity implements  View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Boolean isOpen = false;
    private FloatingActionButton fab;
    private FloatingActionButton fabNudos;
    private FloatingActionButton fabReconocimientoequipos;
    private FloatingActionButton fabTecnicastrabajoalturas;
    private FloatingActionButton fabTecnicasrescate;
    private FloatingActionButton fabProcedimientotrabajoseguroalturas;

    private TextView editTextNudos;
    private TextView editTextReconocimientoEquipos;
    private TextView editTextTecnicastrabajoalturas;
    private TextView editTextTecnicasrescate;
    private TextView editTextProcedimientotrabajoseguroalturas;

    private Button buttonActualizarevaluacionPractica;

    private String idaprendiz;

    SeguridadServices service;
    SeguridadClient client;

    private List<Pregunta> preguntasOriginal;

    private List<Pregunta> preguntas;

    private ListView listViewPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacionpractica);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idaprendiz = getIntent().getStringExtra("idaprendiz");

        findViews();
        events();

        retrofitInit();

        loadPreguntas();
    }

    private void findViews() {
        fab = findViewById(R.id.fab);
        fabNudos = findViewById(R.id.fabNudos);
        fabReconocimientoequipos = findViewById(R.id.fabReconocimientoEquipos);
        fabTecnicastrabajoalturas = findViewById(R.id.fabTecnicastrabajoalturas);
        fabTecnicasrescate = findViewById(R.id.fabTecnicasrescate);
        fabProcedimientotrabajoseguroalturas = findViewById(R.id.fabProcedimientotrabajoseguroalturas);

        editTextNudos = findViewById(R.id.editTextNudos);
        editTextReconocimientoEquipos = findViewById(R.id.editTextReconocimientoEquipos);
        editTextTecnicastrabajoalturas = findViewById(R.id.editTextTecnicatrabajoalturas);
        editTextTecnicasrescate = findViewById(R.id.editTextTecnicasrescate);
        editTextProcedimientotrabajoseguroalturas = findViewById(R.id.editTextProcedimientotrabajoalturas);

        listViewPreguntas = findViewById(R.id.listViewPreguntaevaluacionpractica);

        buttonActualizarevaluacionPractica = findViewById(R.id.buttonActualizarevaluacionPractica);

        hacervisibleBotones(View.GONE);

//        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
//        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
//        fabNudos = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.);
//        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_fab_anticlock);
    }

    private void events() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {
                    //textview_mail.setVisibility(View.INVISIBLE);
                    // textview_share.setVisibility(View.INVISIBLE);
//                    fabNudos.startAnimation(fab_close);
                    //                  fabReconocimientoequipos.startAnimation(fab_close);

                    hacervisibleBotones(View.GONE);

                    fabNudos.setClickable(false);
                    fabReconocimientoequipos.setClickable(false);

                    inicializarAdapter();
                } else {
                    //textview_mail.setVisibility(View.VISIBLE);
                    //textview_share.setVisibility(View.VISIBLE);
                    //                fabNudos.startAnimation(fab_open);
                    //              fabReconocimientoequipos.startAnimation(fab_open);

                    hacervisibleBotones(View.VISIBLE);

                    fabNudos.setClickable(true);
                    fabReconocimientoequipos.setClickable(true);
                }
                isOpen = !isOpen;
            }
        });

        buttonActualizarevaluacionPractica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEvaluacion();
            }
        });

        fabNudos.setOnClickListener(this);
        fabReconocimientoequipos.setOnClickListener(this);
        fabProcedimientotrabajoseguroalturas.setOnClickListener(this);
        fabTecnicasrescate.setOnClickListener(this);
        fabTecnicastrabajoalturas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int grupo = 0;
        switch (id) {
            case R.id.fabNudos:
                hacervisibleBotones(View.GONE);
                grupo = 3;
                break;
            case R.id.fabReconocimientoEquipos:
                hacervisibleBotones(View.GONE);
                grupo = 4;
                break;
            case R.id.fabTecnicastrabajoalturas:
                hacervisibleBotones(View.GONE);
                grupo = 5;
                break;
            case R.id.fabTecnicasrescate:
                hacervisibleBotones(View.GONE);
                grupo = 6;
                break;
            case R.id.fabProcedimientotrabajoseguroalturas:
                hacervisibleBotones(View.GONE);
                grupo = 7;
                break;
        }
        preguntas = new ArrayList();

        for (Pregunta pregunta: preguntasOriginal) {
            if (pregunta.getGrupo().getId() == grupo) {
                preguntas.add(pregunta);
            }
        }

        PreguntaAdapter adapter = new PreguntaAdapter(EvaluacionpracticaActivity.this, preguntas);

        listViewPreguntas.setAdapter(adapter);

        isOpen = !isOpen;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // do something when check is selected
        } else {
            //do something when unchecked
        }
    }

    private void hacervisibleBotones(int visible) {
        fabNudos.setVisibility(visible);
        fabReconocimientoequipos.setVisibility(visible);
        fabTecnicastrabajoalturas.setVisibility(visible);
        fabTecnicasrescate.setVisibility(visible);
        fabProcedimientotrabajoseguroalturas.setVisibility(visible);

        editTextNudos.setVisibility(visible);
        editTextReconocimientoEquipos.setVisibility(visible);
        editTextTecnicastrabajoalturas.setVisibility(visible);
        editTextTecnicasrescate.setVisibility(visible);
        editTextProcedimientotrabajoseguroalturas.setVisibility(visible);
        if (visible == View.GONE) {
            listViewPreguntas.setVisibility(View.VISIBLE);
        } else {
            listViewPreguntas.setVisibility(View.GONE);
        }

    }

    private void retrofitInit() {
        client = SeguridadClient.getInstance();

        service = client.getService();
    }

    private void inicializarAdapter() {
        preguntas = new ArrayList();

        for (Pregunta pregunta: preguntasOriginal) {
            preguntas.add(pregunta);
        }

        PreguntaAdapter adapter = new PreguntaAdapter(EvaluacionpracticaActivity.this, preguntas);

        listViewPreguntas.setAdapter(adapter);
    }
    private void loadPreguntas() {
        Call<List<Pregunta>> call = service.doEvaluacionpracticamovil(idaprendiz);

        call.enqueue(new Callback<List<Pregunta>>() {
            @Override
            public void onResponse(Call<List<Pregunta>> call, Response<List<Pregunta>> response) {
                if (response.isSuccessful()) {
                    // Toast.makeText(QuizAprendizActivity.this, "Quiz consultado con exito", Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()) {
                        preguntasOriginal = response.body();

                        inicializarAdapter();

                        return;
                    }
                } else {
                    Toast.makeText(EvaluacionpracticaActivity.this, "Problemas de conexion 1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Pregunta>> call, Throwable t) {
                Log.i("On login", t.getMessage());
                Toast.makeText(EvaluacionpracticaActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void saveEvaluacion() {
        Call<RespuestaWs> call = service.doSaveevaluacionpracticamovil(preguntas);

        call.enqueue(new Callback<RespuestaWs>() {
            @Override
            public void onResponse(Call<RespuestaWs> call, Response<RespuestaWs> response) {
                if (response.isSuccessful()) {
                    // Toast.makeText(QuizAprendizActivity.this, "Quiz consultado con exito", Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()) {
                        RespuestaWs r = response.body();

                        Toast.makeText(EvaluacionpracticaActivity.this, r.getMsg(), Toast.LENGTH_SHORT).show();

                        return;
                    }
                } else {
                    Toast.makeText(EvaluacionpracticaActivity.this, "Problemas de conexion 1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespuestaWs> call, Throwable t) {
                Log.i("On login", t.getMessage());
                Toast.makeText(EvaluacionpracticaActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}