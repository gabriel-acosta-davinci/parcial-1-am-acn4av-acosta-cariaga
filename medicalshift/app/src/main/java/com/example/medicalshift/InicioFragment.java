package com.example.medicalshift;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InicioFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
    private OnNavigationRequest callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNavigationRequest) {
            callback = (OnNavigationRequest) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout dynamicContainer = view.findViewById(R.id.dynamicContainer);

        TextView saludoHora = new TextView(getContext());
        saludoHora.setTextSize(16);
        saludoHora.setTextColor(Color.WHITE);
        saludoHora.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        saludoHora.setPadding(0, 8, 0, 8);

        // Generar saludo según la hora
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        String mensaje;

        if (hora >= 6 && hora < 12) {
            mensaje = "Que tengas una excelente mañana ☀️";
        } else if (hora >= 12 && hora < 18) {
            mensaje = "¡Buena tarde! 🌤️";
        } else if (hora >= 18 && hora < 22) {
            mensaje = "Disfrutá tu noche 🌙";
        } else {
            mensaje = "Es hora de descansar 😴";
        }

        saludoHora.setText(mensaje);
        dynamicContainer.addView(saludoHora);

        // RecyclerView de trámites
        RecyclerView recyclerTramites = view.findViewById(R.id.recyclerTramites);
        recyclerTramites.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Tramite> listaTramites = new ArrayList<>();
        listaTramites.add(new Tramite("Autorización médica", "28/09/2025", "Aprobado"));
        listaTramites.add(new Tramite("Pedido de credencial", "25/09/2025", "Pendiente"));
        listaTramites.add(new Tramite("Consulta virtual", "20/09/2025", "Rechazado"));

        TramiteAdapter tramiteAdapter = new TramiteAdapter(listaTramites);
        recyclerTramites.setAdapter(tramiteAdapter);

        // Búsqueda y RecyclerView de cartilla médica
        EditText searchCartilla = view.findViewById(R.id.searchCartilla);
        RecyclerView recyclerCartilla = new RecyclerView(getContext());
        recyclerCartilla = view.findViewById(R.id.recyclerCartilla); // Asegurate de tener este ID en el XML
        recyclerCartilla.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Profesional> listaProfesionales = new ArrayList<>();
        listaProfesionales.add(new Profesional("Dra. María Cariaga", "Cardiología", "Mar del Plata"));
        listaProfesionales.add(new Profesional("Dr. Juan Pérez", "Pediatría", "Balcarce"));
        listaProfesionales.add(new Profesional("Dra. Lucía Gómez", "Dermatología", "Mar del Plata"));

        ProfesionalAdapter profesionalAdapter = new ProfesionalAdapter(listaProfesionales);
        recyclerCartilla.setAdapter(profesionalAdapter);

        // Botón "Ver todos"
        Button btnVerTramites = view.findViewById(R.id.btnVerTramites);
        btnVerTramites.setOnClickListener(v -> {
            if (callback != null) callback.navegarA(1); // Página de trámites
        });

        // Botón "Ver cartilla"
        Button btnVerCartilla = view.findViewById(R.id.btnVerCartilla);
        btnVerCartilla.setOnClickListener(v -> {
            if (callback != null) callback.navegarA(2); // Página de cartilla
        });

        // Filtro en tiempo real por profesional
        searchCartilla.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                profesionalAdapter.filtrar(s.toString());
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });
    }
    // Interfaz necesaria para la navegación mediante los botones
    public interface OnNavigationRequest {
        void navegarA(int posicion);
    }
}
