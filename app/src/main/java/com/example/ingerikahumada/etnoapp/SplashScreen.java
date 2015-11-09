package com.example.ingerikahumada.etnoapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashScreen extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
    private EditText edt_correo_splash,edt_nombre_splash;
    private Button btn_entrar_splash,btn_registrarse_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        edt_correo_splash=(EditText)findViewById(R.id.edt_text_correo_splash);
        edt_nombre_splash=(EditText)findViewById(R.id.edt_text_nombre_splash);
        btn_entrar_splash=(Button)findViewById(R.id.button_entrar_splash);
        btn_registrarse_splash=(Button)findViewById(R.id.button_registrar_splash);


        btn_entrar_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn_registrarse_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScreen.this, Registro.class);
                startActivity(i);
            }
        });
       /*new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company


            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);*/

    }
}
