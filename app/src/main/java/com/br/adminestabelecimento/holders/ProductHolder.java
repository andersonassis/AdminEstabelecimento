package com.br.adminestabelecimento.holders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AndersonLuis on 18/07/2017.
 */

public class ProductHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtnome) public TextView txtnome;
    @BindView(R.id.txtpreco) public TextView txtpreco;

    public Product produto;

    public ProductHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_product, parent, false));
        ButterKnife.bind(this, itemView);


       /* btadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Context c = v.getContext();

                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Incluir no Pedido");
                alert.setMessage("Confirma a inclusao deste produto no pedido? Voce podera alterar depois antes de concluir.");
                alert.setPositiveButton("Incluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ItenOrder item = new ItenOrder(produto.getName(), 1, produto.getPrice(), "");
                        SugarRecord.save(item);

                        Toast.makeText(c, "Item adicionado em seu pedido!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alert.show();
            }
        });*/
    }

}
