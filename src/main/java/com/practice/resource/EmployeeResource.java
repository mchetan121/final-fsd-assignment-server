package com.practice.resource;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.practice.model.Employee;
import com.practice.repository.EmployeeRepository;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee")
public class EmployeeResource {
	@Autowired
	EmployeeRepository employeerepo;

	@GetMapping("/msg")
	public String message() {
		return "----------------------";
	}

	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeerepo.findAll();
	}

	@PostMapping("/addEmployee")
	public List<Employee> addEmployee(@RequestBody Employee employee) {
		employeerepo.save(employee);
		return employeerepo.findAll();
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int id ){
		employeerepo.deleteById(id);
		return  employeerepo.findAll();
	}
	
	@PostMapping("/login")
	//@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	public int countUserByStatusAndNameNamedParams(
			@RequestBody Employee employee ) {
       System.out.println(employee.getName());
       System.out.println(employee.getPass());
		return employeerepo.countByNameAndPassword(employee.getName(), employee.getPass());
	}

}
