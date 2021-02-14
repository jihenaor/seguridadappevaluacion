package com.seguridadallimite.evaluacion;

import android.os.Bundle;

import com.seguridadallimite.evaluacion.model.Pregunta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class QuizTeoricoActivity extends AppCompatActivity implements QuizteoricopreguntasFragment.Comunicador, QuizteoricorespuestaFragment.OnListFragmentInteractionListener {

    private List<Pregunta> preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizteorico);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void enviar(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public void onListFragmentInteraction(Pregunta item) {

    }

    private void getQuestionList() {

    }
}
