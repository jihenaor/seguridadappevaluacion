package com.seguridadallimite.evaluacion;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seguridadallimite.evaluacion.model.Grupo;

import java.util.List;

public class GruposRecyclerViewAdapter extends RecyclerView.Adapter<GruposRecyclerViewAdapter.ViewHolder> {
    private Context ctx;
    private final List<Grupo> mValues;

    public GruposRecyclerViewAdapter(
            Context ctx,
            List<Grupo> items) {
        this.ctx = ctx;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_grupos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.mItem = mValues.get(position);
        holder.getFechainicio().setText(mValues.get(position).getFechainicio());
//        holder.fechafinal.setText(mValues.get(position).getFechafinal());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //public final View mView;
        private final TextView fechainicio;
  //      public final TextView fechafinal;
//        public Grupo mItem;

        public ViewHolder(View view) {
            super(view);
        //    mView = view;
            fechainicio = (TextView) view.findViewById(R.id.textViewFechainicio1);
    //        fechafinal = (TextView) view.findViewById(R.id.fechafinal);
        }

        public TextView getFechainicio() {
            return fechainicio;
        }
    }
}