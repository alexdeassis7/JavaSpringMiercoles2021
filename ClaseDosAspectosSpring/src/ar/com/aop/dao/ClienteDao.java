package ar.com.aop.dao;

import org.springframework.stereotype.Component;

//esta clase debe funcionar a modo de componenente asi que agregamos la 
//anotattion @Component
@Component("clienteDAO")
public class ClienteDao {
	//ante de ejecutar este metodo por detras y de manera automatica 
	//se deberia ejecutar el aspecto que comprueba que 
	//el user esta logueado y que el login es correcto
	//(con los roles necesarios para insertar un cliente )	
	public void insertaCliente() {
		
		//aqui estaria el codigo de insercion en la DB , como la idea de este turotial es 
		//ver aspectos solamente nos vamos a imaginar que efectivamente se inserto un cliente 
		
		System.out.println("se inserto el cliente en la base de datos correctamente ");
	}
}
