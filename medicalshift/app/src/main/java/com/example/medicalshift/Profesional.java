package com.example.medicalshift;

public class Profesional {
    private String nombre;
    private String especialidad;
    private String localidad;

    public Profesional(String nombre, String especialidad, String localidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.localidad = localidad;
    }

    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getLocalidad() { return localidad; }
}
