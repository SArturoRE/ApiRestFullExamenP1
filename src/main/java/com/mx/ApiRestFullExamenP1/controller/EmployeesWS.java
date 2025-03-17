package com.mx.ApiRestFullExamenP1.controller;

import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestFullExamenP1.entity.Employees;
import com.mx.ApiRestFullExamenP1.service.EmployeesServiceImpl;

@RestController
@RequestMapping(path="/Examen/ws/empleados")
@CrossOrigin
public class EmployeesWS {
	
	@Autowired
	EmployeesServiceImpl employeesServImpl;
	
	//http://localhost:9000/Examen/ws/empleados/Listar
	@GetMapping(path="/Listar")
	public List<Employees> ListarTodos(){
		return employeesServImpl.Listar();
	}
	
	//http://localhost:9000/Examen/ws/empleados/pruebaFecha
	@GetMapping(path="/pruebaFecha")
	public ResponseEntity<String> ProbandoLaEdad(@RequestBody Employees em){
		//Period edad = employeesServImpl.CalcularEdad(em);
		return new ResponseEntity<String>("Edad: ",HttpStatus.OK);
	}
	
	//http://localhost:9000/Examen/ws/empleados/registrarEmpleado
	@GetMapping("/registrarEmpleado")
	public ResponseEntity<String> RegistrandoEmpleado(@RequestBody Employees em){
		String seEncontro = employeesServImpl.RegistrarEmpleado(em);
		
		return new ResponseEntity<String>(seEncontro,HttpStatus.OK);
	}
}
