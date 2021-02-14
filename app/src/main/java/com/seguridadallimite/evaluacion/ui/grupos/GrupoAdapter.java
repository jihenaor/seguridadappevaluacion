package com.seguridadallimite.evaluacion.ui.grupos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seguridadallimite.evaluacion.R;
import com.seguridadallimite.evaluacion.model.Grupo;

import java.util.List;

public class GrupoAdapter extends BaseAdapter {
    Context context;

    List<Grupo> grupos;

    public GrupoAdapter(Context context, List<Grupo> grupos) {
        this.context = context;
        this.grupos = grupos;
    }

    @Override
    public int getCount() {
        return grupos.size();
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
        ImageView ImageViewGrupo;
        TextView textViewFechaInicio;
        TextView textViewFechaFinal;

        Grupo g = grupos.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_grupos, null);
        }
        textViewFechaInicio = view.findViewById(R.id.textViewFechainicio1);
        textViewFechaFinal = view.findViewById(R.id.textViewFechafinal1);

        textViewFechaInicio.setText(g.getFechainicio());
        textViewFechaFinal.setText(g.getFechafinal());

        return view;
    }
}
