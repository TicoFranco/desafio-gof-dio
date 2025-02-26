package com.chainexample.desafio_gof_dio.services;

import com.chainexample.desafio_gof_dio.dtos.Customerdto;
import com.chainexample.desafio_gof_dio.models.Customer;
import com.chainexample.desafio_gof_dio.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> customersList(){
        List<Customer> customersList=repository.findAll();
        return customersList;
    }

    public Customer findCustomer(Long id){
        Optional<Customer> customer=repository.findById(id);
        if(customer.isEmpty()){
            return null;
        }
        return customer.get();
    }

    public String deleteCustomer(Long id){
        Optional<Customer> customer=repository.findById(id);
        if(customer.isEmpty()){
            return "cliente nao encontrado";
        }
        repository.delete(customer.get());
        return "cliente deletado com sucesso";
    }

    public boolean postCustomer(Customerdto dto){
        var customer = new Customer();
        BeanUtils.copyProperties(dto,customer);
        Validator inspector=new Validator(customersList());
        if (inspector.validate(customer)) {
            repository.save(customer);
            return true;
        }
        return false;
    }

    public boolean putCustomer(Customerdto dto,Long id){
        Optional<Customer> aux=repository.findById(id);
        if(aux.isEmpty()){
            return false;
        }
        var customer=aux.get();
        BeanUtils.copyProperties(dto,customer);
        Validator inspector=new Validator(customersList());
        if(inspector.validate(customer)){
            repository.save(customer);
            return true;
        }
        return false;
    }
}
