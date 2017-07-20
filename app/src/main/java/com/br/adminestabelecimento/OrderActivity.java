package com.br.adminestabelecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.br.adminestabelecimento.models.ItenOrder;
import com.google.gson.Gson;

import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private List<ItenOrder> lista;
    private Gson gson;
   // private ItenOrderAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);





    }//fim do oncreate
}//fim da classe
