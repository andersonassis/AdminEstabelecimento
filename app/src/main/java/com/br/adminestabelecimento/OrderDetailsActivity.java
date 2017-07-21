package com.br.adminestabelecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.br.adminestabelecimento.adapters.ItenOrderAdapter;
import com.br.adminestabelecimento.adapters.OrderAdapter;
import com.br.adminestabelecimento.models.Pedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends AppCompatActivity implements ValueEventListener {
    private List<Pedido> lista2 = new ArrayList<>();
    @BindView(R.id.txtid) TextView txtid;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    private ItenOrderAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detalhes do pedido");

        ButterKnife.bind(this);
        data_reference = database.getReference().child("order").child("itens");
        data_reference.addValueEventListener(this);

        String id = getIntent().getStringExtra("id");
        txtid.setText(id);

    }//fim do oncreate


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista2.clear();

        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Pedido objeto = snapshot.getValue(Pedido.class);
            if(objeto != null) {
                  lista2.add(objeto);
                }
            }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w("RETORNO", "loadPost:onCancelled", databaseError.toException());
    }
















    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}//fim da classe
