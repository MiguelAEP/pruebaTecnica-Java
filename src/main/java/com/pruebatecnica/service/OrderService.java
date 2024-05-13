package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Page<Orders> listarOrdenes(Pageable pageable);

    public Optional<Orders> buscarOrdenPorId(Integer id);

    public Orders crearOrder(Orders orders);

    public Orders actualizarOrden(Orders orders);

}
