package com.mx.ApiRestFullExamenP1.entity;

import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


/*
CREATE TABLE JOBS(
ID NUMBER PRIMARY KEY NOT NULL,
NAME VARCHAR2(255) NOT NULL,
SALARY NUMBER(9,2) NOT NULL
);
*/
@Entity
@Table(name="JOBS")
@Data
public class Jobs {
	
	@Id
	@Column(name="ID")
	private Integer idJob;
	
	@Column(name="NAME")
	private String nombreJob;
	@Column(name="SALARY")
	private Float salario;
	
	//Cardinalidad un trabajo tiene muchos empleados
	
	@OneToMany(mappedBy="job", cascade = CascadeType.ALL)
	@JsonIgnore()
	private List<Employees> listaEm = new ArrayList<Employees>();
}
