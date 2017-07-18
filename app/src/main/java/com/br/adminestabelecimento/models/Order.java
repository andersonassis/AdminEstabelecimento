package com.br.adminestabelecimento.models;

import java.util.List;

/**
 * Created by aassis on 18/07/2017.
 */

public class Order {

    private String id;
    private String user_id;
    private String date;
    private Double total;
    private Double shipp;
    private int status;
    private String address;
    private String address_ref;
    private String area;
    private String pay_method;
    private String note_user;
    private String note;
    private List<ItenOrder> itens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getShipp() {
        return shipp;
    }

    public void setShipp(Double shipp) {
        this.shipp = shipp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_ref() {
        return address_ref;
    }

    public void setAddress_ref(String address_ref) {
        this.address_ref = address_ref;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getNote_user() {
        return note_user;
    }

    public void setNote_user(String note_user) {
        this.note_user = note_user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ItenOrder> getItens() {
        return itens;
    }

    public void setItens(List<ItenOrder> itens) {
        this.itens = itens;
    }
}
