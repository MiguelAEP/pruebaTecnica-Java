package com.pruebatecnica.controllers;


import com.pruebatecnica.entidades.Customers;
import com.pruebatecnica.entidades.Employees;
import com.pruebatecnica.service.EmployeeServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceIMP employeeServiceIMP;

    @GetMapping
    public Page<Employees> listarEmployees(@PageableDefault(page = 2,size = 35) Pageable pageable) {
        return employeeServiceIMP.listarEmployees(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> listarEmployees(@PathVariable Integer id) {

        Optional<Employees> employeeBuscado = employeeServiceIMP.buscarEmployeePorId(id);
        System.out.println("Employee : " + employeeBuscado.get());

        if(employeeBuscado.isPresent()){
            return ResponseEntity.ok(employeeBuscado.get());
        }
        return ResponseEntity.notFound().build();
    }

}
