package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.practice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	int countByNameAndPassword(
			  @Param("name") String name, 
			  @Param("pass") String pass);

}
