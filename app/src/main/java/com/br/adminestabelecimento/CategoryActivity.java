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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.adminestabelecimento.adapters.CategoryAdapter;
import com.br.adminestabelecimento.models.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements ValueEventListener{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    public List<Category> lista = new ArrayList<>();
    private Gson gson;
    private CategoryAdapter adaptador;
    @BindView(R.id.recyclerView) RecyclerView view_reciclada;
    Boolean saved=null;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Categorias");

        ButterKnife.bind(this);
        data_reference = database.getReference().child("menu");
        data_reference.addValueEventListener(this);

    }//fim do oncreate

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            Category objeto = snapshot.getValue(Category.class);
            lista.add(objeto);
        }

        adaptador = new CategoryAdapter(view_reciclada.getContext(), lista);
        view_reciclada.setAdapter(adaptador);
        view_reciclada.setHasFixedSize(true);
        view_reciclada.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w("RETORNO", "loadPost:onCancelled", databaseError.toException());

    }

    private void displayInputDialog()
    {
        Dialog d =new Dialog(this);
        d.setTitle("Salvar Categorias");
        d.setContentView(R.layout.imput_dialog);
        final EditText nameEditTxt= (EditText) d.findViewById(R.id.nameEditText);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int    id   = 789;
                String name = nameEditTxt.getText().toString();

                Category s = new Category();
                s.setId(id);
                s.setName(name);
                if(name.length()>0 && name != null)
                {
                    if(salvar(s))
                    {
                        nameEditTxt.setText("");
                        adaptador = new CategoryAdapter(view_reciclada.getContext(), lista);
                        view_reciclada.setAdapter(adaptador);
                        view_reciclada.setHasFixedSize(true);
                        view_reciclada.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                                LinearLayoutManager.VERTICAL, false));
                    }
                }else{
                    Toast.makeText(CategoryActivity.this, "O nome não pode estar vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }

    //salvar dados no firebase
    public Boolean salvar(Category category)
    {
        int contador = 1;
        int resultado = 0;
        resultado = contador + cont;

        String userId = String.valueOf(resultado);
        if(category==null)
        {
            saved=false;
        }else
        {
            try
            {
                data_reference.child(userId).setValue(category);
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


        if (id == R.id.excluir) { // CLICK DO BOTÃO excluir
           /* Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);*/

            return true;
        }




        return super.onOptionsItemSelected(item);
    }




}//fim da classe
