package com.example.axbx.hideactionbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.facebook.FacebookSdk.getApplicationContext;

public class HistoricoController implements Callback<List<Historico>> {

    static final String BASE_URL = "http://cmhline.com/";
    public static String Videos[];


    public void start() {

        System.out.println("=========================:");
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        EventoAPI eventoAPI = retrofit.create(EventoAPI.class);

        // Call<List<Evento>> call = eventoAPI.getEvento("2018-03-31");

        Call<List<Historico>> call = eventoAPI.getHistorico(SesionesPasadas.especialidad);


        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<List<Historico>> call, Response<List<Historico>> response) {
        if(response.isSuccessful()) {
            List<Historico> changesList = response.body();

            //Temario.ResetCajas();
            System.out.println("=========================:");



            for(int x=0;x<=changesList.size()-1;x++){


                System.out.println("Especialidad " + changesList.get(x).getEventoTema());

                SesionesPasadas.sistemas=new String[changesList.size()];
                  Videos=new String[changesList.size()];


                SesionesPasadas.sistemas[x]=changesList.get(x).getEventoTema();

                Videos[x]=changesList.get(x).getVideoRuta01();


System.out.println("RAMX"+SesionesPasadas.sistemas.length);



                SesionesPasadas.adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, SesionesPasadas.sistemas);

                SesionesPasadas.list.setAdapter(SesionesPasadas.adaptador);
                SesionesPasadas.list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                        // TODO Auto-generated method stub
                        String data=(String)arg0.getItemAtPosition(position);

                        Toast.makeText(getApplicationContext(), "Ha pulsado el item " + Videos[position] , Toast.LENGTH_SHORT).show();



                        https://www.youtube.com/embed/VTyzzclMqWQ
                        SesionesPasadas.mWebView.loadUrl(Videos[position]);
                        //mWebView.loadUrl("https://www.youtube.com/embed/71P_dDnv-p4");





                        // Enable Javascript
                        WebSettings webSettings = SesionesPasadas.mWebView.getSettings();
                        webSettings.setJavaScriptEnabled(true);



                        // Force links and redirects to open in the WebView instead of in a browser
                       SesionesPasadas.mWebView.setWebViewClient(new WebViewClient());





                        if(position==8){
                            //Anestesiologia
                            //Pasar parametros a un controlador






                        }

                    }

                });


            }

            //   changesList.forEach(change -> System.out.println("salida: "+change.getEventoTema()));

            // Temario.txt00.setText(change.);

        } else {
            System.out.println("ERROR MX"+response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Historico>> call, Throwable t) {
        t.printStackTrace();
    }
}