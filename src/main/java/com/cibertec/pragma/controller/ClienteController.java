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
import com.cibertec.pragma.models.Cliente;
import com.cibertec.pragma.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	 @Autowired
	    private ClienteService clienteService;

	    @GetMapping
	    public ResponseEntity<List<Cliente>> listarClientes() {
	        return ResponseEntity.ok(clienteService.listarClientes());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
	        Cliente cliente = clienteService.obtenerClientePorId(id);
	        if (cliente != null) {
	            return ResponseEntity.ok(cliente);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<ResponseDTO> guardarCliente(@RequestBody Cliente cliente) {
	        clienteService.guardarCliente(cliente);
	        return new ResponseEntity<>(new ResponseDTO("Cliente guardado con éxito", HttpStatus.CREATED.value()), HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseDTO> eliminarCliente(@PathVariable Long id) {
	        clienteService.eliminarCliente(id);
	        return new ResponseEntity<>(new ResponseDTO("Cliente eliminado con éxito", HttpStatus.OK.value()), HttpStatus.OK);
	    }
}
