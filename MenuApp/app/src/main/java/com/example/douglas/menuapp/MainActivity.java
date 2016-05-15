package com.example.douglas.menuapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvItens;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<CharSequence> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItens = (ListView) findViewById(R.id.lv_itens);

        itens = new ArrayList<>();
        itens.add("Item 1");
        itens.add("Item 2");
        itens.add("Item 3");
        itens.add("Item 4");
        itens.add("Item 5");
        itens.add("Item 6");

        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_activated_1,
                itens);

        lvItens.setAdapter(adapter);
        registerForContextMenu(lvItens);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(
                R.menu.men,
                menu
        );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_novo:
                Toast.makeText(
                        MainActivity.this,
                        "NOVO...",
                        Toast.LENGTH_SHORT).show();

                Log.i("MENU", "NOVO");
                return true;
            case R.id.menu_excluir_tudo:
                itens.clear();
                adapter.notifyDataSetChanged();
                return true;

            case R.id.menu_sobre:
                new AlertDialog
                        .Builder(MainActivity.this)
                        .setTitle("Menu App")
                        .setMessage("versao 1.0.0")
                        .create()
                        .show();
                return true;
        }
        return false;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==R.id.lv_itens){
            getMenuInflater()
                    .inflate(R.menu.itens,menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)
                        item.getMenuInfo();

        int position = info.position;

        switch (item.getItemId()) {
            case R.id.detalhes:
                Toast.makeText(
        MainActivity.this,
        itens.get(position),
        Toast.LENGTH_SHORT).show();

                return true;
            case R.id.menu_excluir:
               itens.remove(position);
                adapter.notifyDataSetChanged();
                return true;
        }
        return false;
    }

}