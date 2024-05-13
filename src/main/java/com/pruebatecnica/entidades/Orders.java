package com.pruebatecnica.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customers customers;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "SALESMAN_ID")
    private Employees employees;

    @Column(name = "ORDER_DATE")
    private LocalDate order_date;


    public Orders() {
    }

    public Orders(Integer order_id, Customers customers, String status, Employees employees, LocalDate order_date) {
        this.order_id = order_id;
        this.customers = customers;
        this.status = status;
        this.employees = employees;
        this.order_date = order_date;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }


    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", customers=" + customers +
                ", status='" + status + '\'' +
                ", employees=" + employees +
                ", order_date=" + order_date +
                '}';
    }
}
