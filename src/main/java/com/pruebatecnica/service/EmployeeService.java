package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Customers;
import com.pruebatecnica.entidades.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Page<Employees> listarEmployees(Pageable pageable);
    public Optional<Employees> buscarEmployeePorId(Integer id);

}
