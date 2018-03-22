package com.example.axbx.hideactionbar;

import com.google.gson.annotations.SerializedName;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Evento {

    @SerializedName("evento_especialidad")
    @Expose
    private String eventoEspecialidad;
    @SerializedName("evento_hora")
    @Expose
    private String eventoHora;
    @SerializedName("evento_fecha")
    @Expose
    private String eventoFecha;
    @SerializedName("evento_tema")
    @Expose
    private String eventoTema;
    @SerializedName("evento_imparte")
    @Expose
    private String eventoImparte;

    public String getEventoEspecialidad() {
        return eventoEspecialidad;
    }

    public void setEventoEspecialidad(String eventoEspecialidad) {
        this.eventoEspecialidad = eventoEspecialidad;
    }

    public String getEventoHora() {
        return eventoHora;
    }

    public void setEventoHora(String eventoHora) {
        this.eventoHora = eventoHora;
    }

    public String getEventoFecha() {
        return eventoFecha;
    }

    public void setEventoFecha(String eventoFecha) {
        this.eventoFecha = eventoFecha;
    }

    public String getEventoTema() {
        return eventoTema;
    }

    public void setEventoTema(String eventoTema) {
        this.eventoTema = eventoTema;
    }

    public String getEventoImparte() {
        return eventoImparte;
    }

    public void setEventoImparte(String eventoImparte) {
        this.eventoImparte = eventoImparte;
    }

}