package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Customers;
import com.pruebatecnica.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMP implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customers> listarCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customers> buscarCustomerPorId(Integer id) {
        return customerRepository.findById(id);
    }
}
