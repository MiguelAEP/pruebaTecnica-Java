package com.pruebatecnica.entidades.entidadesAuth;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleEnum roleEnum;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name ="rol_permision", joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "permisions_id"))
    private List<Permisions> permisions = new ArrayList<>();

    public Rol() {
    }

    public Rol(Integer id, RoleEnum roleEnum, List<Permisions> permisions) {
        this.id = id;
        this.roleEnum = roleEnum;
        this.permisions = permisions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public List<Permisions> getPermisions() {
        return permisions;
    }

    public void setPermisions(List<Permisions> permisions) {
        this.permisions = permisions;
    }
}
