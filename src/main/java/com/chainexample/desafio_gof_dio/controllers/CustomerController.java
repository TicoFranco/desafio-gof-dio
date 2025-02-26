package com.chainexample.desafio_gof_dio.controllers;

import com.chainexample.desafio_gof_dio.dtos.Customerdto;
import com.chainexample.desafio_gof_dio.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServices services;

    @GetMapping
    public ResponseEntity customersList(){
        return ResponseEntity.status(HttpStatus.OK).body(services.customersList());
    }


    @GetMapping("/{id}")
    public ResponseEntity findCustomer(@PathVariable("id") Long id){
        if(services.findCustomer(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services.findCustomer(id));
    }

    @PostMapping
    public ResponseEntity postCustomer(@RequestBody Customerdto dto){
        if (services.postCustomer(dto)){
            return ResponseEntity.status(HttpStatus.CREATED).body("cliente cadastrado");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("nao foi possivel cadastrar o cliente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(services.deleteCustomer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity putCustomer(@PathVariable("id") Long id,@RequestBody Customerdto dto){
        if (services.putCustomer(dto,id)){
            return ResponseEntity.status(HttpStatus.OK).body("cliente atualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nao foi possivel atualizar o cliente");
    }
}
