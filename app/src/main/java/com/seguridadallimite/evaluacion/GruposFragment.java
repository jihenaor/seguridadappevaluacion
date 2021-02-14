package com.seguridadallimite.evaluacion;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.common.Constantes;
import com.seguridadallimite.evaluacion.common.SharedPeferencesManager;
import com.seguridadallimite.evaluacion.model.Grupo;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 */
public class GruposFragment extends Fragment {

    GruposRecyclerViewAdapter adapter;
    private List<Grupo> grupos = null;

    SeguridadServices service;
    SeguridadClient client;
//    private String idinstructor;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GruposFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static GruposFragment newInstance(int columnCount) {
        GruposFragment fragment = new GruposFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grupos_list, container, false);

//        idinstructor = getArguments().getString("idinstructor");

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView2 = (RecyclerView) view;

            this.recyclerView = recyclerView2;

            if (mColumnCount <= 1) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView2.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            retrofitInit();

            loadGrupos();
        }
        return view;
    }

    private void retrofitInit() {
        client = SeguridadClient.getInstance();

        service = client.getService();
    }

    private void loadGrupos() {
        String idinstructor;

        idinstructor = SharedPeferencesManager.getSomeStringValue(Constantes.PREF_ID_INSTRUCTOR);

        Call<List<Grupo>> call = service.doGruposactivosevaluacionpractica(idinstructor);

        call.enqueue(new Callback<List<Grupo>>() {
            @Override
            public void onResponse(Call<List<Grupo>> call, Response<List<Grupo>> response) {
                if (response.isSuccessful()) {
                    // Toast.makeText(QuizAprendizActivity.this, "Quiz consultado con exito", Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()) {
                        grupos = response.body();

                        adapter = new GruposRecyclerViewAdapter(
                                getActivity(),
                                grupos
                        );

                        recyclerView.setAdapter(adapter);

                        return;
                    }
                } else {
                    Toast.makeText(getActivity(), "Problemas de conexion 1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Grupo>> call, Throwable t) {
                Log.i("On login", t.getMessage());
                Toast.makeText(getActivity(), "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}