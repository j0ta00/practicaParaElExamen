package com.example.juanjomz.practicaparaelexamen;

public class Equipo{

    private int idImagen;
    private String nombreEquipo;


    public Equipo(int idImagen, String nombreEquipo) {
        this.idImagen = idImagen;
        this.nombreEquipo = nombreEquipo;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
