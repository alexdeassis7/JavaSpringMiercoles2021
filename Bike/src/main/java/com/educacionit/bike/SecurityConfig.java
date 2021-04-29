package com.educacionit.bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.educacionit.bike.services.UserService;

@Configuration //marcamos la clase para que spring sepa que es una clase de configuracion
@EnableWebSecurity  //habilitamos la seguridad Web De Spring- (Esta anotacion se podria omitir si se desea)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	//metodo que utilizaremos para codificar nuestras passwords
	@Bean //con esta anotacion defino una instancia en el core containner de Spring
	//para que luego en otra capa se pueda llamar y obtener la instancia a traves de un "@Autowired"
	//(en nuestro caso esa otra capa sera la capa test)
	public BCryptPasswordEncoder passwordEncoder() {	
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();	
		return bCryptPasswordEncoder;
	}
	
	@Autowired
	private UserService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryp;
	//sobreescribo metodo de WebSecurityConfigurerAdapter , es aqui donde estoy diciendo a 
	//spring lo mismo que pusimos en el application.properties 
	//spring.security.user.name=alex
	//spring.security.user.password=1234
	@Override 
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		//si quiero incluso puedo monstar mis users en memoria ,
		//pero para que tenerlo en memokria si puedo disponerlos en un base de datos?
		/*Ejemplo de dos user con distintos Roles en memoria
		 auth
		.inMemoryAuthentication()
		.withUser("alex")
		.password("1234")
		.roles("USER")
		.and()
		.withUser("UsuarioAdmin1")
		.password("claveAdmin")
		.roles("USER", "ADMIN");*///estos son los roles del user "UsuarioAdmin1"
		
		//al objeto auth mediante el metodo "userDetailsService()" le pasamos la 
		//implementacion que creamos de "userDetailsService" (clase UserService)
		auth.userDetailsService(userDetailService).passwordEncoder(bCryp);
		
		
	}
		
	//SobreEscribo metodo de "WebSecurityConfigurerAdapter" para decirle a Spring 
	//que todo Request (peticion) que ingresa debe estar autenticada de lo 
	//contratio no podra obtener el response que espera .
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	
	}
	
}
