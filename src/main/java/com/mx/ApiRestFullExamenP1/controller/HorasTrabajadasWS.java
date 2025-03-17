package com.mx.ApiRestFullExamenP1.controller;


import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestFullExamenP1.entity.EmployeeWorkedHours;
import com.mx.ApiRestFullExamenP1.service.HorasTrabajadasServImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/Examen/ws/horasTrabajadas")
@CrossOrigin
public class HorasTrabajadasWS {

	@Autowired
	HorasTrabajadasServImpl horasTrabServImpl;
	
	//http://localhost:9000/Examen/ws/horasTrabajadas/ListarHoras
	@GetMapping(path="/ListarHoras")
	public List<EmployeeWorkedHours> ListarHoras(){
		return horasTrabServImpl.Listar();
	}
	
	//http://localhost:9000/Examen/ws/horasTrabajadas/registrarHoras
	@GetMapping(path="/registrarHoras")
	public ResponseEntity<String> RegistrarHoras(@RequestBody EmployeeWorkedHours ht){
		String res = horasTrabServImpl.RegHoras(ht);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
}
