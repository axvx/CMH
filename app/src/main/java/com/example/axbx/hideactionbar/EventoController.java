package com.example.axbx.hideactionbar;
import android.widget.Toast;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventoController implements Callback<List<Evento>> {

    static final String BASE_URL = "http://cmhline.com/";

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

        Call<List<Evento>> call = eventoAPI.getEvento(Temario.formattedDate);


        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
        if(response.isSuccessful()) {
          List<Evento> changesList = response.body();

          Temario.ResetCajas();
            System.out.println("=========================:");



            for(int x=0;x<=changesList.size()-1;x++){

               switch (changesList.get(x).getEventoHora()){

                   case "00:00:00":
                       Temario.txt00.setText("00:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;

                   case "01:00:00":
                       Temario.txt01.setText("01:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;

                   case "02:00:00":
                       Temario.txt02.setText("02:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "03:00:00":
                       Temario.txt03.setText("03:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "04:00:00":
                       Temario.txt04.setText("04:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "05:00:00":
                       Temario.txt05.setText("05:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "06:00:00":
                       Temario.txt06.setText("06:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "07:00:00":
                       Temario.txt07.setText("07:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "08:00:00":
                       Temario.txt08.setText("08:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "09:00:00":
                       Temario.txt09.setText("09:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "10:00:00":
                       Temario.txt10.setText("10:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "11:00:00":
                       Temario.txt11.setText("11:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "12:00:00":
                       Temario.txt12.setText("12:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "13:00:00":
                       Temario.txt13.setText("13:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "14:00:00":
                       Temario.txt14.setText("14:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "15:00:00":
                       Temario.txt00.setText("15:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;

                   case "17:00:00":

                       Temario.txt17.setText("17:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                                            "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                                            "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "16:00:00":
                       Temario.txt16.setText("16:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "18:00:00":
                       Temario.txt18.setText("18:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "19:00:00":
                       Temario.txt19.setText("19:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "20:00:00":
                       Temario.txt20.setText("20:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "21:00:00":
                       Temario.txt21.setText("21:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "22:00:00":
                       Temario.txt22.setText("22:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "23:00:00":
                       Temario.txt23.setText("23:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;
                   case "24:00:00":
                       Temario.txt24.setText("24:00:00\n"+ changesList.get(x).getEventoTema()+"\n"+
                               "Especialidad:"+changesList.get(x).getEventoEspecialidad()+"\n"+
                               "Imparte:"+ changesList.get(x).getEventoImparte()+"\n");
                       break;


               }

            }

         //   changesList.forEach(change -> System.out.println("salida: "+change.getEventoTema()));

           // Temario.txt00.setText(change.);

        } else {
            System.out.println("ERROR MX"+response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Evento>> call, Throwable t) {
        t.printStackTrace();
    }
}