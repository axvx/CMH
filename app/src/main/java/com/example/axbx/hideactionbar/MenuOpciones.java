package com.example.axbx.hideactionbar;

//colegiomedico-25004
//project-493465503933

//Comando para obtener SHA1
// keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuOpciones extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Logout gOOGLE
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

   public int deslogueo=0;

    private VideoView mVideoView;
    public WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     final String s = getIntent().getStringExtra("MATRICULA_ID");


        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

              if(deslogueo==0) {
                  if (firebaseAuth.getCurrentUser() == null && s.isEmpty()) {
                      //  if(firebaseAuth.getCurrentUser()==null ){
                      startActivity(new Intent(MenuOpciones.this, login.class));
                  }


              }else{
                  if (firebaseAuth.getCurrentUser() == null) {
                      //  if(firebaseAuth.getCurrentUser()==null ){
                      deslogueo=1;
                      startActivity(new Intent(MenuOpciones.this, login.class));
              }}


            }

        };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


       mWebView = (WebView) findViewById(R.id.webview);

       // https://www.youtube.com/embed/VTyzzclMqWQ
       // mWebView.loadUrl("https://www.ustream.tv/embed/23465661?html5ui");
        mWebView.loadUrl("https://www.youtube.com/embed/71P_dDnv-p4");




        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);



        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) { //Sesiones en vivo
            // Handle the camera action
            Toast.makeText(getApplicationContext(), "Import", Toast.LENGTH_SHORT).show();


            SesionesVivo myFragment = SesionesVivo.newInstance("w", "2");  //your fragment



            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SesionesVivo fragment = new SesionesVivo();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();



        } else if (id == R.id.nav_gallery) { //Temario
            Toast.makeText(getApplicationContext(),"Gallery",Toast.LENGTH_SHORT).show();

            Temario myFragment = Temario.newInstance("w", "2");  //your fragment



            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Temario fragment = new Temario();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_slideshow) { //Sesiones Pasadas
            Toast.makeText(getApplicationContext(),"SlideShow",Toast.LENGTH_SHORT).show();

            SesionesPasadas myFragment = SesionesPasadas.newInstance("w", "2");  //your fragment



            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SesionesPasadas fragment = new SesionesPasadas();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_manage) { //Configuracion
            Toast.makeText(getApplicationContext(),"Tools",Toast.LENGTH_SHORT).show();

deslogueo=1;

    mAuth.signOut(); //Desloguea




        } else if (id == R.id.nav_share) { //Compartir
            Toast.makeText(getApplicationContext(),"Compartir",Toast.LENGTH_SHORT).show();
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "CMHLIne");
                String sAux = "\nTe recomiendo bajar esta aplicación\n\n";
                //Vinculo en PlayStore
                sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "elige one"));
            } catch(Exception e) {
                //e.toString();
            }


        } else if (id == R.id.nav_send) { //Contactanos


            Toast.makeText(getApplicationContext(),"Enviar",Toast.LENGTH_SHORT).show();

            Contactanos myFragment = Contactanos.newInstance("w", "2");  //your fragment



            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Contactanos fragment = new Contactanos();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
