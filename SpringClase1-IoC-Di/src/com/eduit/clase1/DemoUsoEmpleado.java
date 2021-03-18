package com.eduit.clase1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase1.entidades.DirectorEmpleado;

//import java.util.Scanner;
//
//import javax.swing.JOptionPane;

import com.eduit.clase1.entidades.JefeEmpleado;
import com.eduit.clase1.entidades.SecretarioEmpleado;
import com.eduit.clase1.interfaces.IEmpleados;

public class DemoUsoEmpleado {
	public static void main(String[] args) {
		
		//creamos objetos de tipo empleado 
		JefeEmpleado e1 = new JefeEmpleado();
		
		//me creo una referencia a la abstraccion 
		IEmpleados e2 = new JefeEmpleado();
		IEmpleados e3 = new SecretarioEmpleado();
		// el problema que se plantea aqui es que si quiero crear un 
		/*crear un objeto de un tipo diferente me veo oblicado a 
		 * modificar el codigo y definir una nueva clase ....
		 * por ej y si quiero dejar de usar una clase deberia eliminarla ...
		 * */		
//		IEmpleados e4 = new DirectorEmpleado();
		
		
		//uso de los objetos creados
		System.out.println("empleado1 : " + e1.getTareas());
		System.out.println("empleado2 : " + e2.getTareas());
		System.out.println("empleado3 : " + e3.getTareas());
		
		System.out.println("Demo IOC Spring XML ");
		//AHORA HACEMOS LO MISMO PERO CON EL CONTENEDOR DE SPRING 
		//PASO 1 ) CARGAR EL XML  
		//primero creamos un contexto y le ponemos el nombre del archivo con extension ".xml"
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Paso 2 Pedirle el beans al archivo xml , pasandole el alias o id 
		///y en segundo lugar le paso en nombre de la interface
		IEmpleados alex = contexto.getBean("miEmpleado" , IEmpleados.class);
		
		//paso 3 utilizamos el objeto 
		System.out.println("utilizamos el bean :" + alex.getTareas());
		
		
		
		
		//DEMO INYECCION DEPENDECIA : la ventaja de esto es que ahora podemos reutilizarlo en otra clase como por eje 
		//en JefeEmpleado
		
		System.out.println("Utilizamos Inyeccion de dependencia : " +alex.getInforme());
		
		
		
		//paso 4 cerramos el contexto , y liberamos los recursos 
		contexto.close();
		
		
		
		
//		int num = 0 ; 
//		int num2 = 0 ; 
//		
//		Scanner teclado = new Scanner(System.in);
//		System.out.println("ingrese num 1 ");
//		num = teclado.nextInt();
//		
//		System.out.println("ingrese num 2 ");
//		num2 = teclado.nextInt();
//		System.out.println("RESULTADO SUMA : " + (num + num2));
//		
//		
//		String nombre = JOptionPane.showInputDialog("Ingrese su  nombre !");
		
		}
}
