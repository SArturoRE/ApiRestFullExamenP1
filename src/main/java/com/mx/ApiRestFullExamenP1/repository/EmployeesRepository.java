package com.mx.ApiRestFullExamenP1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiRestFullExamenP1.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
