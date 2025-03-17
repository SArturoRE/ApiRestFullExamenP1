package com.mx.ApiRestFullExamenP1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestFullExamenP1.entity.EmployeeWorkedHours;
import com.mx.ApiRestFullExamenP1.entity.Employees;
import com.mx.ApiRestFullExamenP1.repository.EmployeeWorkedHoursRepository;
import com.mx.ApiRestFullExamenP1.repository.EmployeesRepository;

@Service
public class HorasTrabajadasServImpl {
	
	@Autowired
	EmployeeWorkedHoursRepository horasTrabServImpl;
	@Autowired
	EmployeesRepository employeesRep;
	
	@Transactional(readOnly = true)
	public List<EmployeeWorkedHours> Listar(){
		return horasTrabServImpl.findAll();
	}
	
	@Transactional
	public String RegHoras(EmployeeWorkedHours ht) {
		boolean trab = false;
		String respuesta="";
		for(Employees e: employeesRep.findAll()) {
			if(e.getIdEmp().equals(ht.getEmpleado().getIdEmp())) {
				trab = true;
				break;
			}
		}
		EmployeeWorkedHours idHT = horasTrabServImpl.findById(ht.getIdHoras()).orElse(null);
		
		if(!trab) {
			respuesta = respuesta + "el id de trabajador no existe\n";
		}else if(idHT != null) {
			respuesta = respuesta + "no se puede realizar el registro, el id de horas ya existe";
		}else {
			horasTrabServImpl.save(ht);
			respuesta = respuesta + "El usuario se registro correctamente";
		}
		return respuesta;
	}
}

