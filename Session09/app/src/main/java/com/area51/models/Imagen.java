package com.area51.models;

/**
 * Created by elder_vasquez on 2/13/15.
 */
public class Imagen {

    private int id;
    private String rutaImage;

    public Imagen(int id, String rutaImage) {
        this.id = id;
        this.rutaImage = rutaImage;
    }

    public String getRutaImage() {
        return rutaImage;
    }

    public void setRutaImage(String rutaImage) {
        this.rutaImage = rutaImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
