package com.seguridadallimite.evaluacion.ui.aprendicesgrupo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seguridadallimite.evaluacion.R;
import com.seguridadallimite.evaluacion.model.Viaprendiz;

import java.util.List;

public class ViaprendizAdapter extends BaseAdapter {
    Context context;

    List<Viaprendiz> viaprendizs;

    public ViaprendizAdapter(Context context, List<Viaprendiz> viaprendizs) {
        this.context = context;
        this.viaprendizs = viaprendizs;
    }

    @Override
    public int getCount() {
        return viaprendizs.size();
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
        TextView textViewNombreaprendiz;

        Viaprendiz g = viaprendizs.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_aprendices, null);
        }
        textViewNombreaprendiz = view.findViewById(R.id.textViewNombreaprendiz);

        textViewNombreaprendiz.setText(g.getNombreaprendiz());

        return view;
    }
}
