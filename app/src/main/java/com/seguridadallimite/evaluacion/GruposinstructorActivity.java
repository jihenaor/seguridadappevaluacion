package com.seguridadallimite.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GruposinstructorActivity extends AppCompatActivity {

    public String idinstructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gruposinstructor);
        Bundle args = new Bundle();

        Bundle extras = getIntent().getExtras();

        idinstructor = extras.getString("idinstructor");
        args.putString("idinstructor", idinstructor);

        findViews();
        GruposFragment gruposFragment = new GruposFragment();

//        gruposFragment.setArguments(args);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentGrupos, gruposFragment)
                .commit();
    }

    private void findViews() {

    }

}