package com.educacionit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//indicamos que esta clase es un controlador 
public class Controlador {
	//url de test : http://localhost:8080/Clase4_Spring_MVC
	
	//creamos un metodo que sera el encagado de especificar que vista queremos que nos proporcione
	//nuestro proyecto , este metodo mapea que vista queremos retornar al usuario
	@RequestMapping
	public String muestraPagina() {
		//aqui le decimos la vista en particular que vamos a retonar
		//no necesita ni la ruta y tampoco la extension , esto es gracias al prefix y suffix
		return "paginaEjemplo";	
	}
	

}
