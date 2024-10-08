package com.cibertec.pragma.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.pragma.models.Pedido;
import com.cibertec.pragma.models.Producto;
import com.cibertec.pragma.repositories.PedidoRepository;
import com.cibertec.pragma.repositories.ProductoRepository;

@Service
public class ProductoService {

	   @Autowired
	    private ProductoRepository productoRepository;

	    public List<Producto> listarProductos() {
	        return productoRepository.findAll();
	    }

	    public Producto obtenerProductoPorId(Long id) {
	        return productoRepository.findById(id).orElse(null);
	    }

	    public Producto guardarProducto(Producto producto) {
	        return productoRepository.save(producto);
	    }

	    public void eliminarProducto(Long id) {
	        productoRepository.deleteById(id);
	    }
}
