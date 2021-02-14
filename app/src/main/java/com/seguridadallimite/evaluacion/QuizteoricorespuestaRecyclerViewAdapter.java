package com.seguridadallimite.evaluacion;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seguridadallimite.evaluacion.QuizteoricorespuestaFragment.OnListFragmentInteractionListener;
import com.seguridadallimite.evaluacion.model.Pregunta;
import com.seguridadallimite.evaluacion.model.Respuesta;

import java.util.List;

public class QuizteoricorespuestaRecyclerViewAdapter extends RecyclerView.Adapter<QuizteoricorespuestaRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private final List<Pregunta> mValues;
    private final OnListFragmentInteractionListener mListener;

    public QuizteoricorespuestaRecyclerViewAdapter(Context context,
                                                   List<Pregunta> items,
                                                   OnListFragmentInteractionListener listener) {
        this.context = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_quizteoricorespuesta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.txtPregunta.setText(holder.mItem.getPregunta());
/*
        holder.imageViewRespuestacorrecta
        Glide.with(context)
                .load("")
                .centerCrop()
                .into(holder.imageViewRespuestacorrecta);
*/
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtPregunta;
        public final ImageView imageViewRespuestacorrecta;
        public final ImageView imageViewRespuestaincorrecta;
        public Pregunta mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtPregunta = (TextView) view.findViewById(R.id.txtPregunta);
            imageViewRespuestacorrecta = (ImageView) view.findViewById(R.id.imageViewRespuestacorrecta);
            imageViewRespuestaincorrecta = (ImageView) view.findViewById(R.id.imageViewRespuestaincorrecta);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtPregunta.getText() + "'";
        }
    }
}
