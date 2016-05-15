package com.example.douglas.produtosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String BUNDLE_CATEGORIA = "categoria";

    ListView lvCategorias;
    ArrayList<CharSequence> categorias;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategorias = (ListView) findViewById(R.id.lv_categorias);

        categorias = new ArrayList<>();
        categorias.add("Informática");
        categorias.add("Papelaria");
        categorias.add("Outros");

        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                categorias
        );

        lvCategorias.setAdapter(adapter);

        lvCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categoria =
                        parent.getItemAtPosition(position)
                        .toString();
                Intent intent = new Intent (
                        MainActivity.this,
                        ProdutosActivity.class
                );
                intent.putExtra(
                        BUNDLE_CATEGORIA,
                        categoria
                );
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_nova_categoria:
                Intent intent = new Intent (
                        MainActivity.this,
                        NovaCategoriaActivity.class
                );
                startActivity(intent);

                return true;
        }

        return false;
    }
}
