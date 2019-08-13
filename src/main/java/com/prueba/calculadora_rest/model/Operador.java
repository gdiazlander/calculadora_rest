package com.prueba.calculadora_rest.model;

public class Operador {
	private long id;
	private String operacion;
	
	public Operador() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Operador(long id, String operacion) {
		super();
		this.id = id;
		this.operacion = operacion;
	}
}
