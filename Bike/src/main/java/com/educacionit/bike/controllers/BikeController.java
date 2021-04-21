package com.educacionit.bike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.bike.models.Bike;
import com.educacionit.bike.repositories.BikeRepository;

@RestController
//mediante esta anotacion sera suficiente para que spring la publique como un Spring Rest Service
//URI BASE
@RequestMapping("api/v1/bikes") //localhost:8888/api/v1/bikes
public class BikeController {
	@Autowired
	private BikeRepository bk;
	
//	@GetMapping
//	public String holaMundo () {
//		return "Hola mundo soy una Api RESt de Spring Boot";
//	}
//	
	@GetMapping
	public List<Bike> lista () {
		return bk.findAll();
	}
	
	

}
