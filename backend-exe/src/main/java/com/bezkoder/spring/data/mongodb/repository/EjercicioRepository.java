package com.bezkoder.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.data.mongodb.model.Ejercicio;



public interface EjercicioRepository extends MongoRepository<Ejercicio, Long> {
	List<Ejercicio> findByNombre(String nombre);
	//List<Ejercicio> findByCategory(String categoria);
	//List<Ejercicio> findByType(String tipo);
	
}
