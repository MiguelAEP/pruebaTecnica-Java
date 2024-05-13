package com.pruebatecnica.controllers;


import com.pruebatecnica.entidades.Customers;
import com.pruebatecnica.entidades.Employees;
import com.pruebatecnica.entidades.Orders;
import com.pruebatecnica.entidades.dto.DtoOrders;
import com.pruebatecnica.exceptions.ResourceNotFoundException;
import com.pruebatecnica.service.CustomerServiceIMP;
import com.pruebatecnica.service.EmployeeServiceIMP;
import com.pruebatecnica.service.OrderServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderServiceIMP orderServiceIMP;

    @Autowired
    private EmployeeServiceIMP employeeServiceIMP;

    @Autowired
    private CustomerServiceIMP customerServiceIMP;

    @GetMapping
    public Page<Orders> listarOders(@PageableDefault(page = 4, size = 20) Pageable pageable) {

        return orderServiceIMP.listarOrdenes(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> buscarOrderPorId(@PathVariable Integer id) {
        Optional<Orders> ordersBuscado = orderServiceIMP.buscarOrdenPorId(id);

        if (ordersBuscado.isPresent()) {
            return ResponseEntity.ok(ordersBuscado.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/customerID/{customerID}/employeID/{employeID}")
    public ResponseEntity<Orders> agregarOrders(@PathVariable Integer customerID,
                                                @PathVariable Integer employeID,
                                                @RequestBody DtoOrders dtoOrders) {

        Optional<Orders> orderExiste = orderServiceIMP.buscarOrdenPorId(dtoOrders.getOrder_id());
        if (orderExiste.isPresent()) {
          throw new ResourceNotFoundException("ya existe ese order  con ese id" + orderExiste , orderExiste.get().getOrder_id());
        }

        Optional<Customers> customersExiste = customerServiceIMP.buscarCustomerPorId(customerID);
        if (!customersExiste.isPresent()) {
            throw new ResourceNotFoundException("no existe customer con el id " + customersExiste, customerID);
        }

        Optional<Employees> employeeExiste = employeeServiceIMP.buscarEmployeePorId(employeID);
        if (!employeeExiste.isPresent()) {
            throw new ResourceNotFoundException("no existe employee con el id " + employeeExiste, employeID);
        }

        Orders orders = new Orders();
        orders.setOrder_id(dtoOrders.getOrder_id());

        orders.setCustomers(customersExiste.get());
        orders.setStatus(dtoOrders.getStatus());
        orders.setEmployees(employeeExiste.get());

        DateTimeFormatter patronFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaFormateada = LocalDate.parse(dtoOrders.getOrder_date(), patronFecha);

        orders.setOrder_date(fechaFormateada);

        Orders orderCreado = orderServiceIMP.crearOrder(orders);
        return new ResponseEntity<>(orderCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> actualizarOrders(@PathVariable Integer id, @RequestBody DtoOrders dtoOrders) {
        System.out.println(dtoOrders);
        List<Orders> orderNew = orderServiceIMP.buscarOrdenPorId(id)
                .stream()
                .map(nuevoOrder -> {
                    nuevoOrder.setOrder_id(dtoOrders.getOrder_id());
                    nuevoOrder.setCustomers(dtoOrders.getCustomers());
                    nuevoOrder.setStatus(dtoOrders.getStatus());
                    nuevoOrder.setEmployees(dtoOrders.getEmployees());
                    DateTimeFormatter patronFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaFormateada = LocalDate.parse(dtoOrders.getOrder_date(), patronFecha);

                    nuevoOrder.setOrder_date(fechaFormateada);
                    return nuevoOrder;
                }).toList();

        Orders orderFinal = orderServiceIMP.actualizarOrden(orderNew.get(0));
        return ResponseEntity.ok(orderFinal);
    }


}
