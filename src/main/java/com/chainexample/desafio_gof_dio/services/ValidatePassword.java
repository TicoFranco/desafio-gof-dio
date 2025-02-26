package com.chainexample.desafio_gof_dio.services;

import com.chainexample.desafio_gof_dio.models.Customer;
import com.chainexample.desafio_gof_dio.models.Validation;

public class ValidatePassword extends Validation {

    @Override
    public boolean validate(Customer customer){
        String aux=customer.getPassword();
        if(aux.isEmpty() || aux.length()>20) {
            return false;
        }
        return true;
    }
}

