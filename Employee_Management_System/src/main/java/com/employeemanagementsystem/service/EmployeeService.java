package com.employeemanagementsystem.service;

import java.util.List;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.exception.EmployeeException;

public interface EmployeeService {

	public List<Employee> getAllEmployees() throws EmployeeException;
	
	public Employee getEmployeeById(Integer employeeId) throws EmployeeException;
	
	public Employee createEmployee(Employee employee) throws EmployeeException;
	
	public Employee updateEmployee(int employeeId, Employee employee) throws EmployeeException;
	
	public Employee deleteEmployee(Integer employeeId) throws EmployeeException;
	
	
}
