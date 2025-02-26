package com.chainexample.desafio_gof_dio.services;

import com.chainexample.desafio_gof_dio.models.Customer;
import com.chainexample.desafio_gof_dio.models.Validation;

import java.util.List;
import java.util.Objects;

public class ValidateUsername extends Validation {

    List<Customer> customers;

    public ValidateUsername(List<Customer> customers){
        this.customers=customers;
    }

    @Override
    public boolean validate(Customer customer){
        String aux=customer.getUsername();
        if(aux.isEmpty() || aux.length()>20){
            return false;
        }
        for(Customer customers: customers){
            if(customers.getUsername().equals(aux) && !Objects.equals(customer.getId(), customers.getId())){
                return false;
            }
        }
        return true;
    }
}