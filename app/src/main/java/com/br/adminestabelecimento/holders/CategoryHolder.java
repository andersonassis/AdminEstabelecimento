package com.br.adminestabelecimento.holders;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.br.adminestabelecimento.ProductActivity;
import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.Category;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aassis on 18/07/2017.
 */

public final class CategoryHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtnome)
    public TextView txtnome;
    public Category categoria;
    Context c;

    public CategoryHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_category, parent, false));
        ButterKnife.bind(this, itemView);

        // clica na categoria
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                c = v.getContext();
                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Atualizar áreas e cadastrar produtos");
                alert.setMessage("Deseja atualizar ou cadastrar produtos ?");
                alert.setPositiveButton("CADASTRAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(c,ProductActivity.class);
                        intent.putExtra("id_categoria", Long.toString(categoria.getId()));
                        c.startActivity(intent);
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("ATUALIZAR CATEGORIA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // displayInputDialog();
                        dialog.dismiss();
                    }
                });

                alert.show();
            }//fim onclick
        });//fim do click


        //aqui o meotodo atualizar



    }//fim CategoryHolder
}//fim da classe