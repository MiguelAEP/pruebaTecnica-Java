package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Employees;
import com.pruebatecnica.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceIMP implements EmployeeService{

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Page<Employees> listarEmployees(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    @Override
    public Optional<Employees> buscarEmployeePorId(Integer id) {
        return employeesRepository.findById(id);
    }
}
