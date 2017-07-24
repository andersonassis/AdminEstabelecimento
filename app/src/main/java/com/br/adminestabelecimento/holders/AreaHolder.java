package com.br.adminestabelecimento.holders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.br.adminestabelecimento.ProductActivity;
import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.Area;
import com.br.adminestabelecimento.models.Category;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aassis on 24/07/2017.
 */

public class AreaHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txtnomearea)
    public TextView txtnomearea;
    public Area area;

    public AreaHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_area, parent, false));
        ButterKnife.bind(this, itemView);

        // clica na categoria
       /* itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context c = v.getContext();
                Intent intent = new Intent(c,ProductActivity.class);
                intent.putExtra("id_categoria", Long.toString(area.getId()));
                c.startActivity(intent);
            }
        });*/
    }
}
