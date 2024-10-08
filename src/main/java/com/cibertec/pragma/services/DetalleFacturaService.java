package com.cibertec.pragma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.pragma.models.DetalleFactura;
import com.cibertec.pragma.repositories.DetalleFacturaRepository;

@Service
public class DetalleFacturaService {

	  @Autowired
	    private DetalleFacturaRepository detalleFacturaRepository;

	    public List<DetalleFactura> listarDetallesFactura() {
	        return detalleFacturaRepository.findAll();
	    }

	    public DetalleFactura obtenerDetalleFacturaPorId(Long id) {
	        return detalleFacturaRepository.findById(id).orElse(null);
	    }

	    public DetalleFactura guardarDetalleFactura(DetalleFactura detalleFactura) {
	        return detalleFacturaRepository.save(detalleFactura);
	    }

	    public void eliminarDetalleFactura(Long id) {
	        detalleFacturaRepository.deleteById(id);
	    }
}
