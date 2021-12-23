package com.example;

import java.util.ArrayList;

public class Usuario {
    private String correoElectronico;
    private String contrasena;
    private String nombreCompleto;
    private ArrayList<Alumno> alumnos;


    public Usuario() {}

    public Usuario(String correoElectronico, String contrasena, String nombreCompleto) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        alumnos = new ArrayList();
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ArrayList<Alumno> getAlumnos() { return alumnos; }

    public void addAlumnos(Alumno alumno) { alumnos.add(alumno); }

    @Override
    public String toString() {
        return "Usuario{" +
                "correoElectronico='" + correoElectronico + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
