package com.pruebatecnica.controllers;


import com.pruebatecnica.entidades.Customers;
import com.pruebatecnica.service.CustomerServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceIMP customerServiceIMP;

    @GetMapping
    public Page<Customers> listarCustomer(@PageableDefault(page = 4,size = 20)Pageable pageable) {

        return customerServiceIMP.listarCustomer(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> buscarCustomerPorId(@PathVariable Integer id) {
        Optional<Customers> customerBuscado = customerServiceIMP.buscarCustomerPorId(id);

        if (customerBuscado.isPresent()) {
            return ResponseEntity.ok(customerBuscado.get());
        }
        return ResponseEntity.notFound().build();

    }

}
