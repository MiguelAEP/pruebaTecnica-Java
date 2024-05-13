package com.pruebatecnica.controllers;

import com.pruebatecnica.entidades.dto.AuthCreateUserRequest;
import com.pruebatecnica.entidades.dto.ResponseLogin;
import com.pruebatecnica.entidades.dto.UserAuthRequestLogin;
import com.pruebatecnica.service.UsuarioServiceIMP;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioServiceIMP usuarioServiceIMP;

    @PostMapping("/login")
    public ResponseEntity<ResponseLogin> login(@RequestBody @Valid UserAuthRequestLogin userAuthRequestLogin){
            ResponseLogin responseLogin = usuarioServiceIMP.login(userAuthRequestLogin);
        System.out.println("responseLogin controller " + responseLogin);
            return new ResponseEntity<>(responseLogin, HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseLogin> register(@RequestBody @Valid AuthCreateUserRequest authCreateUserRequest){
        return new ResponseEntity<>(usuarioServiceIMP.createUser(authCreateUserRequest),HttpStatus.CREATED);
    }


}
