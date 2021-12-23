package com.example;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //REGISTRAMOS UN USUARIO CORRECTAMENTE
        Usuarios usuarios = new Usuarios();
        if(usuarios.registrar("mail@mail.com", "Contrasena", "Jose Fernandez"))
            System.out.println("Registrado correctamente");
        else
            System.out.println("Correo electrónico repetido.");

        //CREAMOS DOS ALUMNOS REGISTRADOS POR EL MISMO USUARIO
        Alumno alumno = new Alumno("usuario1@mail.com", "Antonio Garcia", "Barcelona",
                "España", "685965874", "Remoto", true, "foto.jpg", "cv.pdf",
                usuarios.usuarios.get(0));

        Alumno alumno2 = new Alumno("usuario2@mail.com", "Javier Martinez", "Madrid",
                "España", "632541569", "Presencial", false, "foto.jpg", "cv.pdf",
                usuarios.usuarios.get(0));

        //CREAMOS LENGUAJES
        Etiqueta etiqueta = new Etiqueta("Java");
        Etiqueta etiqueta1 = new Etiqueta("HTML");
        Etiqueta etiqueta2 = new Etiqueta("C++");
        Etiqueta etiqueta3 = new Etiqueta("Phyton");

        //AÑADIMOS CADA ALUMNO EL LENGUAJE QUE CONOCE EN UNA NUEVA CLASE
        AlumnosEtiquetas ae = new AlumnosEtiquetas();
        ae.addAlumnoEtiqueta(alumno.getCorreoElectronico(), etiqueta.getLenguaje());
        ae.addAlumnoEtiqueta(alumno.getCorreoElectronico(), etiqueta1.getLenguaje());
        ae.addAlumnoEtiqueta(alumno2.getCorreoElectronico(), etiqueta2.getLenguaje());
        ae.addAlumnoEtiqueta(alumno2.getCorreoElectronico(), etiqueta3.getLenguaje());

        //GENERAMOS PDF
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("cv.pdf"));
            documento.open();
            documento.addAuthor("Alexis Gonzalez Moreno");
            documento.addTitle("PDF de " + alumno.getNombreCompleto());

            Image image = Image.getInstance("cara.jpg");
            documento.add(image);

            Paragraph paragraph = new Paragraph();
            Chunk chunk = new Chunk("\n\nDATOS PERSONALES");
            chunk.getFont().setStyle(Font.BOLD);
            paragraph.add(chunk);
            paragraph.add("\nNombre: " + alumno.getNombreCompleto());
            paragraph.add("\nCorreo electrónico: " + alumno.getCorreoElectronico());
            paragraph.add("\nTeléfono: " + alumno.getTelefono());
            paragraph.add("\nCiudad: " + alumno.getCiudad());
            documento.add(paragraph);

            Paragraph paragraph1 = new Paragraph();
            Chunk chunk2 = new Chunk("\n\n\nLENGUAJES DE PROGRAMACIÓN\n");
            chunk2.getFont().setStyle(Font.BOLD);
            paragraph1.add(chunk2);
            ArrayList<String> lista = new ArrayList();
            lista = ae.getEtiquetaPorAlumno(alumno.getCorreoElectronico());
            for(String marca : lista)
                paragraph1.add(marca + "\n");
            documento.add(paragraph1);

            Paragraph paragraph2 = new Paragraph();
            Chunk chunk3= new Chunk("\n\n\nOTROS DATOS DE INTERÉS\n");
            chunk3.getFont().setStyle(Font.BOLD);
            paragraph2.add(chunk3);
            paragraph2.add("Presencialidad: " + alumno.getPresencialidad());
            paragraph2.add("\n¿Traslado? " + alumno.isTraslado());
            documento.add(paragraph2);
            documento.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
