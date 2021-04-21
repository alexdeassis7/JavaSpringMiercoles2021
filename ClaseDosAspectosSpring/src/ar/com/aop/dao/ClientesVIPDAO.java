package ar.com.aop.dao;

import org.springframework.stereotype.Component;

@Component("clienteVIPDAO")
public class ClientesVIPDAO {
	//esta clase posee un metodo (insertaCliente()) con el mismo nombre que la clase clientDAO()
	public void insertaCliente() {

		// aqui estaria el codigo de insercion en la DB , como la idea de este turotial
		// es
		// ver aspectos solamente nos vamos a imaginar que efectivamente se inserto un
		// cliente

		System.out.println("insertaCliente()  se inserto el cliente VIPPPPPP en la base de datos correctamente ");
	}
	
	
	
	public void insertaClienteVIP() {

		// aqui estaria el codigo de insercion en la DB , como la idea de este turotial
		// es
		// ver aspectos solamente nos vamos a imaginar que efectivamente se inserto un
		// cliente

		System.out.println("insertaClienteVIP() se inserto el cliente VIPPPPPP en la base de datos correctamente ");
	}
	
	
	public void insertaClienteVIPConError() throws Exception {

		// aqui estaria el codigo de insercion en la DB , como la idea de este turotial
		// es
		// ver aspectos solamente nos vamos a imaginar que efectivamente se inserto un
		// cliente

		System.out.println("insertaClienteVIPConError() se inserto el cliente VIPPPPPP en la base de datos correctamente ");
		//throw new Exception();
	}
}
