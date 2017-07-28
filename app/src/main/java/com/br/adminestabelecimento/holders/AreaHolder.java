package com.br.adminestabelecimento.holders;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.br.adminestabelecimento.AreaActivity;
import com.br.adminestabelecimento.ProductActivity;
import com.br.adminestabelecimento.R;
import com.br.adminestabelecimento.models.Area;
import com.br.adminestabelecimento.models.Category;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aassis on 24/07/2017.
 */

public class AreaHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txtnomearea) public TextView txtnomearea;
    @BindView(R.id.txtcidade) public TextView txtcidade;
    @BindView(R.id.txttaxa) public TextView txttaxa;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;

    public Area area;
    public int idAtualiza;
    Boolean saved=null;
    Dialog d;
    Context c;

    public AreaHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_area, parent, false));
        ButterKnife.bind(this, itemView);



        // clica na categoria
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                c = v.getContext();
                idAtualiza = area.getId();

                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Atualizar Área");
                alert.setMessage("Deseja atualizar esta Área ?");
                alert.setPositiveButton("ATUALIZAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // displayInputDialog();
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
        });


    }//FIM AREA HOLDE







}//FIM DA CLASSE
