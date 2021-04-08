package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteDao {

	public void insertaCliente() {
		// aqui estaria todo el codigo de la insercion en la base

		System.out.println("Se inserto el cliente en la base de datos correctamente");
	}
}
