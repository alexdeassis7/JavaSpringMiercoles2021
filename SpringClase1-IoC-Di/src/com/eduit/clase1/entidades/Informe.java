package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;

public class Informe implements CreacionInformes{

	@Override
	public String getInforme() {
		
		return "esto es un inform detallado , demo de Inyeccion de dependencias,"
				+ "y es la caracteristica comun que tienen todos los objetos (Jefe,sercertario, director)";
	}

}
