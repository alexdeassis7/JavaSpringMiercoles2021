package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.IEmpleados;

//Esta clase solo tendra en princio un Getters
public class JefeEmpleado implements IEmpleados{

	//Sobreescribo el metodo de la interface
	public String getTareas() {
		return "Soy un Jefe Empleado , y me encargo de controlar , asi que "
				+ "o me obedeces o renuncian ";
	}

	@Override
	public String getInforme() {
		
		return "";
	}
}
