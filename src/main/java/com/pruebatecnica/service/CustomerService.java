package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Page<Customers> listarCustomer(Pageable pageable);
    public Optional<Customers> buscarCustomerPorId(Integer id);

}
