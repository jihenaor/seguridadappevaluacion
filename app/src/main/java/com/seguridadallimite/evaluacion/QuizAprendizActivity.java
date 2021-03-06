package com.seguridadallimite.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.common.Constantes;
import com.seguridadallimite.evaluacion.common.SharedPeferencesManager;
import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.model.RequestAuth;
import com.seguridadallimite.evaluacion.model.ResponseAuth;
import com.seguridadallimite.evaluacion.model.Respuesta;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizAprendizActivity extends AppCompatActivity  implements  View.OnClickListener {

    TextView txt_pregunta;
    Button btn_calificar;
    Button btn_continuar;
    RadioGroup radioGroup;
    private TextView txt_contador_pregunta;
    int contadorPregunta;
    SeguridadServices service;
    SeguridadClient client;
    private List<Pregunta> preguntas;
    private Pregunta preguntaseleccionada;
    private int indice_pregunta;
    private int contadorOK;
    private int contadorError;

    private int ids_respuestas[] = {
            R.id.rb_respuesta1,
            R.id.rb_respuesta2,
            R.id.rb_respuesta3,
            R.id.rb_respuesta4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_aprendiz);
        findView();

        contadorPregunta = 1;

        retrofitInit();

        inicializarVariables();
        findPreguntas();

        events();

        btn_continuar.setVisibility(View.GONE);
    }

    private void inicializarVariables() {
        indice_pregunta = 0;
        contadorOK = 0;
        contadorError = 0;
    }

    private void events() {
        btn_calificar.setOnClickListener(this);
        btn_continuar.setOnClickListener(this);
    }

    private void findView() {
        txt_pregunta = (TextView) findViewById(R.id.txt_pregunta);
        txt_contador_pregunta = (TextView) findViewById(R.id.txt_contador_pregunta);
        btn_calificar = (Button) findViewById(R.id.btn_calificar);
        btn_continuar = (Button) findViewById(R.id.btn_continuar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    private void retrofitInit() {
        client = SeguridadClient.getInstance();

        service = client.getService();
    }

    private void inicializarPregunta() {
        preguntaseleccionada = preguntas.get(indice_pregunta);
        txt_pregunta.setText(preguntaseleccionada.getPregunta() + preguntaseleccionada.getNumerorespuestacorrecta().intValue());
        int i = 0;
        for (Respuesta respuesta: preguntaseleccionada.getRespuestas()) {
            if (i <= 3) {
                RadioButton rb = (RadioButton) findViewById(ids_respuestas[i++]);
                rb.setText(respuesta.getRespuesta());
            }

        }
        txt_contador_pregunta.setText(indice_pregunta + 1 + " / " + preguntas.size());
    }

    private void findPreguntas() {
        String idaprendiz = SharedPeferencesManager.getSomeStringValue(Constantes.PREF_ID_APRENDIZ);

        Call<List<Pregunta>> call = service.doPreguntasevaluacionaprendiz(idaprendiz);

        call.enqueue(new Callback<List<Pregunta>>() {
            @Override
            public void onResponse(Call<List<Pregunta>> call, Response<List<Pregunta>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(QuizAprendizActivity.this, "Quiz consultado con exito", Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()) {
                        preguntas = response.body();
                        if (preguntas.isEmpty()) {

                        } else {
                            inicializarPregunta();
                        }
//                    SharedPeferencesManager.setSomeStringValue(Constantes.PREF_NUMERO_DOCUMENTO, documento);
//                    SharedPeferencesManager.setSomeStringValue(Constantes.PREF_PERFIL, response.body().getPerfil());
//                    if (response.body().getPerfil().equals("A")) {
//                        SharedPeferencesManager.setSomeStringValue(Constantes.PREF_NOMBRE_APRENDIZ, response.body().getAprendiz().getTrabajador().getPrimernombre());
//                    }

                    }
                } else {
                    Toast.makeText(QuizAprendizActivity.this, "Algo fue mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Pregunta>> call, Throwable t) {
                Toast.makeText(QuizAprendizActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void activarRespuestas(Boolean estado) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(estado);
        }
    }

    private void calificar() {

        int id = radioGroup.getCheckedRadioButtonId();
        int indice = -1;
        for (int i = 0; i < ids_respuestas.length; i++) {
            if (ids_respuestas[i] == id) {
                indice = i;
            }
        }

        if (indice == -1) {
            Toast.makeText(QuizAprendizActivity.this, "Debe seleccionar una respuesta", Toast.LENGTH_SHORT).show();
            return;
        } else {
            activarRespuestas(false);
            if (preguntaseleccionada.getNumerorespuestacorrecta().intValue() == indice + 1) {
                preguntaseleccionada.setRespuestacorrecta("S");
                contadorOK++;
                Toast.makeText(QuizAprendizActivity.this, "La respuesta es correcta", Toast.LENGTH_SHORT).show();
            } else {
                contadorError++;
                Toast.makeText(QuizAprendizActivity.this, "La respuesta no es correcta", Toast.LENGTH_SHORT).show();
                preguntaseleccionada.setRespuestacorrecta("N");
            }
        }
        if (indice_pregunta == preguntas.size() -1) {
            btn_continuar.setText("Finalizar");
        }
        btn_calificar.setVisibility(View.GONE);
        btn_continuar.setVisibility(View.VISIBLE);
        radioGroup.clearCheck();
    }

    private void continuar() {
        if (indice_pregunta == preguntas.size() -1) {

        } else {
            if (indice_pregunta <= preguntas.size()) {
                indice_pregunta ++;
                activarRespuestas(true);
                inicializarPregunta();
                btn_calificar.setVisibility(View.VISIBLE);
                btn_continuar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_calificar:
                calificar();
                break;
            case R.id.btn_continuar:
                continuar();
                break;
        }
    }
}
