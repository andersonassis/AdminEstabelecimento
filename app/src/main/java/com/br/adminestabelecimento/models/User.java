package com.br.adminestabelecimento.models;

/**
 * Created by aassis on 18/07/2017.
 */

public class User {

    private long id;
    private String name;
    private String cel;
    private String cpf;



   //get e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
