package com.bezkoder.spring.data.mongodb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bezkoder.spring.data.mongodb.model.RegistroEjercicios;
import com.bezkoder.spring.data.mongodb.repository.RegistroRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class RegistroController {

	@Autowired
	RegistroRepository RegistroRepository;

	
	@GetMapping("/registros")
	public ResponseEntity<List<RegistroEjercicios>> getAllRegistros() {
		try {
			List<RegistroEjercicios> Registros = new ArrayList<RegistroEjercicios>();
			
			RegistroRepository.findAll().forEach(Registros::add);
		
			if (Registros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			

			return new ResponseEntity<>(Registros, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	/*
	@GetMapping("/registros")
	public ResponseEntity<List<RegistroEjercicios>> getAllRegistros(@RequestParam(required = false) String nombre) {
		try {
			List<RegistroEjercicios> Registros = new ArrayList<RegistroEjercicios>();
			System.out.println("registros");
			
			List<RegistroEjercicios> registros = RegistroRepository.findAll();
			if(registros != null) {
				System.out.println("registros size" + registros.size());
			} else {
				System.out.println("No hay registros");
			}

			if (nombre == null)
				registros.forEach(Registros::add);
			else
				RegistroRepository.findByNombre(nombre).forEach(Registros::add);

			if (Registros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			

			return new ResponseEntity<>(Registros, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	@GetMapping("/registros/{id}")
	public ResponseEntity<RegistroEjercicios> getRegistroById(@PathVariable("id") long id) {
		Optional<RegistroEjercicios> RegistroData = RegistroRepository.findById(id);

		if (RegistroData.isPresent()) {
			return new ResponseEntity<>(RegistroData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping("/newRegistro")
	public ResponseEntity<RegistroEjercicios> createRegistro(@RequestBody RegistroEjercicios Registro) {
		try {		
			
			RegistroEjercicios _Registro = RegistroRepository.save(new RegistroEjercicios(Registro.getId(), Registro.getEjercicio(),
					Registro.getFechaEjecucion(), Registro.getPeso(), Registro.getRepeticiones() ,
					Registro.getDistancia(), Registro.getTiempo(), Registro.getObservaciones()));
			return new ResponseEntity<>(_Registro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	

	@DeleteMapping("/registros/{id}")
	public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("id") long id) {
		try {
			RegistroRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/registros/deleteAll")
	public ResponseEntity<HttpStatus> deleteAllRegistros() {
		try {
			
			RegistroRepository.deleteById((long) 0);
			System.out.println(RegistroRepository.count());
			List<RegistroEjercicios> regs = RegistroRepository.findAll();
			for (RegistroEjercicios reg : regs) {
				System.out.println(reg.getId());
				
			}
			RegistroRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

}
