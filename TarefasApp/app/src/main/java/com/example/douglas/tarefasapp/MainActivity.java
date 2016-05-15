package com.example.douglas.tarefasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTarefas;
    ArrayList<Tarefa> tarefas;
    TarefaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTarefas = (ListView) findViewById(R.id.lv_tarefas);

        tarefas = new ArrayList<>();
        tarefas.add(new Tarefa("Teste 1", "Média"));
        tarefas.add(new Tarefa("Teste 2", "Alta"));
        tarefas.add(new Tarefa("Teste 3", "Baixa"));

        adapter = new TarefaAdapter(
                MainActivity.this,
                tarefas
        );

        lvTarefas.setAdapter(adapter);
    }
}
