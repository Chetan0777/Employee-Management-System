package com.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.exception.EmployeeException;
import com.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeException{
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws EmployeeException{
		
		Employee employee = employeeService.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createBook (@RequestBody Employee employee) throws EmployeeException{
		
		Employee emp = employeeService.createEmployee(employee);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) throws EmployeeException{
		
		Employee update = employeeService.updateEmployee(id, employee);
		
		return new ResponseEntity<Employee>(update,HttpStatus.OK);
		
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteBookById( @PathVariable Integer id) throws EmployeeException{
		
		Employee delete = employeeService.deleteEmployee(id);
		
		return new ResponseEntity<Employee>(delete,HttpStatus.OK);
	
	}
	

	
	
}
