package com.pruebatecnica.repository;

import com.pruebatecnica.entidades.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
}
