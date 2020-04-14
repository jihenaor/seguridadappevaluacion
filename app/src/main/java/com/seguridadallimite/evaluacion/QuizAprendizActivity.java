package com.seguridadallimite.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizAprendizActivity extends AppCompatActivity {

    TextView txt_pregunta;
    int contadorPregunta;

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

        txt_pregunta.setText("Pregunta xxxx");
    }

    private void findView() {
        txt_pregunta = (TextView) findViewById(R.id.txt_pregunta);

        for (int i = 0; i < ids_respuestas.length; i++) {
            RadioButton rb = (RadioButton) findViewById(ids_respuestas[i]);
            rb.setText(String.format("Respuesta %d", i));
        }
    }
}
