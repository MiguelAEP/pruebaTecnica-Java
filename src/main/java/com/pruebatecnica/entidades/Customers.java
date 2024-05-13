package com.pruebatecnica.entidades;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Integer customer_id;

    @Column(name = "NAME" ,length = 60 ,nullable = false)
    private String name;

    @Column(name = "ADDRESS" ,length = 60 ,nullable = false)
    private String address;

    @Column(name = "WEBSITE" ,length = 60 ,nullable = false)
    private String website;

    @Column(name = "CREDIT_LIMIT" ,length = 60 ,nullable = false)
    private Integer credit_limit;


    public Customers() {
    }

    public Customers(Integer customer_id, String name, String address, String website, Integer credit_limit) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
        this.website = website;
        this.credit_limit = credit_limit;

    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Integer credit_limit) {
        this.credit_limit = credit_limit;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", credit_limit=" + credit_limit +
                '}';
    }
}
