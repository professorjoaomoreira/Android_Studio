package com.example.douglas.produtosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NovaCategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_categoria);
        setTitle(R.string.nova_categoria);
    }
}
