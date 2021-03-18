package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.IEmpleados;

public class SecretarioEmpleado implements IEmpleados {

	@Override
	public String getTareas() {

		return "Soy un secretario y me gusta"
				+ " obedecer a mi superior ";
	}
	@Override
	public String getInforme() {
		
		return "";
	}
}
