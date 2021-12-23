package com.example;

public class Alumno {
    private String correoElectronico;
    private String nombreCompleto;
    private String ciudad;
    private String pais;
    private String telefono;
    private String presencialidad;
    private boolean traslado;
    private String fotoPerfil;
    private String cv;
    private Usuario usuario;

    public Alumno() {}

    public Alumno(String correoElectronico, String nombreCompleto, String ciudad, String pais, String telefono,
                  String presencialidad, boolean traslado, String fotoPerfil, String cv, Usuario usuario) {
        this.correoElectronico = correoElectronico;
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.presencialidad = presencialidad;
        this.traslado = traslado;
        this.fotoPerfil = fotoPerfil;
        this.cv = cv;
        this.usuario = usuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCiudad() { return ciudad; }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(String presencialidad) {
        this.presencialidad = presencialidad;
    }

    public boolean isTraslado() {
        return traslado;
    }

    public void setTraslado(boolean traslado) {
        this.traslado = traslado;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Alumno{" +
                "correoElectronico='" + correoElectronico + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", telefono='" + telefono + '\'' +
                ", presencialidad=" + presencialidad +
                ", traslado=" + traslado +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }
}
