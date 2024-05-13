package com.pruebatecnica;

import com.pruebatecnica.entidades.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import java.util.List;

@SpringBootApplication
public class PruebaRestSpringApplication  {



	public static void main(String[] args) {
		SpringApplication.run(PruebaRestSpringApplication.class, args);
	}


}
