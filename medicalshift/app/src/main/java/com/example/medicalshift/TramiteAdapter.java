package com.example.medicalshift;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TramiteAdapter extends RecyclerView.Adapter<TramiteAdapter.TramiteViewHolder> {

    private List<Tramite> listaTramites;

    public TramiteAdapter(List<Tramite> listaTramites) {
        this.listaTramites = listaTramites;
    }

    @NonNull
    @Override
    public TramiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tramite, parent, false);
        return new TramiteViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull TramiteViewHolder holder, int position) {
        Tramite tramite = listaTramites.get(position);
        holder.titulo.setText(tramite.getTitulo());
        holder.fecha.setText("Fecha: " + tramite.getFecha());
        holder.estado.setText("Estado: " + tramite.getEstado());
    }

    @Override
    public int getItemCount() {
        return listaTramites.size();
    }

    static class TramiteViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, fecha, estado;

        public TramiteViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloTramite);
            fecha = itemView.findViewById(R.id.fechaTramite);
            estado = itemView.findViewById(R.id.estadoTramite);
        }
    }
}