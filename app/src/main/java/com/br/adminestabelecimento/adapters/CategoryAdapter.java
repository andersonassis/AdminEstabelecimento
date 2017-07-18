package com.br.adminestabelecimento.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.br.adminestabelecimento.holders.CategoryHolder;
import com.br.adminestabelecimento.models.Category;

import java.util.List;

/**
 * Created by aassis on 18/07/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder>{
    private List<Category> lista;
    private Context context;

    public CategoryAdapter(Context context, List<Category> lista) {
        this.lista      = lista;
        this.context    = context;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int i) {
        Category objeto = lista.get(i);

        holder.txtnome.setText(objeto.getName());
        holder.categoria = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
