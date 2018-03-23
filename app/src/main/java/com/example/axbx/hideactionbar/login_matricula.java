package com.example.axbx.hideactionbar;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class login_matricula extends AppCompatActivity {

    Button LoginButton;
    TextView usuario,contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_matricula);
        usuario=(TextView)findViewById(R.id.txtusuario);
        contrasena=(TextView)findViewById(R.id.txtcontrasena);

    }

    public void Validar2(View v){
        Thread tr=new Thread(){
            @Override
            public void run() {
                super.run();

                final String res=EnviarPost(usuario.getText().toString(),contrasena.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r=objJSON(res);
                        if (r>0){
                            // Intent i=new Intent(getApplicationContext(),)
                            Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), MenuOpciones.class);
                            intent.putExtra("MATRICULA_ID", "LOGON");
                            startActivity(intent);

                        }else{
                            Toast.makeText(getApplicationContext(),"NO EXITO",Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        };
        tr.start();



    }


    public void Validar(View v){


        //WEB SERVICIE

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        InputStream is = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new

                BasicNameValuePair("correo","prueba@proximateapps.com"));
        nameValuePairs.add(new

                BasicNameValuePair("contrasenia","12digo16digo18#$"));




        try

        {


            JSONObject jsonObjData = new JSONObject();
            JSONObject json = new JSONObject();
            jsonObjData.put("usu_matricula", "prueba@proximateapps.com");
            jsonObjData.put("usu_contrasena", "12digo16digo18#$");
            json.put("data", jsonObjData);


            // Create the POST object and add the parameters
            HttpPost httpPost = new HttpPost("http://cmhline/webservice/valida_usuario.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(httpPost);
            HttpEntity entity2 = response.getEntity();


            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(entity2.getContent()), 65728);
                String line = null;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            //
            //INICIA APP


            System.out.println("finalResult " + sb.toString());
            /*==============================*/

            Log.d("HTTP", "HTTP: OK");
        } catch(Exception e)

        {
            Log.e("HTTP", "Error in http connection " + e.toString());

        }
    }


    public String EnviarPost(String cor,String pas){
        String parametros="usu_matricula="+cor+"&usu_contrasena="+pas;
        HttpURLConnection connection=null;
        String respuesta="";
        try{
            try {
                URL url = new URL("http://cmhline.com/webservice/valida_usuario.php");


                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Lenght",""+Integer.toString(parametros.getBytes().length));

                connection.setDoOutput(true);
                DataOutputStream wr= new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(parametros);
                wr.close();

                Scanner inStream=new Scanner(connection.getInputStream()); //consumeeeeee

                while(inStream.hasNextLine())
                    respuesta+=(inStream.nextLine());


            }catch(MalformedURLException e){

            }
        }catch(Exception e){

        }

        return respuesta.toString();
    }

    public int objJSON(String rspta){
        int res=0;
        try{

            JSONArray json=new JSONArray(rspta);
            if(json.length()>0){res=1;}
        }catch(Exception e){

        }
        return res;
    }
}





