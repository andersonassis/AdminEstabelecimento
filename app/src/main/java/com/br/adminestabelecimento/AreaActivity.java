package com.br.adminestabelecimento;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.br.adminestabelecimento.adapters.AreaAdapter;
import com.br.adminestabelecimento.models.Area;
import com.br.adminestabelecimento.models.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AreaActivity extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    public List<Area> lista = new ArrayList<>();
    private AreaAdapter adaptador;
    @BindView(R.id.recyclerView) RecyclerView view_reciclada;
    Boolean saved=null;
    int cont = 0;
    Dialog d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Áreas");
        ButterKnife.bind(this);
        data_reference = database.getReference().child("area");
        data_reference.addValueEventListener(this);


    }//fim do oncreate

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            Area objeto = snapshot.getValue(Area.class);
            lista.add(objeto);
        }//fim do for

        adaptador = new AreaAdapter(view_reciclada.getContext(), lista);
        view_reciclada.setAdapter(adaptador);
        view_reciclada.setHasFixedSize(true);
        view_reciclada.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w("RETORNO", "loadPost:onCancelled", databaseError.toException());

    }


    //tela de dialogo para salvar
    private void displayInputDialog()
    {
        d =new Dialog(this);
        d.setTitle("Salvar Area");
        d.setContentView(R.layout.imput_dialog_area);
        final EditText nomearea          = (EditText) d.findViewById(R.id.nomearea);
        final EditText cidade            = (EditText) d.findViewById(R.id.cidade);
        final EditText taxa              = (EditText) d.findViewById(R.id.taxaarea);
        Button saveBtn                   = (Button) d.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int    seq  = 1;
                int    result = 0;
                result = seq + cont;
                int    id      =  result;
                String name    =  nomearea.getText().toString();
                String cid     =  cidade.getText().toString();
                String preco   =  taxa.getText().toString();

                Area s = new Area();
                s.setId(id);
                s.setName(name);
                s.setCidade(cid);
                s.setTaxa(Double.valueOf(preco));

                if(name.length()>0 && name != null)
                {
                    if(salvar(s))
                    {
                        nomearea.setText("");
                        cidade.setText("");
                        taxa.setText("");
                        cont = 0;
                        d.dismiss();
                        Intent intent = getIntent();
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Toast.makeText(AreaActivity.this, "O nome não pode estar vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }


    //salvar dados no firebase
    public Boolean salvar(Area area)
    {
        int contador = 1;
        int resultado = 0;
        resultado = contador + cont;
        String userId = String.valueOf(resultado);
        if(area==null)
        {
            saved=false;
        }else
        {
            try
            {
                data_reference.child(userId).setValue(area);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }




    //atualizar os dados

    public void atualiza(){


    }



    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
            return true;
        }

        if (id == R.id.action_settings) { // CLICK DO BOTÃO ADD
            displayInputDialog();
            return true;
        }


        if (id == R.id.atualizar) { // CLICK DO BOTÃO ATUALIZAR
             atualiza();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}//fim da classe
