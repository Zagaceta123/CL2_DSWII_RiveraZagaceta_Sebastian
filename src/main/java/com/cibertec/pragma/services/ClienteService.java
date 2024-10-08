package com.cibertec.pragma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.pragma.models.Cliente;
import com.cibertec.pragma.repositories.ClienteRepository;

@Service
public class ClienteService {

	  @Autowired
	    private ClienteRepository clienteRepository;

	    public List<Cliente> listarClientes() {
	        return clienteRepository.findAll();
	    }

	    public Cliente obtenerClientePorId(Long id) {
	        return clienteRepository.findById(id).orElse(null);
	    }

	    public Cliente guardarCliente(Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    public void eliminarCliente(Long id) {
	        clienteRepository.deleteById(id);
	    }
}
