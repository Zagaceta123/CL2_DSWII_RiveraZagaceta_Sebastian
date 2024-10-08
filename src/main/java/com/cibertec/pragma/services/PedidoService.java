package com.cibertec.pragma.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.pragma.models.Pedido;
import com.cibertec.pragma.repositories.PedidoRepository;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPedidosPorRangoFechas(Date fechaInicio, Date fechaFin) {
        return pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
