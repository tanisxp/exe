package com.bezkoder.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alimentos")
public class Alimento {

	@Id
	private long id;

	private String nombre;

	private String descripcion;

	private Integer calorias;

	private Integer grasas;

	private Integer proteinas;

	private Integer carbohidratos;

	public Alimento() {

	}

	public Alimento(String nombre, String descripcion, Integer calorias, Integer grasas, Integer proteinas,
			Integer carbohidratos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.calorias = calorias;
		this.grasas = grasas;
		this.proteinas = proteinas;
		this.carbohidratos = carbohidratos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public Integer getGrasas() {
		return grasas;
	}

	public void setGrasas(Integer grasas) {
		this.grasas = grasas;
	}

	public Integer getProteinas() {
		return proteinas;
	}

	public void setProteinas(Integer proteinas) {
		this.proteinas = proteinas;
	}

	public Integer getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(Integer carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

}
