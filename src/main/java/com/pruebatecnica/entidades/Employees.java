package com.pruebatecnica.entidades;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;

import java.util.Date;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Integer employee_id;

    @Column(name = "FIRST_NAME" ,length = 60 ,nullable = false)
    private String first_name;

    @Column(name = "LAST_NAME" ,length = 60 ,nullable = false)
    private String last_name;

    @Column(name = "EMAIL" ,length = 60 ,nullable = false)
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    private String email;

    @Column(name = "PHONE" ,length = 60 ,nullable = false)
    private String phone;

    @Column(name = "HIRE_DATE" ,length = 60 ,nullable = false)
    private Date hire_date;
    @Column(name = "MANAGER_ID")
    private Integer manager_id;

    @Column(name = "JOB_TITLE" ,length = 60 ,nullable = false)
    private String job_title;


    public Employees() {
    }

    public Employees(Integer employee_id, String first_name, String last_name, String email, String phone, Date hire_date, Integer manager_id, String job_title) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.hire_date = hire_date;
        this.manager_id = manager_id;
        this.job_title = job_title;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hire_date=" + hire_date +
                ", manager_id=" + manager_id +
                ", job_title='" + job_title + '\'' +
                '}';
    }
}
