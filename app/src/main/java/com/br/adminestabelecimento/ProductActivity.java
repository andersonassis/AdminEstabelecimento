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

import com.br.adminestabelecimento.adapters.CategoryAdapter;
import com.br.adminestabelecimento.adapters.ProductAdapter;
import com.br.adminestabelecimento.models.Category;
import com.br.adminestabelecimento.models.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductActivity extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    public List<Product> lista = new ArrayList<>();
    private Gson gson;
    private ProductAdapter adaptador;
    @BindView(R.id.recyclerView) RecyclerView view_reciclada;
    int cont = 0;
    Boolean saved=null;
    private String categoria;
    Dialog d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Produto");


        ButterKnife.bind(this);

        categoria = getIntent().getStringExtra("id_categoria");
        data_reference = database.getReference().child("products").child(categoria);
        data_reference.addValueEventListener(this);

    }//fim do oncreate

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            Product objeto = snapshot.getValue(Product.class);
            lista.add(objeto);
        }

        adaptador = new ProductAdapter(view_reciclada.getContext(), lista);
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
        d.setTitle("Salvar Produtos");
        d.setContentView(R.layout.imput_dialog_produtos);
        final EditText nomeproduto       = (EditText) d.findViewById(R.id.nomeproduto);
        final EditText descricaoprodutos = (EditText) d.findViewById(R.id.descricaoprodutos);
        final EditText precoprodutos     = (EditText) d.findViewById(R.id.precoproduto);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int    seq  = 1;
                int    result = 0;
                result = seq + cont;
                int    id   =  result;//aqui um random
                String name    = nomeproduto.getText().toString();
                String descri  = descricaoprodutos.getText().toString();
                String preco   =  precoprodutos.getText().toString();

                Product s = new Product();
                s.setId(id);
                s.setName(name);
                s.setDescription(descri);
                s.setPrice(Double.valueOf(preco));

                if(name.length()>0 && name != null)
                {
                    if(salvar(s))
                    {
                        nomeproduto.setText("");
                        descricaoprodutos.setText("");
                        precoprodutos.setText("");
                        cont = 0;
                        d.dismiss();
                        Intent intent = getIntent();
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Toast.makeText(ProductActivity.this, "O nome não pode estar vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();

    }


    //salvar dados no firebase
    public Boolean salvar(Product produto)
    {
        int contador = 1;
        int resultado = 0;
        resultado = contador + cont;

        String userId = String.valueOf(resultado);
        if(produto==null)
        {
            saved=false;
        }else
        {
            try
            {
                data_reference.child(userId).setValue(produto);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
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


        if (id == R.id.atualizar) { // CLICK DO BOTÃO excluir
           /* Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);*/

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}//fim da classe
