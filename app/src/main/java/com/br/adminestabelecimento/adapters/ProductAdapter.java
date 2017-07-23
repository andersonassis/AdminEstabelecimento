package com.br.adminestabelecimento.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.br.adminestabelecimento.holders.ProductHolder;
import com.br.adminestabelecimento.models.Product;

import java.util.List;

/**
 * Created by AndersonLuis on 18/07/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {
    private List<Product> lista;
    private Context       context;

    public ProductAdapter(Context context, List<Product> lista) {
        this.lista      = lista;
        this.context    = context;
    }


    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int i) {
        Product objeto = lista.get(i);
        holder.txtnome.setText(objeto.getName());
        holder.txtdescricao.setText(objeto.getDescription());
        holder.txtpreco.setText(Double.toString(objeto.getPrice()));
        holder.produto = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
