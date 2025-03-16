package com.mx.ApiRestFullExamenP1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestFullExamenP1.entity.Jobs;
import com.mx.ApiRestFullExamenP1.repository.JobsRepository;

@Service
public class JobServiceImpl {

	@Autowired
	JobsRepository jobsRepository;
	
	@Transactional(readOnly = true)
	public List<Jobs> ListarJobs(){
		return jobsRepository.findAll();
	}
}
