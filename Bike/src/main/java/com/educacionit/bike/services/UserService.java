package com.educacionit.bike.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.educacionit.bike.models.Usuario;
import com.educacionit.bike.repositories.UsuarioRepository;

@Service
//en este servicio vamos a indicar a spring de donde debe obtener los datos de los usuario , sus
//roles ...etc
public class UserService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		//buscamos un usuario por su nombre
		Usuario us = repo.findByNombre(username);
		
		//spring posee la interface GrantedAuthority para definir los roles de nuestra app
		//esto aca lo vamos a Harcodear pero podria venir de la base de datos
		List<GrantedAuthority> roles = new ArrayList<>();
		//agrego un rol harcodeado a la lista de roles 
		roles.add( new SimpleGrantedAuthority("ADMIN"));
		
		
		//el metodo debe retornar un objeto UserDetail entonces creamos 
		//un objeto de este tipo y le pasamos por parametro 
		//el usuario, su clave y sus roles 
		UserDetails userDet = new User(us.getNombre() , us.getClave() , roles);
		return userDet;
		
	}
}
