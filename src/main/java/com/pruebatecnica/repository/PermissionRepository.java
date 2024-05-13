package com.pruebatecnica.repository;


import com.pruebatecnica.entidades.entidadesAuth.Permisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permisions,Integer> {
}
