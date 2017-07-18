package com.br.adminestabelecimento.holders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    public CategoryHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_category, parent, false));
        ButterKnife.bind(this, itemView);

        // clica na categoria
       /* itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context c = v.getContext();
                Intent intent = new Intent(c,ProductsActivity.class);
                intent.putExtra("id_categoria", Long.toString(categoria.getId()));
                c.startActivity(intent);
            }
        });*/
    }
}