package com.br.adminestabelecimento.holders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.br.adminestabelecimento.OrderDetailsActivity;
import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.ItenOrder;
import com.br.adminestabelecimento.models.Pedido;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aassis on 21/07/2017.
 */

public class OrderHolder  extends RecyclerView.ViewHolder {

    @BindView(R.id.txtid) public TextView txtid;

    public Pedido order;
    public ItenOrder pedido;
    private List<Pedido> listapedido = new ArrayList<>();

    public OrderHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_order, parent, false));
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context c = v.getContext();
                Intent intent = new Intent(c, OrderDetailsActivity.class);
                intent.putExtra("id", Long.toString(order.getId()));
               // intent.putExtra("prod", pedido.getProduto());
                c.startActivity(intent);
            }
        });

    }

}
