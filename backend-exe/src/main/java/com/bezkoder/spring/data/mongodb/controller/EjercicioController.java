package com.bezkoder.spring.data.mongodb.controller;

import java.util.ArrayList;
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

import com.bezkoder.spring.data.mongodb.model.Ejercicio;
import com.bezkoder.spring.data.mongodb.model.RegistroEjercicios;
import com.bezkoder.spring.data.mongodb.repository.EjercicioRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class EjercicioController {

	@Autowired
	EjercicioRepository EjercicioRepository;

	
	@GetMapping("/")
	public ResponseEntity<List<Ejercicio>> getAllEjercicios() {
		try {
			List<Ejercicio> Ejercicios = new ArrayList<Ejercicio>();

			EjercicioRepository.findAll().forEach(Ejercicios::add);
		
			if (Ejercicios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			

			return new ResponseEntity<>(Ejercicios, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/ejercicios")
	public ResponseEntity<List<Ejercicio>> getAllEjercicios(@RequestParam(required = false) String nombre) {
		try {
			List<Ejercicio> Ejercicios = new ArrayList<Ejercicio>();
			System.out.println("ejercicios");
			
			List<Ejercicio> ejercicios = EjercicioRepository.findAll();
			if(ejercicios != null) {
				System.out.println("ejercicios size" + ejercicios.size());
			} else {
				System.out.println("No hay ejercicios");
			}

			if (nombre == null)
				ejercicios.forEach(Ejercicios::add);
			else
				EjercicioRepository.findByNombre(nombre).forEach(Ejercicios::add);

			if (Ejercicios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			

			return new ResponseEntity<>(Ejercicios, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/ejercicios/{id}")
	public ResponseEntity<Ejercicio> getEjercicioById(@PathVariable("id") long id) {
		Optional<Ejercicio> EjercicioData = EjercicioRepository.findById(id);

		if (EjercicioData.isPresent()) {
			return new ResponseEntity<>(EjercicioData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/newEjercicio")
	public ResponseEntity<Ejercicio> createEjercicio(@RequestBody Ejercicio Ejercicio) {
		try {			
			Ejercicio _Ejercicio = EjercicioRepository.save(new Ejercicio(Ejercicio.getId(), Ejercicio.getNombre(),
					Ejercicio.getDescripcion(), Ejercicio.getCategoria(), Ejercicio.getTipo()));
			return new ResponseEntity<>(_Ejercicio, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/ejercicios/{id}")
	public ResponseEntity<Ejercicio> updateEjercicio(@PathVariable("id") long id, @RequestBody Ejercicio Ejercicio) {
		Optional<Ejercicio> EjercicioData = EjercicioRepository.findById(id);

		if (EjercicioData.isPresent()) {
			Ejercicio _Ejercicio = EjercicioData.get();
			_Ejercicio.setNombre(Ejercicio.getNombre());
			_Ejercicio.setDescripcion(Ejercicio.getDescripcion());
			_Ejercicio.setCategoria(Ejercicio.getCategoria());
			_Ejercicio.setTipo(Ejercicio.getTipo());
			return new ResponseEntity<>(EjercicioRepository.save(_Ejercicio), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/ejercicios/{id}")
	public ResponseEntity<HttpStatus> deleteEjercicio(@PathVariable("id") long id) {
		try {
			EjercicioRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/ejercicios")
	public ResponseEntity<HttpStatus> deleteAllEjercicios() {
		try {
			EjercicioRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

}
