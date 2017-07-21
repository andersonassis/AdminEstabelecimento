package com.br.adminestabelecimento.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.br.adminestabelecimento.holders.OrderHolder;
import com.br.adminestabelecimento.models.Pedido;

import java.util.List;

/**
 * Created by aassis on 21/07/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderHolder> {
    private List<Pedido> lista;
    private Context context;

    public OrderAdapter(Context context, List<Pedido> lista) {
        this.lista      = lista;
        this.context    = context;
    }


    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int i) {
        Pedido objeto = lista.get(i);
        holder.txtid.setText(Long.toString(objeto.getId()));
        holder.order = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
