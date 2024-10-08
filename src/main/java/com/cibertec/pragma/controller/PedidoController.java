package com.cibertec.pragma.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.pragma.exceptions.ResponseDTO;
import com.cibertec.pragma.models.Pedido;
import com.cibertec.pragma.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	 @Autowired
	    private PedidoService pedidoService;

	    @GetMapping
	    public ResponseEntity<List<Pedido>> listarPedidos() {
	        return ResponseEntity.ok(pedidoService.listarPedidos());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
	        Pedido pedido = pedidoService.obtenerPedidoPorId(id);
	        if (pedido != null) {
	            return ResponseEntity.ok(pedido);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<ResponseDTO> guardarPedido(@RequestBody Pedido pedido) {
	        pedidoService.guardarPedido(pedido);
	        return new ResponseEntity<>(new ResponseDTO("Pedido guardado con éxito", HttpStatus.CREATED.value()), HttpStatus.CREATED);
	    }

	    @GetMapping("/buscarPorFechas")
	    public ResponseEntity<List<Pedido>> listarPedidosPorRangoFechas(@RequestParam("inicio") Date inicio, @RequestParam("fin") Date fin) {
	        return ResponseEntity.ok(pedidoService.listarPedidosPorRangoFechas(inicio, fin));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseDTO> eliminarPedido(@PathVariable Long id) {
	        pedidoService.eliminarPedido(id);
	        return new ResponseEntity<>(new ResponseDTO("Pedido eliminado con éxito", HttpStatus.OK.value()), HttpStatus.OK);
	    }
}
