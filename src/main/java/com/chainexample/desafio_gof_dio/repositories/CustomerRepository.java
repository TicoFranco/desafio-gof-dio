package com.chainexample.desafio_gof_dio.repositories;

import com.chainexample.desafio_gof_dio.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
