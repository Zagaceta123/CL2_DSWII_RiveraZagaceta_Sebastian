package com.cibertec.pragma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.pragma.exceptions.ResponseDTO;
import com.cibertec.pragma.models.Factura;
import com.cibertec.pragma.services.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

	   @Autowired
	    private FacturaService facturaService;

	    @GetMapping
	    public ResponseEntity<List<Factura>> listarFacturas() {
	        return ResponseEntity.ok(facturaService.listarFacturas());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
	        Factura factura = facturaService.obtenerFacturaPorId(id);
	        if (factura != null) {
	            return ResponseEntity.ok(factura);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping("/porCliente/{clienteId}")
	    public ResponseEntity<List<Factura>> listarFacturasPorCliente(@PathVariable Long clienteId) {
	        return ResponseEntity.ok(facturaService.listarFacturasPorClienteId(clienteId));
	    }

	    @PostMapping
	    public ResponseEntity<ResponseDTO> guardarFactura(@RequestBody Factura factura) {
	        facturaService.guardarFactura(factura);
	        return new ResponseEntity<>(new ResponseDTO("Factura guardada con éxito", HttpStatus.CREATED.value()), HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseDTO> eliminarFactura(@PathVariable Long id) {
	        facturaService.eliminarFactura(id);
	        return new ResponseEntity<>(new ResponseDTO("Factura eliminada con éxito", HttpStatus.OK.value()), HttpStatus.OK);
	    }
}
