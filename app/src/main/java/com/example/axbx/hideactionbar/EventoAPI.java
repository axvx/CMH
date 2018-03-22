package com.example.axbx.hideactionbar;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

        import java.util.List;
import java.util.Map;

import retrofit2.Call;
        import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EventoAPI {

    @GET("webservice/")
    Call<List<Evento>> loadChanges(@Query("q") String status);


    @FormUrlEncoded
    @POST("webservice/lista_temario.php")
    Call<List<Evento>> getEvento(@Field("evento_fecha") String evento_fecha);



}