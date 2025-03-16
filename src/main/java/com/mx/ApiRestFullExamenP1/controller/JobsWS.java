package com.mx.ApiRestFullExamenP1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestFullExamenP1.entity.Jobs;
import com.mx.ApiRestFullExamenP1.service.JobServiceImpl;
@RestController
@RequestMapping(path="Examen/ws")
@CrossOrigin
public class JobsWS {
	@Autowired
	JobServiceImpl jobServiceImplement;
	
	
	//http://localhost:9000/Examen/ws/ListarJobs
	@GetMapping(path="/ListarJobs")
	public List<Jobs> ListarDepartamentos(){
		return jobServiceImplement.ListarJobs();
	}

}
