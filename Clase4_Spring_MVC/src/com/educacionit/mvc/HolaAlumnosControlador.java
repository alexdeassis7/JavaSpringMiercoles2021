package com.educacionit.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//en esta clase crearemos dos metodos uno pedira el formulario y el otro metodo 
//procesara la informacion que el usuario completo en eel formulario 

@Controller
public class HolaAlumnosControlador {

	// este metodo proporcionara el formulario al usuario
	@RequestMapping("/muestraFormulario") // le indicamos a spring que haremos una peticion
	// de una url , por convencion se utilizas el mismo nombre del metodo
	public String muestraFormulario() {
		return "HolaAlumnosFormulario";
	}

	// este metodo procesa el form recibido y envia la respuesta al user luego de
	// terminar
	// el procesamiento de todos los datos del form
	@RequestMapping("/procesarFormulario") // le indicamos a spring que haremos una peticion
	// de una url , por convencion se utilizas el mismo nombre del metodo
	public String procesarFormulario() {
		return "HolaAlumnosSpring";
	}

	// este metodo procesa la informacion del modelo y llama luego a la vista
	@RequestMapping("/procesarFormulario2") 
	//aqui recibo dos parametros el request y el modelo 
	public String procesarFormulario2(HttpServletRequest request , Model modelo) {
		//leemos la informacuion que viene del input de nuestro form (osea el nombre )
		String nombre = request.getParameter("nombreAlumno");
		
		//le agrego informacion al modelo 
		nombre += " es el alumnos mejor calificado del 2021";
		
		String mensajeFinal = "quien es el mejor alumno?? "  +nombre;
		
		//agregando informacion o datos al modelo 
		modelo.addAttribute("mensaje" , mensajeFinal);
		
		return "HolaAlumnosSpring";
	}

}
