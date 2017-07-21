package com.br.adminestabelecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.br.adminestabelecimento.adapters.OrderAdapter;
import com.br.adminestabelecimento.models.Pedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrdersActivity extends AppCompatActivity implements ValueEventListener {
    private List<Pedido> lista = new ArrayList<>();
    private String user_id = "1";
    private int status = 1; //em produçao
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    private OrderAdapter adaptador;
    @BindView(R.id.recyclerView) RecyclerView view_reciclada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pedidos");
        ButterKnife.bind(this);
        data_reference = database.getReference().child("order");
        data_reference.addValueEventListener(this);


    }//fim do oncreate

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Pedido objeto = snapshot.getValue(Pedido.class);
            if(objeto != null) {
                if (objeto.getUser_id().equals(user_id) && objeto.getStatus()== status){ //status = 1 em produção
                    lista.add(objeto);
                }
            }
        }

        adaptador = new OrderAdapter(view_reciclada.getContext(), lista);
        view_reciclada.setAdapter(adaptador);
        view_reciclada.setHasFixedSize(true);
        view_reciclada.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w("RETORNO", "loadPost:onCancelled", databaseError.toException());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home){
            //onBackPressed();
            startActivity(new Intent(MyOrdersActivity.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}//fim da classe
