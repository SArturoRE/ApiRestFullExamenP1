package com.mx.ApiRestFullExamenP1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/*
CREATE TABLE EMPLOYEE_WORKED_HOURS(
ID NUMBER PRIMARY KEY NOT NULL,
EMPLOYEE_ID NUMBER NOT NULL,
FOREIGN KEY(EMPLOYEE_ID) REFERENCES EMPLOYEES(ID),
WORKED_HOURS NUMBER,
WORKED_DATE  DATE
);
 * */

@Entity
@Table(name="EMPLOYEE_WORKED_HOURS")
@Data
public class EmployeeWorkedHours {
	@Id
	@Column(name="ID")
	private Integer idHoras;
	@Column(name="WORKED_HOURS")
	private Integer horasTrab;
	@Column(name = "WORKED_DATE")
	private Date fechaSemana;
	
	
	//cardinalidad muchos a uno
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID")
	private Employees empleado;
	
}
