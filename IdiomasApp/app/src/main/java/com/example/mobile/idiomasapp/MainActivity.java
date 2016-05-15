package com.example.mobile.idiomasapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvIdiomas;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<CharSequence> idiomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvIdiomas =
                (ListView) findViewById(R.id.lv_idiomas);

        idiomas = new ArrayList<>();
        idiomas.add("Alemão (DE)");
        idiomas.add("Espanhol (ES)");
        idiomas.add("Francês (FR)");
        idiomas.add("Inglês (EN)");
        idiomas.add("Português (PT)");

        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_activated_1,
                idiomas
        );

        lvIdiomas.setAdapter(adapter);
        lvIdiomas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        lvIdiomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idioma =
                    parent.getItemAtPosition(position).toString();

                Toast.makeText(
                        MainActivity.this,
                        idioma,
                        Toast.LENGTH_SHORT).show();
            }
        });

        lvIdiomas.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            ArrayList<CharSequence> selecionados;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                String idioma = idiomas.get(position).toString();

                if (checked) {
                    selecionados.add(idioma);
                }
                else {
                    selecionados.remove(idioma);
                }
                mode.setTitle(Integer.toString(selecionados.size()));
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(
                        R.menu.menu_idiomas, menu
                );
                selecionados = new ArrayList<>();
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(final ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.menu_excluir) {

                    AlertDialog alert =
                            new AlertDialog.Builder(
                                MainActivity.this
                            )
                            .setTitle("Confirmação")
                            .setMessage("Tem certeza de que deseja excluir?")
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    for (CharSequence idioma : selecionados) {
                                        idiomas.remove(idioma);
                                    }
                                    adapter.notifyDataSetChanged();
                                    mode.finish();
                                }
                            })
                            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create();

                    alert.show();


                    return true;
                }

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
