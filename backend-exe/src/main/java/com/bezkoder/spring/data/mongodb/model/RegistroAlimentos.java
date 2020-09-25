package com.bezkoder.spring.data.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registroAlimentos")
public class RegistroAlimentos {

	@Id
	private long id;

	private long idAlimento;

	private Date fechaConsumo;

	private String observaciones;

	public RegistroAlimentos(long idAlimento, Date fechaConsumo, String observaciones) {
		super();
		this.idAlimento = idAlimento;
		this.fechaConsumo = fechaConsumo;
		this.observaciones = observaciones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
	}

	public Date getFechaConsumo() {
		return fechaConsumo;
	}

	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
