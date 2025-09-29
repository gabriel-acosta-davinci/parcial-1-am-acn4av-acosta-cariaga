package com.example.medicalshift;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfesionalAdapter extends RecyclerView.Adapter<ProfesionalAdapter.ProfesionalViewHolder> {

    private List<Profesional> listaOriginal;
    private List<Profesional> listaFiltrada;

    public ProfesionalAdapter(List<Profesional> lista) {
        this.listaOriginal = lista;
        this.listaFiltrada = new ArrayList<>(lista);
    }

    @NonNull
    @Override
    public ProfesionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profesional, parent, false);
        return new ProfesionalViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfesionalViewHolder holder, int position) {
        Profesional p = listaFiltrada.get(position);
        holder.nombre.setText(p.getNombre());
        holder.especialidad.setText(p.getEspecialidad());
        holder.localidad.setText(p.getLocalidad());
    }

    @Override
    public int getItemCount() {
        return listaFiltrada.size();
    }

    public void filtrar(String texto) {
        listaFiltrada.clear();
        if (texto.isEmpty()) {
            listaFiltrada.addAll(listaOriginal);
        } else {
            texto = texto.toLowerCase();
            for (Profesional p : listaOriginal) {
                if (p.getNombre().toLowerCase().contains(texto) ||
                        p.getEspecialidad().toLowerCase().contains(texto) ||
                        p.getLocalidad().toLowerCase().contains(texto)) {
                    listaFiltrada.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class ProfesionalViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, especialidad, localidad;

        public ProfesionalViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreProfesional);
            especialidad = itemView.findViewById(R.id.especialidadProfesional);
            localidad = itemView.findViewById(R.id.localidadProfesional);
        }
    }
}
