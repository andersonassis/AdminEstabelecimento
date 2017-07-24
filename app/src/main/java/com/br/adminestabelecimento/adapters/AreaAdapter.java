package com.br.adminestabelecimento.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.br.adminestabelecimento.holders.AreaHolder;
import com.br.adminestabelecimento.holders.CategoryHolder;
import com.br.adminestabelecimento.models.Area;
import com.br.adminestabelecimento.models.Category;


import java.util.List;

/**
 * Created by aassis on 24/07/2017.
 */

public class AreaAdapter extends RecyclerView.Adapter<AreaHolder> {
    private List<Area> lista;
    private Context context;

    public AreaAdapter (Context context, List<Area> lista) {
        this.lista      = lista;
        this.context    = context;
    }



    @Override
    public AreaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AreaHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(AreaHolder holder, int i) {
        Area objeto = lista.get(i);
        holder.txtnomearea.setText(objeto.getName());
        holder.area = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
