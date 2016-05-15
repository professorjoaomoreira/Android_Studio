package com.example.mobile.primeiroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNome = (EditText) findViewById(R.id.editText);

        Button btBemVindo = (Button) findViewById(R.id.bt_bem_vindo);
        btBemVindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Seja bem-vindo teste, " + etNome.getText();
                Toast.makeText(
                        MainActivity.this,
                        msg,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
