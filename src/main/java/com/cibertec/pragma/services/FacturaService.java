package com.cibertec.pragma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.pragma.models.Factura;
import com.cibertec.pragma.repositories.FacturaRepository;

@Service
public class FacturaService {

	
	 @Autowired
	    private FacturaRepository facturaRepository;

	    public List<Factura> listarFacturas() {
	        return facturaRepository.findAll();
	    }

	    public List<Factura> listarFacturasPorClienteId(Long clienteId) {
	        return facturaRepository.findByClienteId(clienteId);
	    }

	    public Factura obtenerFacturaPorId(Long id) {
	        return facturaRepository.findById(id).orElse(null);
	    }

	    public Factura guardarFactura(Factura factura) {
	        return facturaRepository.save(factura);
	    }

	    public void eliminarFactura(Long id) {
	        facturaRepository.deleteById(id);
	    }
}
