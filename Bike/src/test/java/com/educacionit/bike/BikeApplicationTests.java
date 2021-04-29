package com.educacionit.bike;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.educacionit.bike.models.Usuario;
import com.educacionit.bike.repositories.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BikeApplicationTests {

	@Autowired
	private UsuarioRepository repo;

	@Test
	public void crearUserTest() {
		Usuario us = new Usuario();
		us.setId(1);
		us.setNombre("MatiasUsuario");
		us.setClave("123456");

		Usuario retorno = repo.save(us);
		System.out.println(retorno);

		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
		
	}

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUserTestConPasswordEncriptada() {
		Usuario us = new Usuario();
		us.setId(2);
		us.setNombre("jose");
		// el encoder no genera la clave siempre con el mismo patron !, si ejecutamos
		// mas de una vez el
		// test podriamos ver que la misma clave se codifique de diferente manera
		// NO existe el proceso inverso al encoder (de eso se encarga internamente
		// BCryptPasswordEncoder )
		us.setClave(encoder.encode("1234encriptada"));
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
