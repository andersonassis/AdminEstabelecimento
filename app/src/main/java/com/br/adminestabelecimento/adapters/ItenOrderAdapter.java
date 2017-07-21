package com.br.adminestabelecimento.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.br.adminestabelecimento.holders.ItenOrderHolder;
import com.br.adminestabelecimento.models.ItenOrder;

import java.util.List;

/**
 * Created by aassis on 21/07/2017.
 */

public class ItenOrderAdapter extends RecyclerView.Adapter<ItenOrderHolder>  {
    private List<ItenOrder> lista;
    private Context context;

    @Override
    public ItenOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItenOrderHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ItenOrderHolder holder, int i) {
        ItenOrder objeto = lista.get(i);
        holder.txtnome.setText(objeto.getProduto());
        holder.txtpreco.setText("R$ " + Double.toString(objeto.getPreco()));
        holder.produto = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
