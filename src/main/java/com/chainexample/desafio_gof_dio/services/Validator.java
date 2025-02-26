package com.chainexample.desafio_gof_dio.services;

import com.chainexample.desafio_gof_dio.models.Customer;
import com.chainexample.desafio_gof_dio.models.Validation;

import java.util.List;

public class Validator extends Validation {

    ValidateEmail ve;
    ValidateUsername vu;
    ValidatePassword vp=new ValidatePassword();

    public Validator(List<Customer> customers){
        ve=new ValidateEmail(customers);
        vu=new ValidateUsername(customers);
        ve.setProximo(vu);
        vu.setProximo(vp);
    }

    @Override
    public boolean validate(Customer customer){
        Validation validator=ve;
        boolean ativar=true;
        while(ativar){
            if(validator.validate(customer)){
                validator=validator.getProximo();
                if(validator==null){
                    ativar=false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}