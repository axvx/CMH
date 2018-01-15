package com.example.axbx.hideactionbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class login extends AppCompatActivity {

    //FB AUTH
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private LoginButton loginButton;
    private CallbackManager callBackManager;
    //FB Auth

    private GoogleApiClient mGoogleApiClient;


    private SignInButton button;
    private FirebaseAuth mAuth;
private final static int RC_SIGN_IN=2;

FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        //FB Login
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }
    //Fb Auth
    @Override
    protected void onStop(){
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthListener);
    }
    //fNB AUTH



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button=(SignInButton) findViewById(R.id.LoginGoogle);
        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(login.this,MenuOpciones.class));
                }
            }
        };

        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(login.this,"wrong",Toast.LENGTH_SHORT).show();;
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();


//Login FB

        callBackManager=CallbackManager.Factory.create();
        loginButton=(LoginButton)findViewById(R.id.login_button);

        loginButton.registerCallback(callBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(),"EXITO",Toast.LENGTH_SHORT).show();

                /*
                 Intent intent=new Intent(login.this,MenuOpciones.class);

                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                 startActivity(intent);*/

                 handleFacebookAccesToken(loginResult.getAccessToken());


            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"CANCELAR",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(getApplicationContext(),"Errror"+ error.toString(),Toast.LENGTH_SHORT).show();

            }
        });


        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    //fB aUTH
                    FirebaseUser user=firebaseAuth.getCurrentUser();
                     if(user!=null){
                         startActivity(new Intent(login.this,MenuOpciones.class));


                     }
            }
        };


        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(login.this,login_matricula.class));
                finish();
            }


        });

    }

    public void abrirmatricula(View v){



        Toast.makeText(getApplicationContext(),"Entro",Toast.LENGTH_LONG).show();



    }

    private void handleFacebookAccesToken(AccessToken accessToken) {

        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"error login FB",Toast.LENGTH_LONG).show();
                    }
            }
        });
    }


  /*  GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build();
            */

    private void signIn(){
        Intent signIntent=Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signIntent,RC_SIGN_IN);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callBackManager.onActivityResult(requestCode,resultCode,data); //fb login

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                Toast.makeText(this,"worng2",Toast.LENGTH_SHORT).show();;
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                          //  Toast.makeText(GoogleSignInActivity.this, "Authentication failed.",
                                   // Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // ...
                    }
                });
    }



}
