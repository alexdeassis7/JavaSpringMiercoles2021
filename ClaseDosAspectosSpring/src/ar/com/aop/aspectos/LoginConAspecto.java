package ar.com.aop.aspectos;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//esta clase sera nuestro aspecto ,
//con esa funcionalidad transversal que tiene que ejecutarse siempre 

@Component // indicamos que es un component
@Aspect // indicamos que esta clase es un aspecto
public class LoginConAspecto {

	// utilizamos before para que se ejecute ANTES del metodo insertaCliente
	// que pasa si tengo mas de un metodo con este nombre en distintas
	// clases?,hagamos la prueba
	// con la ClaseClienteVIPDAO(), el aspecto se va a ejecutar siempre por que no
	// hace distinciones
	// nombre de clase , que pasa si solo quiere que se ejecute el aspecto para
	// clientes VIP ?
	// como podemos hacerlo ? simplemente utilizando un pointCutExpression
	// para ello debemos incluir la ruta en la anotacion before
	// por ejemplo :
	// @Before("execution(public void
	// ar.com.aop.dao.ClientesVIPDAO.insertaCliente())")
//	si quiero que se ejecute para todos los metodo que se llamen inserta....*() 
	// utilizo asi , lo que realizamos en estos casos
	// es crear la el pointCut de esta manera @Before("execution(public void
	// inserta*())")
	@Before("execution(public void insertaCliente())")
	public void antesInsertarCliente() {

		System.out.println("Se comprobo y el usuario esta logeado");
		System.out.println("el Role/Perfil de usuario logeado es el correcto y puede inserta datos en la DB");

	}

//	Esta anotación ejecuta un advice después de la ejecución del pointCut 
//	especificado, siempre que el método del punto de corte retorne 
//	de forma normal (sin generar excepciones)
	@AfterReturning("execution(public void insertaCliente())")
	public void despuesDeInsertarCliente() {
		System.out.println("este metodo se ejecuta despues de insertaCliente()");
	}

	@AfterThrowing(pointcut = "execution(public * insertaClienteVIPConError())", throwing = "daoe")
	public void logException(Exception daoe) {
		System.out.println("sucedio un Error en el metodo insertaClienteVIPConError() por eso me acabo de ejecutar");
	}

}
