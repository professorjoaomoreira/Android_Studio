package com.example.douglas.tarefasapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Douglas on 5/13/2016.
 */
public class TarefaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Tarefa> tarefas;

    public TarefaAdapter(Context context, ArrayList<Tarefa> tarefas) {
        this.context = context;
        this.tarefas = tarefas;
    }

    @Override
    public int getCount() {
        // retorna a quantidade de tarefas do array
        return tarefas.size();
    }

    @Override
    public Object getItem(int position) {
        // retorna a tarefa na posição
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        // não usamos, pois não temos ID na tarefa
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // declara um objeto ViewHolder
        ViewHolder viewHolder;

        // testa se o convertView é nulo
        if (convertView == null) {
            // pega o layout inflater
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();

            // carrega o convertView com o layout da lista
            convertView = inflater.inflate(
                    R.layout.tarefa_item,
                    parent,
                    false);

            // cria o viewHolder passando o convertView
            viewHolder = new ViewHolder(convertView);

            // configura a tag do convertView para o viewHolder
            convertView.setTag(viewHolder);
        }
        // senão
        else {
            // pega o viewHolder do convertView já carregado
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // pega a tarefa na posição atual
        Tarefa tarefa = tarefas.get(position);

        // testa se a tarefa não é nula
        if (tarefa != null) {

            String descricao = tarefa.getDescricao();
            String prioridade = tarefa.getPrioridade();

            viewHolder.tvDescricao.setText(descricao);
            viewHolder.tv_prioridade.setText(prioridade);

            switch (prioridade){
                case "Alta":
                    viewHolder.ivIcone.setImageResource(
                            R.drawable.warning_red
                    );
                    break;
                case "Média":
                    viewHolder.ivIcone.setImageResource(
                            R.drawable.warning_yellow
                    );
                    break;
                case "Baixa":
                    viewHolder.ivIcone.setImageResource(
                            R.drawable.warning_blue
                    );
                    break;
            }
        }

        // retorna o convertView
        return convertView;
    }

    public static class ViewHolder {

        public final ImageView ivIcone;
        public final TextView tvDescricao, tv_prioridade;

        public ViewHolder(View view) {

            ivIcone = (ImageView)
                    view.findViewById(R.id.iv_icone);

            tvDescricao = (TextView)
                    view.findViewById(R.id.tv_descricao);

            tv_prioridade = (TextView)
                    view.findViewById(R.id.tv_prioridade);

        }

    }
}