package com.br.adminestabelecimento.holders;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.br.adminestabelecimento.OrderDetailsActivity;
import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.ItenOrder;
import com.br.adminestabelecimento.models.Pedido;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aassis on 21/07/2017.
 */

public class OrderHolder  extends RecyclerView.ViewHolder {

    @BindView(R.id.txtid) public TextView txtid;
    @BindView(R.id.txtendereco) public TextView txtendereco;
    @BindView(R.id.txtbairro) public TextView txtbairro;
    @BindView(R.id.txtentregar) public TextView txtentregar;
    @BindView(R.id.txtpagamento) public TextView txtpagamento;
    @BindView(R.id.txttotal) public TextView txttotal;

    public Pedido order;
    public OrderHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_order, parent, false));
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context c = v.getContext();
                Intent intent = new Intent(c, OrderDetailsActivity.class);
                try {
                    String listSerializedToJson = new Gson().toJson(order.getItens());
                    intent.putExtra("produtos", listSerializedToJson);
                }catch (Exception e){

                    e.printStackTrace();
                }


                c.startActivity(intent);
            }
        });

    }

}
