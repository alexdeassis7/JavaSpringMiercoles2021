package ar.com.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.aop.dao.ClienteDao;
import ar.com.aop.dao.ClientesVIPDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
				
		//leemos la configuracion de spring
		//le indicamos al constructor cual es la clase que posee la configuracion
		AnnotationConfigApplicationContext contexto =  new AnnotationConfigApplicationContext(Configuracion.class);
				
		//obtenemos el bean del contenedor de Spring
		ClienteDao miCliente = contexto.getBean("clienteDAO", ClienteDao.class);

		ClientesVIPDAO miClienteVIP = contexto.getBean("clienteVIPDAO", ClientesVIPDAO.class);
		
		
		//llamamos al metodo 
		System.out.println("*************************miCliente.insertaCliente()****************************");
		miCliente.insertaCliente(); //este ese el nombre del metodo que debe coincidir con la anotacion before
		System.out.println("*************************miClienteVIP.insertaCliente()****************************");
		miClienteVIP.insertaCliente(); //llamamos a un metodo de otra clase pero que tiene el mismo nombre que en clienteDAO
		
		System.out.println("*************************miClienteVIP.insertaClienteVIP()****************************");
		miClienteVIP.insertaClienteVIP(); //llamamos a un metodo de otra clase pero que tiene el mismo nombre que en clienteDAO
		
		System.out.println("*************************miClienteVIP.insertaClienteVIPConError()****************************");
		try {
			miClienteVIP.insertaClienteVIPConError();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" se capturo una exception");
		} //llamamos a un metodo de otra clase pero que tiene el mismo nombre que en clienteDAO
		
		
		//cerramos el contexto 
		contexto.close();
	}

}
