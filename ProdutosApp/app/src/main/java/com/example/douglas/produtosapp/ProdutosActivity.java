package com.example.douglas.produtosapp;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdutosActivity extends AppCompatActivity {

    final static String BUNDLE_PRODUTO = "produto";

    ListView lvProdutos;
    ArrayList<Produto> produtos;
    ArrayAdapter<Produto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        configurarLvProdutos();

        String categoria =
                getIntent().getStringExtra(
                MainActivity.BUNDLE_CATEGORIA
        );

        setTitle(
                String.format("Produtos (%s)",categoria)
        );
        switch (categoria){
            case  "Informática":
                produtos.add(new Produto("101", "Laptop"));
                produtos.add(new Produto("102", "Smartphone"));
                produtos.add(new Produto("103", "Tablet"));
                break;
            case  "Papelaria":
                produtos.add(new Produto("201", "Caderno"));
                produtos.add(new Produto("202", "Grampeador"));
                produtos.add(new Produto("203", "Pasta"));
                break;
            case  "Outros":
                produtos.add(new Produto("301", "Item A"));
                produtos.add(new Produto("302", "Item B"));
                produtos.add(new Produto("303", "Item C"));
                break;

        }

        adapter.notifyDataSetChanged();
    }

    private void configurarLvProdutos() {
        lvProdutos = (ListView) findViewById(R.id.lv_produtos);

        produtos = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                ProdutosActivity.this,
                android.R.layout.simple_list_item_1,
                produtos
        );

        lvProdutos.setAdapter(adapter);

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto produto = (Produto)
                        parent.getItemAtPosition(position);
                Intent intent = new Intent(
                        ProdutosActivity.this,
                        DetalheProdutoActivity.class
                );
                intent.putExtra(
                        BUNDLE_PRODUTO,
                        produto
                );
                startActivityForResult(intent, 0);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        String retorno = data.getStringExtra(
                DetalheProdutoActivity.RETORNO
        );

        Toast.makeText(
                ProdutosActivity.this,
                retorno+""+ resultCode,
                Toast.LENGTH_SHORT).show();


    }
}
