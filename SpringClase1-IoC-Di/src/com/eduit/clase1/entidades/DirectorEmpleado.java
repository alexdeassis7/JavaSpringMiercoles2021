package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.IEmpleados;

public class DirectorEmpleado implements IEmpleados{
	//creacion de campo tipo CreacionInforme(Interface) , para la inyeccion de dependencia 
	private CreacionInformes informeNuevo;
	
	
	
//	public DirectorEmpleado() {
//		
//	}

	//creacion de constructor que inyecta la dependencia 
	 public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	@Override
	public String getTareas() {	
		return "Soy el Director , y gestiono "
				+ "la nomina de Empleados!";
	}

	@Override
	public String getInforme() {
		//utilizamos el metodo getInforme de laq interface 
		return "Informe creado por el director : " + informeNuevo.getInforme();
	}

}
 