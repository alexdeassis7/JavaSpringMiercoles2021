package ar.com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//clase que configura para que spring sepa que se trata del archivo 
//de conf y que vamos a usar AOP e indicarle 
//donde buscar las clases con los aspectos 

@Configuration//indicamos que esta clase es un archivo de conf
@EnableAspectJAutoProxy //habilitamos la configuracion de programacion orientada a aspecto 
@ComponentScan("ar.com.aop")//le indica a donde ir a buscar los aspectos , esto busca en el paquete raiz y los paquetes subyacentes 
public class Configuracion {
	//esta clase no necesita llevado codigo en su interior 
}
