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
import com.cibertec.pragma.models.Producto;
import com.cibertec.pragma.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	 @Autowired
	    private ProductoService productoService;

	    @GetMapping
	    public ResponseEntity<List<Producto>> listarProductos() {
	        return ResponseEntity.ok(productoService.listarProductos());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
	        Producto producto = productoService.obtenerProductoPorId(id);
	        if (producto != null) {
	            return ResponseEntity.ok(producto);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<ResponseDTO> guardarProducto(@RequestBody Producto producto) {
	        productoService.guardarProducto(producto);
	        return new ResponseEntity<>(new ResponseDTO("Producto guardado con éxito", HttpStatus.CREATED.value()), HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseDTO> eliminarProducto(@PathVariable Long id) {
	        productoService.eliminarProducto(id);
	        return new ResponseEntity<>(new ResponseDTO("Producto eliminado con éxito", HttpStatus.OK.value()), HttpStatus.OK);
	    }
}
