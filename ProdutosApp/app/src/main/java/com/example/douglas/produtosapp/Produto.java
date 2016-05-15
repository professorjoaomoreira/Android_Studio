package com.example.douglas.produtosapp;

import java.io.Serializable;

/**
 * Created by Douglas on 5/11/2016.
 */
public class Produto implements Serializable {

    private String codigo;
    private String descricao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s", codigo, descricao);
    }

    public Produto(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
