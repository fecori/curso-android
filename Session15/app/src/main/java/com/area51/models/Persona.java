package com.area51.models;

/**
 * Created by elder_vasquez on 25/02/15.
 */
public class Persona {

    private int id;
    private String Nombre;
    private String Apellidos;
    private String Genero;

    public Persona(int id, String nombre, String apellidos, String genero) {
        this.id = id;
        Nombre = nombre;
        Apellidos = apellidos;
        Genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
