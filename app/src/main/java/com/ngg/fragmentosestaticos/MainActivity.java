package com.ngg.fragmentosestaticos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements EnviarMensaje {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarDato(String dato){
        FragmentoB fb = (FragmentoB) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerB);
        fb.recibir(dato);
    }
}