package com.example.axbx.hideactionbar;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
        import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventoAPI {


    @GET("webservice/")
    Call<List<Evento>> loadChanges(@Query("q") String status);


    @FormUrlEncoded
    @POST("webservice/lista_temario.php")
    Call<List<Evento>> getEvento(@Field("evento_fecha") String evento_fecha);


    @FormUrlEncoded
    @POST("webservice/registrar_usuario.php")
    Call <List<Regist>> setRegistrar(
                              @Query("usu_matricula") String usu_matricula,
                              @Query("usu_nombre") String usu_nombre,
                              @Query("usu_apellido") String usu_apellido,
                              @Query("usu_mail") String usu_mail,
                              @Query("usu_tel") String usu_tel,
                              @Query("usu_contrasena") String usu_contrasena,
                              @Field("usu_tipo") String usu_tipo);


    //http://cmhline.com/webservice/lista01_historico.php?evento_especialidad=OFTALMOLOGIA
    //[{"evento_especialidad":"OFTALMOLOGIA","evento_hora":"17:00:00","evento_fecha":"2018-03-31","evento_tema":"AVANCES DE OFTALMOLOGIA EN EL ESTADO","evento_imparte":"JUAN MARTINEZ","video_ruta01":"https:\/\/www.youtube.com\/watch?v=d5rH1wxUtL4","video_ruta02":""}]


    @FormUrlEncoded
    @POST("webservice/lista01_historico.php")
    Call<List<Historico>> getHistorico(@Field("evento_especialidad") String evento_especialidad);
}