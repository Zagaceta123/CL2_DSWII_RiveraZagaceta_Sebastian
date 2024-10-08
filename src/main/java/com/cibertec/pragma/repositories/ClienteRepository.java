package com.cibertec.pragma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.pragma.models.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	   Cliente findByEmail(String email);
}
