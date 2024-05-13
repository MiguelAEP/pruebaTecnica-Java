package com.pruebatecnica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private Integer id;

    public ResourceNotFoundException(String message,Integer id) {
        super(message);
        this.id = id;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{" +
                "no existe el usuario con el"+
                "id=" + id +
                '}';
    }
}
