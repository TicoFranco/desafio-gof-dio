package com.chainexample.desafio_gof_dio.services;

import com.chainexample.desafio_gof_dio.models.Customer;
import com.chainexample.desafio_gof_dio.models.Validation;
import java.util.List;
import java.util.Objects;

public class ValidateEmail extends Validation {

    List<Customer> customers;

    public ValidateEmail(List<Customer> customers){
        this.customers=customers;
    }

    @Override
    public boolean validate(Customer customer){
        String aux=customer.getEmail();
        if(aux.isEmpty() || aux.length()>50) {
            return false;
        }
        for(Customer customers: customers){
            if(customers.getEmail().equals(aux) && !Objects.equals(customer.getId(), customers.getId())){
                return false;
            }
        }
        return true;
    }
}
