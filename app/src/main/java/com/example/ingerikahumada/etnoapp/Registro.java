package com.example.ingerikahumada.etnoapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Registro extends AppCompatActivity {

    private EditText edt_alias_reg,edt_nombre_reg,edt_apellidos_reg,edt_correo_reg,edt_empresa_reg,edt_num_cel_reg;
    private Button btn_crear_cuenta_reg;
    private LinearLayout ll_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.logo_app_sin_pluma);
        ab.setTitle("");

        ll_reg=(LinearLayout)findViewById(R.id.layout_reg);
        btn_crear_cuenta_reg=(Button)findViewById(R.id.crear_cuenta_reg);

        Bitmap bm=MainActivity.decodeSampledBitmapFromResource(getResources(), R.drawable.fondo_chat_app, 300, 300);
        BitmapDrawable d=new BitmapDrawable(getResources(),bm);
        ll_reg.setBackground(d);

        btn_crear_cuenta_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
