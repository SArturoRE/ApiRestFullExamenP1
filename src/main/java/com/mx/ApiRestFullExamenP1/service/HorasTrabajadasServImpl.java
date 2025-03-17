package com.mx.ApiRestFullExamenP1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestFullExamenP1.entity.EmployeeWorkedHours;
import com.mx.ApiRestFullExamenP1.repository.EmployeeWorkedHoursRepository;

@Service
public class HorasTrabajadasServImpl {
	
	@Autowired
	EmployeeWorkedHoursRepository horasTrabServImpl;
	
	@Transactional(readOnly = true)
	public List<EmployeeWorkedHours> Listar(){
		return horasTrabServImpl.findAll();
	}
}

