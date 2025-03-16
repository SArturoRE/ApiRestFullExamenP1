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
CREATE TABLE GENDERS(
ID NUMBER PRIMARY KEY NOT NULL,
NAME VARCHAR2(255) NOT NULL
); 
 */
@Entity
@Table(name="GENDERS")
@Data
public class Genders {
	
	@Id
	@Column(name="ID")
	private Integer idGender;
	@Column(name="NAME")
	private String nombreG;
	
	//Cardinalidad un genero tiene muchos empleados
	
		@OneToMany(mappedBy="gender", cascade = CascadeType.ALL)
		@JsonIgnore()
		private List<Employees> listaEm = new ArrayList<Employees>();
}
