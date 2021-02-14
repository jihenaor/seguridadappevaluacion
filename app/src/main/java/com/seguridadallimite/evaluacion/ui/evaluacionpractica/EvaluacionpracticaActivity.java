package com.seguridadallimite.evaluacion.ui.evaluacionpractica;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.seguridadallimite.evaluacion.R;

public class EvaluacionpracticaActivity extends AppCompatActivity implements  View.OnClickListener{

    private Boolean isOpen = false;
    private FloatingActionButton fab;
    private FloatingActionButton fabNudos;
    private FloatingActionButton fabReconocimientoequipos;
    private FloatingActionButton fabTecnicastrabajoalturas;
    private FloatingActionButton fabTecnicasrescate;
    private FloatingActionButton fabProcedimientotrabajoseguroalturas;

    private EditText editTextNudos;
    private EditText editTextReconocimientoEquipos;
    private EditText editTextTecnicastrabajoalturas;
    private EditText editTextTecnicasrescate;
    private EditText editTextProcedimientotrabajoseguroalturas;

    private String idaprendiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacionpractica);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idaprendiz = getIntent().getStringExtra("idaprendiz");

        findViews();
        events();
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
                } else {
                    //textview_mail.setVisibility(View.VISIBLE);
                    //textview_share.setVisibility(View.VISIBLE);
                    //                fabNudos.startAnimation(fab_open);
                    //              fabReconocimientoequipos.startAnimation(fab_open);

                    hacervisibleBotones(View.VISIBLE);

                    fabNudos.setClickable(true);
                    fabReconocimientoequipos.setClickable(true);
                }

            }
        });

        fabNudos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.fabNudos:
                hacervisibleBotones(View.GONE);
                break;
            case R.id.fabReconocimientoEquipos:
                hacervisibleBotones(View.GONE);
                break;
            case R.id.fabTecnicastrabajoalturas:
                hacervisibleBotones(View.GONE);
                break;
            case R.id.fabTecnicasrescate:
                hacervisibleBotones(View.GONE);
                break;
            case R.id.fabProcedimientotrabajoseguroalturas:
                hacervisibleBotones(View.GONE);
                break;
        }

        isOpen = !isOpen;
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
    }
}