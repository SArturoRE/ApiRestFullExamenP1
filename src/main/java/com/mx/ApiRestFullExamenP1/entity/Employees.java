package com.mx.ApiRestFullExamenP1.entity;


import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;//java.sql.Date;java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Data;

/*
CREATE TABLE EMPLOYEES(
ID NUMBER PRIMARY KEY NOT NULL,
NAME VARCHAR2(255) NOT NULL,
GENDER_ID NUMBER NOT NULL,
FOREIGN KEY(GENDER_ID) REFERENCES GENDERS(ID),
JOB_ID NUMBER NOT NULL,
FOREIGN KEY(JOB_ID) REFERENCES JOBS(ID),
LAST_NAME VARCHAR2(255) NOT NULL,
BIRTHDATE DATE NOT NULL
); 
 * */

@Entity
@Table(name="EMPLOYEES")
@Data
public class Employees {
	@Id
	@Column(name="ID")
	private Integer idEmp;
	
	@Column(name="NAME")
	private String nombEmpleado;
	@Column(name="LAST_NAME")
	private String apellido;
	@Column(name="BIRTHDATE")
	private Date fechaNacimiento;
	
	
	
	
	//Cardinalidad muchos a uno, muchos empleados pertenecen a un genero
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="GENDER_ID")
	private Genders gender;
	//Cardinalidad muchos a uno, muchos empleados pertenecen a un departamento
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="JOB_ID")
	private Jobs job;
	//Cardinalidad uno a muchos, un empleado puede tener muchas horas de trabajo
	@OneToMany(mappedBy="empleado", cascade = CascadeType.ALL)
	@JsonIgnore()
	private List<EmployeeWorkedHours> listaEm = new ArrayList<EmployeeWorkedHours>();
	
	
}
