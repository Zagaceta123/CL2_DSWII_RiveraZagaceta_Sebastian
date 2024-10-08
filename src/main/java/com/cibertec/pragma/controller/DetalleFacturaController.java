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
import com.cibertec.pragma.models.DetalleFactura;
import com.cibertec.pragma.services.DetalleFacturaService;

@RestController
@RequestMapping("/api/detallesFactura")
public class DetalleFacturaController {

	 @Autowired
	    private DetalleFacturaService
	    detalleFacturaService;

	    @GetMapping
	    public ResponseEntity<List<DetalleFactura>> listarDetallesFactura() {
	        return ResponseEntity.ok(detalleFacturaService.listarDetallesFactura());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DetalleFactura> obtenerDetalleFacturaPorId(@PathVariable Long id) {
	        DetalleFactura detalleFactura = detalleFacturaService.obtenerDetalleFacturaPorId(id);
	        if (detalleFactura != null) {
	            return ResponseEntity.ok(detalleFactura);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<ResponseDTO> guardarDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
	        detalleFacturaService.guardarDetalleFactura(detalleFactura);
	        return new ResponseEntity<>(new ResponseDTO("Detalle de factura guardado con éxito", HttpStatus.CREATED.value()), HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseDTO> eliminarDetalleFactura(@PathVariable Long id) {
	        detalleFacturaService.eliminarDetalleFactura(id);
	        return new ResponseEntity<>(new ResponseDTO("Detalle de factura eliminado con éxito", HttpStatus.OK.value()), HttpStatus.OK);
	    }
}
