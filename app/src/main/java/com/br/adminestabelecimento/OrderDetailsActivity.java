package com.br.adminestabelecimento;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.br.adminestabelecimento.adapters.ItenOrderAdapter;
import com.br.adminestabelecimento.adapters.OrderAdapter;
import com.br.adminestabelecimento.models.Pedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends AppCompatActivity {
    private List<Pedido> lista2 = new ArrayList<>();
    @BindView(R.id.listaProdutos) ListView lista;
    String listapedidos;
    ArrayList<HashMap<String, String>> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detalhes do pedido");
        ButterKnife.bind(this);
        listapedidos = getIntent().getStringExtra("produtos");// json dos produtos
        productList = new ArrayList<>();
        criarListagem();

    }//fim do oncreate

    //metodo para criar a listagem
    public void criarListagem() {
        try {
            JSONArray jsonArray = new JSONArray(listapedidos);
            int length = jsonArray.length();
            List<String> listContents = new ArrayList<String>(length);
            for (int i = 0; i < length; i++)
            {
                JSONObject itens = jsonArray.getJSONObject(i);
                String produto1 = itens.getString("produto");
                String quantidade = itens.getString("quantidade");
                String obs = itens.getString("obs");

                HashMap<String, String> produtos = new HashMap<>();
                produtos.put("produto", produto1);
                produtos.put("quantidade", quantidade);
                produtos.put("obs", obs);
                productList.add(produtos);

            }
            ListAdapter adapter = new SimpleAdapter(
                    OrderDetailsActivity.this, productList,
                    R.layout.itenslistaprodutos, new String[]{"produto", "quantidade", "obs"},
                    new int[]{R.id.txtpruduto, R.id.txtqtd, R.id.txtobs});

            lista.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

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
