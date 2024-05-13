package com.pruebatecnica.entidades.dto;

import com.pruebatecnica.entidades.Customers;
import com.pruebatecnica.entidades.Employees;

public class DtoOrders {

    private Integer order_id;

    private Customers customers;

    private String status;

    private Employees employees;

    private String order_date;

    public DtoOrders() {
    }

    public DtoOrders(Integer order_id, Customers customers, String status, Employees employees, String order_date) {
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

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "DtoOrders{" +
                "order_id=" + order_id +
                ", customers=" + customers +
                ", status='" + status + '\'' +
                ", employees=" + employees +
                ", order_date='" + order_date + '\'' +
                '}';
    }
}
