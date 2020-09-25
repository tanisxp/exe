package com.bezkoder.spring.data.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registroEjercicios")
public class RegistroEjercicios {

	@Id
	private long id;

	private long idEjercicio;
	
	private String ejercicio;

	private Date fechaEjecucion;

	private Integer peso;

	private Integer repeticiones;

	private Integer distancia;

	private Integer tiempo;

	private String observaciones;

	public RegistroEjercicios(long idEjercicio, String ejercicio, Date fechaEjecucion, Integer peso, Integer repeticiones,
			Integer distancia, Integer tiempo, String observaciones) {
		super();
		this.idEjercicio = idEjercicio;
		this.id = idEjercicio;
		this.ejercicio = ejercicio;
		this.fechaEjecucion = fechaEjecucion;
		this.peso = peso;
		this.repeticiones = repeticiones;
		this.distancia = distancia;
		this.tiempo = tiempo;
		this.observaciones = observaciones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(long idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(Integer repeticiones) {
		this.repeticiones = repeticiones;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	
	
}
