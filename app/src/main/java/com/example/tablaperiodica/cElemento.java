package com.example.tablaperiodica;

public class cElemento {
    private String nombre;
    private String simbolo;
    private String posicion;
    private String numero;
    private String tipo;
    private String serie;
    private String url;

    public cElemento(String sNombre, String sSimbolo, String sPosicion, String sNumero, String sTipo, String sSerie, String sUrl) {
        nombre = sNombre;
        simbolo = sSimbolo;
        posicion = sPosicion;
        numero = sNumero;
        tipo = sTipo;
        serie = sSerie;
        url = sUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerie(){
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
