package com.educacionit.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.bike.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//modificamos y agregamos una consulta por columna ("nombre") para que luego podamos 
	//utilizar el repository y buscar un registro por su nombre al momemto que se 
	//realice un login 
	
	//finBy${nombreDeLaColumna} el findBy es como una palabra reservada de spring donde le indicamos por que 
	//columna queremos hacer el where
	Usuario findByNombre(String nombre); //esta linea es como si realizaramos un : "select * from  usuario where nombre = "${algo}";
}
