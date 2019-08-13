package com.prueba.calculadora_rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora_rest.model.Operador;
import com.prueba.calculadora_rest.model.Operando;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OperandoController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private List<Operando> operandos = new ArrayList<>();
	private AtomicLong nextId = new AtomicLong();
	
	
	@PostMapping("/operandos")
	public String asignarOperando(@RequestBody Operando operando) {
		log.info("Asignar Operando");
		operando.setId(nextId.incrementAndGet());
		operandos.add(operando);
		return "Ok";
	}
	
	@GetMapping("/operandos")
	public List<Operando> getAllOperandos(){
		log.info("Obtiene los Operandos");
		return operandos;
	}
	
	@PostMapping("/operandos/setOperador")
	public long setOperador(@RequestBody Operador operador) {
		log.info(" Set Operador ");
		Operando operando = new Operando();
		operando.setId(nextId.incrementAndGet());
		switch (operador.getOperacion())
		{
			case "+":
				operando.setValue(suma());
				break; 
			case "-":
				operando.setValue(resta());
				break;
				
			case "*":
				operando.setValue(multiplicacion());
				break;
			case "/":
				operando.setValue(division());
				break;
		
		}
		operandos.add(operando);
		return operando.getValue();
		
	}
	
	public long suma(){
		long tot = 0;
		for (int count = 0 ; count < operandos.size() ; count ++) {
			tot += operandos.get(count).getValue();
		}
		operandos.clear();
		return tot;
		
	}
	
	public long resta(){
		long tot = 0;
		
		if(operandos.size() > 2) {
			for (int count = 0 ; count < operandos.size() ; count ++) {
				tot =- operandos.get(count).getValue();
			}
		}else {
			tot =  operandos.get(0).getValue() - operandos.get(1).getValue();
		}
		
		operandos.clear();
		return tot;
		
	}
	
	public long multiplicacion(){
		long tot = 1;
		
		if(operandos.size() > 2) {
			for (int count = 0 ; count < operandos.size() ; count ++) {
				tot = tot * operandos.get(count).getValue();
			}
		}else {
			tot =  operandos.get(0).getValue() * operandos.get(1).getValue();
		}
		
		operandos.clear();
		return tot;
		
	}
	
	
	public long division(){
		long tot = 1;
		
		if(operandos.size() > 2) {
			for (int count = 0 ; count < operandos.size() ; count ++) {
				tot =operandos.get(count).getValue() / tot;
			}
		}else {
			tot =  (operandos.get(0).getValue())  / (operandos.get(1).getValue());
		}
		
		operandos.clear();
		return tot;
		
	}
	
}
