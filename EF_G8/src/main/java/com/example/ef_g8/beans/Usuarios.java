package com.example.ef_g8.beans;

public class Usuarios {
    private int idUsuarios;
    private String nombres;
    private String apellidos;
    private String correo;
    private String tipo;
    private String contraseña;
    private String contraseñaHasheada;


    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseñaHasheada() {
        return contraseñaHasheada;
    }

    public void setContraseñaHasheada(String contraseñaHasheada) {
        this.contraseñaHasheada = contraseñaHasheada;
    }
}
