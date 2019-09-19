package com.example.codify;

public class ItemPlaylist {
    public String nombrecancion;
    public String nombreartista;
    public String urlAlbum;

    public ItemPlaylist(String nombrecancion, String nombreartista, String urlAlbum) {
        this.nombrecancion = nombrecancion;
        this.nombreartista = nombreartista;
        this.urlAlbum = urlAlbum;
    }

    public String getNombrecancion() {
        return nombrecancion;
    }

    public void setNombrecancion(String nombrecancion) {
        this.nombrecancion = nombrecancion;
    }

    public String getNombreartista() {
        return nombreartista;
    }

    public void setNombreartista(String nombreartista) {
        this.nombreartista = nombreartista;
    }

    public String getUrlAlbum() {
        return urlAlbum;
    }

    public void setUrlAlbum(String urlAlbum) {
        this.urlAlbum = urlAlbum;
    }
}
