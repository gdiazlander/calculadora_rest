package com.prueba.calculadora_rest.model;

public class Operando {
	private long id;
	private long value;
	
	public Operando() {
		
	}
	
	public Operando(long id, long value) {
		super();
		this.id = id;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	} 
	
	
	
	
}
