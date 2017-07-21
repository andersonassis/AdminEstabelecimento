package com.br.adminestabelecimento.holders;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.ItenOrder;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aassis on 21/07/2017.
 */

public final class ItenOrderHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtnome) public TextView txtnome;
    @BindView(R.id.txtpreco) public TextView txtpreco;
   // @BindView(R.id.btremove) public ImageButton btremove;

    public ItenOrder produto;

    public ItenOrderHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_product_order, parent, false));
        ButterKnife.bind(this, itemView);
        SugarContext.init(itemView.getContext());
        final Context cc = parent.getContext();


      /*  btremove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Context c = v.getContext();

                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Remover este item");
                alert.setMessage("Confirma a remocao deste produto do pedido?");
                alert.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ItenOrder item = SugarRecord.findById(ItenOrder.class, produto.getId());
                        SugarRecord.delete(item);

                        Toast.makeText(c, "Item removido do pedido!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                        Intent intent = ((Activity) cc).getIntent();
                        ((Activity) cc).finish();
                        ((Activity) cc).startActivity(intent);
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