package com.chainexample.desafio_gof_dio.models;

public abstract class Validation {

    protected Validation proximo;

    public void setProximo(Validation validation){
        this.proximo=validation;
    }

    public Validation getProximo(){
        return this.proximo;
    }

    public abstract boolean validate(Customer customer);
}
