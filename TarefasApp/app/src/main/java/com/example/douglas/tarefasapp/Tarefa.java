package com.example.douglas.tarefasapp;

/**
 * Created by Douglas on 5/13/2016.
 */
public class Tarefa {
    private String descricao;
    private String prioridade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Tarefa(String descricao, String prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }
}
