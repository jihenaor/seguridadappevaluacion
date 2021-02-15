package com.seguridadallimite.evaluacion.ui.evaluacionpractica;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.R;
import com.seguridadallimite.evaluacion.model.Pregunta;

import java.util.List;

public class PreguntaAdapter extends BaseAdapter {
    Context context;

    List<Pregunta> preguntas;

    public PreguntaAdapter(Context context, List<Pregunta> preguntas) {
        this.context = context;
        this.preguntas = preguntas;
    }

    @Override
    public int getCount() {
        return preguntas.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView ImageViewViaprendiz;
        TextView textViewPregunta;
        Switch switchCumple;
        CheckBox checkBoxCumple;
        CheckBox checkBoxNocumple;

        Pregunta g = preguntas.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_preguntasevaluacionpractica, null);
        }
        textViewPregunta = view.findViewById(R.id.textViewPreguntaevaluacionpractica);
        switchCumple = view.findViewById(R.id.switchCumple);
        checkBoxCumple = view.findViewById(R.id.checkBoxCumple);
        checkBoxNocumple = view.findViewById(R.id.checkBoxNocumple);

        if (g.getRespuestacorrecta() != null) {
            if (g.getRespuestacorrecta().equals("S")) {
                checkBoxCumple.setChecked(true);
                checkBoxNocumple.setChecked(false);
                switchCumple.setChecked(true);
            } else {
                checkBoxCumple.setChecked(false);
                checkBoxNocumple.setChecked(true);
                switchCumple.setChecked(false);
            }
        }

        textViewPregunta.setText(g.getPregunta());


        switchCumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switchCumple.isChecked()) {
                    checkBoxCumple.setChecked(true);
                    checkBoxNocumple.setChecked(false);
                    preguntas.get(i).setRespuestacorrecta("S");
                } else {
                    checkBoxCumple.setChecked(false);
                    checkBoxNocumple.setChecked(true);
                    preguntas.get(i).setRespuestacorrecta("N");
                }
            }
        });

        checkBoxCumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBoxCumple.isChecked()) {
                    checkBoxCumple.setChecked(true);
                    checkBoxNocumple.setChecked(false);
                    preguntas.get(i).setRespuestacorrecta("S");
                }
            }
        });

        checkBoxNocumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBoxNocumple.isChecked()) {
                    checkBoxCumple.setChecked(false);
                    checkBoxNocumple.setChecked(true);
                    preguntas.get(i).setRespuestacorrecta("N");
                }
            }
        });

        return view;
    }
}
