package com.example.axbx.hideactionbar;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;





        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Historico {

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
    @SerializedName("video_ruta01")
    @Expose
    private String videoRuta01;
    @SerializedName("video_ruta02")
    @Expose
    private String videoRuta02;

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

    public String getVideoRuta01() {
        return videoRuta01;
    }

    public void setVideoRuta01(String videoRuta01) {
        this.videoRuta01 = videoRuta01;
    }

    public String getVideoRuta02() {
        return videoRuta02;
    }

    public void setVideoRuta02(String videoRuta02) {
        this.videoRuta02 = videoRuta02;
    }

}