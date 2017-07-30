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
import com.google.firebase.database.ValueEventListener;

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
    public String id2;
    public String nomeAreaatua;
    public String cidadeAreaatua;
    public double    taxa;
    String name;
    String cid;
    String preco;
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
                data_reference = database.getReference().child("area");
                data_reference.addValueEventListener((ValueEventListener) c);
                idAtualiza = area.getId();
                nomeAreaatua   = area.getName();
                cidadeAreaatua = area.getCidade();
                taxa           = area.getTaxa();

                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Atualizar Área");
                alert.setMessage("Deseja atualizar esta Área ?");
                alert.setPositiveButton("ATUALIZAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        displayInputDialog();
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alert.show();
            }
        });


    }//FIM AREA HOLDE



    //tela de dialogo para atualizar e salvar
    private void displayInputDialog()
    {
        d =new Dialog(c);
        d.setTitle("Salvar Area");
        d.setContentView(R.layout.imput_dialog_area);
        final EditText nomearea          = (EditText) d.findViewById(R.id.nomearea);
        final EditText cidade            = (EditText) d.findViewById(R.id.cidade);
        final EditText taxa              = (EditText) d.findViewById(R.id.taxaarea);
        Button saveBtn                   = (Button) d.findViewById(R.id.saveBtn);

        nomearea.setText(nomeAreaatua);
        cidade.setText(cidadeAreaatua);
        taxa.setText(taxa.getText().toString());

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int    id      =  idAtualiza;
                id2 = String.valueOf(id);

                name = (nomearea.getText().toString());
                cidadeAreaatua = (cidade.getText().toString());
                preco   = (taxa.getText().toString());

                Area s = new Area();
                s.setId(id);
                s.setName(name);
                s.setCidade(cidadeAreaatua);
                s.setTaxa(Double.valueOf(preco));

                if(name.length()>0 && name != null)
                {
                    if(salvar(s))
                    {
                        nomearea.setText("");
                        cidade.setText("");
                        taxa.setText("");
                        d.dismiss();

                    }
                }else{
                    Toast.makeText(c, "O nome não pode estar vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }

    //salvar dados no firebase
    public Boolean salvar(Area area)
    {
        if(area==null)
        {
            saved=false;
        }else
        {
            try
            {
                data_reference.child(id2).setValue(area);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }








}//FIM DA CLASSE
