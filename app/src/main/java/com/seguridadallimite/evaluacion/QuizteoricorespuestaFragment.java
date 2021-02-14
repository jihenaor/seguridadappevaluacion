package com.seguridadallimite.evaluacion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seguridadallimite.evaluacion.common.Constantes;
import com.seguridadallimite.evaluacion.common.SharedPeferencesManager;
import com.seguridadallimite.evaluacion.model.Grupo;
import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.retrofit.SeguridadClient;
import com.seguridadallimite.evaluacion.retrofit.SeguridadServices;
import com.seguridadallimite.evaluacion.ui.aprendicesgrupo.AprendicesgrupoActivity;
import com.seguridadallimite.evaluacion.ui.grupos.GrupoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class QuizteoricorespuestaFragment extends Fragment {

    private List<Pregunta> preguntas;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters

    private OnListFragmentInteractionListener mListener;
    QuizteoricorespuestaRecyclerViewAdapter adapterRespuestas;

    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public QuizteoricorespuestaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static QuizteoricorespuestaFragment newInstance(int columnCount) {
        QuizteoricorespuestaFragment fragment = new QuizteoricorespuestaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quizteoricorespuesta_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            adapterRespuestas = new QuizteoricorespuestaRecyclerViewAdapter(context, preguntas, mListener);
            recyclerView.setAdapter(adapterRespuestas);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Pregunta item);
    }

    public static class GruposActivity extends AppCompatActivity {

        ListView listViewGrupos;
        List<Grupo> grupos;

        SeguridadServices service;
        SeguridadClient client;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grupos);

            findViews();

            retrofitInit();

            loadGrupos();
        }

        private void findViews() {
            listViewGrupos = findViewById(R.id.listViewGrupos);
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

                            GrupoAdapter adapter = new GrupoAdapter(GruposActivity.this, grupos);

                            listViewGrupos.setAdapter(adapter);

                            listViewGrupos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {





                                    Intent intent = new Intent(GruposActivity.this, AprendicesgrupoActivity.class);
                                    intent.putExtra("idgrupo", grupos.get(i).getId().toString());

                                    startActivity(intent);

                                    // Toast.makeText(GruposActivity.this, g.getFechainicio(), Toast.LENGTH_SHORT).show();
                                }
                            });

                            return;
                        }
                    } else {
                        Toast.makeText(GruposActivity.this, "Problemas de conexion 1", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Grupo>> call, Throwable t) {
                    Log.i("On login", t.getMessage());
                    Toast.makeText(GruposActivity.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
