package com.pruebatecnica.repository;

import com.pruebatecnica.entidades.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {
}
