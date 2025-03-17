package com.mx.ApiRestFullExamenP1.service;

import java.io.Console;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestFullExamenP1.entity.Employees;
import com.mx.ApiRestFullExamenP1.entity.Genders;
import com.mx.ApiRestFullExamenP1.entity.Jobs;
import com.mx.ApiRestFullExamenP1.repository.EmployeesRepository;
import com.mx.ApiRestFullExamenP1.repository.GendersRepository;
import com.mx.ApiRestFullExamenP1.repository.JobsRepository;

@Service
public class EmployeesServiceImpl {
	@Autowired
	EmployeesRepository employeesRep;
	@Autowired
	GendersRepository gendersRep;
	@Autowired
	JobsRepository jobRep;
	
	@Transactional(readOnly = true)
	public List<Employees> Listar(){
		return employeesRep.findAll();
	}
	
	
	private Period CalcularEdad(Employees em){
		LocalDate anoNac = em.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate hoy = LocalDate.now();
		//Period eddad = Period.between(anoNac, hoy);		
		return Period.between(anoNac, hoy);
		
	}
	
	@Transactional
	public String RegistrarEmpleado(Employees em) {
		boolean nom = false;
		boolean sexAs = false;
		boolean pueAs = false;
		boolean app = false;
		boolean medad = false;
		String respuesta="";
		
		for(Genders g: gendersRep.findAll()) {
			if(g.getIdGender().equals(em.getGender().getIdGender())) {
				sexAs = true;
				break;
			}
		}
		for(Jobs j: jobRep.findAll()) {
			if(j.getIdJob().equals(em.getJob().getIdJob())) {
				pueAs = true;
				break;
			}
		}
		for(Employees e: employeesRep.findAll()) {
			if(e.getNombEmpleado().equalsIgnoreCase(em.getNombEmpleado())) {
				nom = true;
			}else if(e.getApellido().equalsIgnoreCase(em.getApellido())) {
				app = true;
				break;
			}
		}
		Period edad = this.CalcularEdad(em);
		int mayor = edad.getYears();
		Employees exId = employeesRep.findById(em.getIdEmp()).orElse(null);
		if(!sexAs || !pueAs || nom || app || (mayor < 18) || (exId!=null)) {
			respuesta = "No se puede realizar el registro";
		} else{
			respuesta = "Se registro un nuevo usuario";
			employeesRep.save(em);
		}
		
		/*if(!pueAs) {		
			respuesta = respuesta + "el puesto que ingreso no existe\n";
		}
		if(nom) {
			respuesta = respuesta + "el nombre que ingreso ya esta registrado\n";			
		}
		if(app) {
			respuesta = respuesta + "el apellido que ingreso ya esta registrado\n";
		}
		if(mayor < 18) {
			respuesta = respuesta + "La persona que desea registrar, aun no es mayor de edad, tiene "+edad.getYears();
		}else {
			medad = true;
		}*/
		
		
		return respuesta;
		
	}
}
