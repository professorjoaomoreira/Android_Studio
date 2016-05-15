package com.example.douglas.produtosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalheProdutoActivity extends AppCompatActivity {

    final static String RETORNO = "comando";

    TextView tvCodigoProduto, tvDescricaoProduto;
    Button btComprar, btVender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        setTitle(getString(R.string.detalhes_produto));

        tvCodigoProduto = (TextView) findViewById(R.id.tv_codigo_produto);
        tvDescricaoProduto = (TextView) findViewById(R.id.tv_descricao_produto);
        btComprar = (Button) findViewById(R.id.bt_comprar);
        btVender = (Button) findViewById(R.id.bt_vender);

       Produto produto =(Produto)
               getIntent()
               .getSerializableExtra(
                       ProdutosActivity.BUNDLE_PRODUTO);

        tvCodigoProduto.setText("Código:"+ produto.getCodigo());

        tvDescricaoProduto.setText(
                "Descrição:"+ produto.getDescricao());


        btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra(RETORNO,"COMPRAR");
            setResult(1,intent);
            finish();
            }
        });

        btVender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(RETORNO,"VENDER");
                setResult(2,intent);
                finish();
            }
        });
    }
}
