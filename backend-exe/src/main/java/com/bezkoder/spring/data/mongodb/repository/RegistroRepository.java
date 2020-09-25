package com.bezkoder.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.data.mongodb.model.Ejercicio;
import com.bezkoder.spring.data.mongodb.model.RegistroEjercicios;



public interface RegistroRepository extends MongoRepository<RegistroEjercicios, Long> {
	//List<RegistroEjercicios> findByNombre(String nombre);
	//List<Ejercicio> findByCategory(String categoria);
	//List<Ejercicio> findByType(String tipo);
	
}
