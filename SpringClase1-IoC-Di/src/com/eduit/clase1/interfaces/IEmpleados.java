package com.eduit.clase1.interfaces;

//creamos una Abstraccion , que tiene el metodo getTareas
public interface IEmpleados {
	public String getTareas() ;
	
	//este metodo lo utilizaremos para la DI Inyeccion de dependencias
	public String getInforme();
}
