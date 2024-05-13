package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Orders;
import com.pruebatecnica.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIMP implements OrderService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Page<Orders> listarOrdenes(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public Optional<Orders> buscarOrdenPorId(Integer id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders crearOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders actualizarOrden(Orders orders) {
        return ordersRepository.save(orders);
    }
}
