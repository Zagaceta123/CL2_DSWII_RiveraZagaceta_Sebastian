package com.cibertec.pragma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.pragma.models.DetalleFactura;

@Repository
public interface DetalleFacturaRepository  extends JpaRepository<DetalleFactura, Long>{

}
