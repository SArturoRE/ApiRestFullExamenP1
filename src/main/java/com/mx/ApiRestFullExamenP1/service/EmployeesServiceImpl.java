package com.mx.ApiRestFullExamenP1.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestFullExamenP1.entity.Employees;
import com.mx.ApiRestFullExamenP1.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl {
	@Autowired
	EmployeesRepository employeesRep;
	
	@Transactional(readOnly = true)
	public List<Employees> Listar(){
		return employeesRep.findAll();
	}
	
	
	public Period CalcularEdad(Employees em){
		LocalDate anoNac = em.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate hoy = LocalDate.now();
		//Period eddad = Period.between(anoNac, hoy);		
		return Period.between(anoNac, hoy);
		
	}
	
}
