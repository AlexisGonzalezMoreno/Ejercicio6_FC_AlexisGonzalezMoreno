package com.example;

import java.util.ArrayList;

public class AlumnosEtiquetas {
    ArrayList<String> alumnos = new ArrayList();
    ArrayList<String> etiquetas = new ArrayList();

    public AlumnosEtiquetas() {}

    public void addAlumnoEtiqueta(String alumno, String etiqueta) {
        alumnos.add(alumno);
        etiquetas.add(etiqueta);
    }

    public void listarAlumnoEtiqueta() {
        for(int i=0; i<alumnos.size(); i++) {
            System.out.println(alumnos.get(i) + "-" + etiquetas.get(i));
        }
    }

    public void listarAlumnosPorEtiqueta(String etiqueta) {
        int capacidad = alumnos.size();
        ArrayList<String> alumnos2 = new ArrayList();
        for(int i=0; i<capacidad; i++) {
            if(etiquetas.get(i).equalsIgnoreCase(etiqueta))
                alumnos2.add(alumnos.get(i));
        }

        System.out.println(alumnos2);
    }

    public void listarEtiquetaPorAlumno(String alumno) {
        int capacidad = etiquetas.size();
        ArrayList<String> etiquetas2 = new ArrayList();
        for(int i=0; i<capacidad; i++) {
            if(alumnos.get(i).equalsIgnoreCase(alumno))
                etiquetas2.add(etiquetas.get(i));
        }

        System.out.println(etiquetas2);
    }

    public ArrayList<String> getEtiquetaPorAlumno(String alumno) {
        int capacidad = etiquetas.size();
        ArrayList<String> etiquetas3 = new ArrayList();
        for(int i=0; i<capacidad; i++) {
            if(alumnos.get(i).equalsIgnoreCase(alumno))
                etiquetas3.add(etiquetas.get(i));
        }

        return etiquetas3;
    }
}
