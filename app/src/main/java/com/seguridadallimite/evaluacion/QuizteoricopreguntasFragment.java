package com.seguridadallimite.evaluacion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.seguridadallimite.evaluacion.common.Constantes;
import com.seguridadallimite.evaluacion.common.SharedPeferencesManager;
import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.model.Respuesta;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizteoricopreguntasFragment extends Fragment   implements  View.OnClickListener{

    View view;
    TextView txt_pregunta;
    Button btn_continuar;
    RadioGroup radioGroup;
    private TextView txt_contador_pregunta;
    private TextView txtRespuestasCorrectas;
    private TextView txtRespuestasIncorrectas;

    private TextView txtPorcentaje;
    private TextView txtNota;

    int contadorPregunta;
    SeguridadServices service;
    SeguridadClient client;
    private List<Pregunta> preguntas;
    private Pregunta preguntaseleccionada;
    private int indice_pregunta;
    private int contadorOK;
    private int contadorError;
    private int indice;
    private Boolean termino = Boolean.FALSE;
    private ProgressBar progressBarAvance;

    Comunicador  comunicador;

    private int ids_respuestas[] = {
            R.id.rb_respuesta1,
            R.id.rb_respuesta2,
            R.id.rb_respuesta3,
            R.id.rb_respuesta4
    };

    public interface Comunicador {
        public void enviar(List<Pregunta> preguntas);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quizteoricopreguntas, container, false);

        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view = view;
        findView();

        contadorPregunta = 1;

        retrofitInit();

        inicializarVariables();
        findPreguntas();

        events();

        progressBarAvance.setProgress(0);

//        btn_continuar.setVisibility(View.GONE);
/*
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(QuizteoricopreguntasFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/
    }
    private void inicializarVariables() {
        indice_pregunta = 0;
        contadorOK = 0;
        contadorError = 0;
    }

    private void events() {
        btn_continuar.setOnClickListener(this);
    }

    private void findView() {
        txt_pregunta = (TextView) view.findViewById(R.id.txt_pregunta);
        txt_contador_pregunta = (TextView) view.findViewById(R.id.txt_contador_pregunta);
        btn_continuar = (Button) view.findViewById(R.id.btn_continuar);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        txtRespuestasCorrectas =  (TextView) view.findViewById(R.id.txtRespuestasCorrectas);
        txtRespuestasIncorrectas =  (TextView) view.findViewById(R.id.txtRespuestasIncorrectas);
        txtPorcentaje =  (TextView) view.findViewById(R.id.txtPorcentaje);
        txtNota =  (TextView) view.findViewById(R.id.txtNota);
        progressBarAvance = (ProgressBar) view.findViewById(R.id.progressBarAvance);
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
                RadioButton rb = (RadioButton) view.findViewById(ids_respuestas[i++]);
                rb.setText(respuesta.getRespuesta());
            }
        }
        txt_contador_pregunta.setText(indice_pregunta + 1 + " / " + preguntas.size());
        progressBarAvance.setMax(preguntas.size());
    }

    private void findPreguntas() {
        String idaprendiz = SharedPeferencesManager.getSomeStringValue(Constantes.PREF_ID_APRENDIZ);

        Call<List<Pregunta>> call = service.doPreguntasevaluacionaprendiz(idaprendiz);

        call.enqueue(new Callback<List<Pregunta>>() {
            @Override
            public void onResponse(Call<List<Pregunta>> call, Response<List<Pregunta>> response) {
                if (response.isSuccessful()) {
                    // Toast.makeText(QuizAprendizActivity.this, "Quiz consultado con exito", Toast.LENGTH_SHORT).show();

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
                    // Toast.makeText(QuizAprendizActivity.this, "Algo fue mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Pregunta>> call, Throwable t) {
                // Toast.makeText(QuizAprendizActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void activarRespuestas(Boolean estado) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(estado);
        }
    }

    private void ocultarRespuestas() {
        txt_pregunta.setVisibility(View.GONE);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setVisibility(View.GONE);
        }
    }

    private Boolean seleccionoRespuesta() {
        int id = radioGroup.getCheckedRadioButtonId();
        indice = -1;
        for (int i = 0; i < ids_respuestas.length; i++) {
            if (ids_respuestas[i] == id) {
                indice = i;

                return Boolean.TRUE;
            }
        }

        Toast.makeText(getActivity(), "Debe seleccionar una respuesta", Toast.LENGTH_SHORT).show();
        return Boolean.FALSE;
    }

    private void calificar(View v) {
        String msg;
        btn_continuar.setVisibility(View.GONE);
        activarRespuestas(false);
        int color;
        int textColor;
        if (preguntaseleccionada.getNumerorespuestacorrecta().intValue() == indice + 1) {
            preguntaseleccionada.setRespuestacorrecta("S");
            contadorOK++;
            msg = "Bien hecho !";
            color = Color.GREEN;
            textColor = Color.BLACK;
        } else {
            contadorError++;
            msg = "Debes repasar !";
            color = Color.RED;
            textColor = Color.WHITE;
            preguntaseleccionada.setRespuestacorrecta("N");
        }
        final Snackbar make = Snackbar.make(v, msg, Snackbar.LENGTH_INDEFINITE);

        View snackBarView = make.getView();
        snackBarView.setBackgroundColor(color);

        make.setAction("Continuar", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                make.dismiss();
                continuar();
                progressBarAvance.setProgress(indice_pregunta);
                btn_continuar.setVisibility(View.VISIBLE);

                if (indice_pregunta == preguntas.size() -1) {
                    btn_continuar.setText("Finalizar");
                }
//        btn_continuar.setVisibility(View.VISIBLE);
                radioGroup.clearCheck();
            }
        });

        TextView textView = snackBarView.findViewById(R.id.snackbar_text);
        textView.setTextColor(textColor);
        make.show();
    }

    private void calcularNotas() {
        Double nota;
        Double porcentaje;

        txtRespuestasCorrectas.setText("Respuestas correctas: " + contadorOK);
        txtRespuestasIncorrectas.setText("Respuestas incorrectas: " + contadorError);

        porcentaje = new Double(new Double(contadorOK) / new Double(preguntas.size())) * 100;

        txtPorcentaje.setText(porcentaje + " %");

        nota = new Double(new Double(contadorOK) / new Double(preguntas.size())) * 5;

        txtNota.setText("Nota: " + nota + ( nota > 3 ? "   Aprobó " : "    Reprobó"));
    }

    private void continuar() {
        if (indice_pregunta == preguntas.size() -1) {
            btn_continuar.setText("TERMINAR");
            calcularNotas();

            ocultarRespuestas();
        } else {
            if (indice_pregunta <= preguntas.size()) {
                indice_pregunta ++;
                activarRespuestas(true);
                inicializarPregunta();
                btn_continuar.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_continuar:
                if (termino) {
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);

                    getActivity().finish();
                } else {
                    if (seleccionoRespuesta()) {
                        calificar(v);

                        if (indice_pregunta == preguntas.size() -1) {
                            termino = Boolean.TRUE;
                        }
                    }
                }
                break;
                /*
                NavHostFragment.findNavController(QuizteoricopreguntasFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                comunicador.enviar(this.preguntas);
                 */
        }
    }

    @Override
    public void onAttach(Context context) {
        comunicador = (Comunicador) context;
        super.onAttach(context);
    }
}
