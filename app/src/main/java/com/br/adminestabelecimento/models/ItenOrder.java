package com.br.adminestabelecimento.models;

/**
 * Created by aassis on 18/07/2017.
 */

public class ItenOrder {

    private String produto;
    private int quantidade;
    private Double preco;
    private String obs;

    public ItenOrder(){

    }

    public ItenOrder(String produto, int quantidade, Double preco, String obs) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.obs = obs;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
