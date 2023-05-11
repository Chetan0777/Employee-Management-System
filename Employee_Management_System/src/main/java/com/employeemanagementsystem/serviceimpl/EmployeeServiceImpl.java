package com.employeemanagementsystem.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.exception.EmployeeException;
import com.employeemanagementsystem.repository.EmployeeRepository;
import com.employeemanagementsystem.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository  employeerepository;
	
	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		
		List<Employee> employee = employeerepository.findAll();
		
		if(employee.size() == 0) throw new EmployeeException("Employee database is empty");
		
	    return employee;
	    
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) throws EmployeeException {
		
		return employeerepository.findById(employeeId).orElseThrow(()->new EmployeeException("Employee not found with id :- "+employeeId));
		
	}

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException {
		
		if(employee != null) {
			Employee create = employeerepository.save(employee);
			return create;
			
		}else {
			throw new EmployeeException("Please enter valid employee details");
			
		}
		
	}
	
	private Map<Integer, Employee> employees = new HashMap<>();
	
	@Override
	public Employee updateEmployee(int employeeId, Employee employee) throws EmployeeException {
		 
		Employee existingEmployee = employees.get(employeeId);
	        
		if (existingEmployee == null) {
	            throw new EmployeeException("Employee not found");
	    }
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setAddress(employee.getAddress());
        employees.put(employeeId, existingEmployee);
	        
        return existingEmployee;
	
	}
	

	@Override
	public Employee deleteEmployee(Integer employeeId) throws EmployeeException {
		
		Optional<Employee> opt = employeerepository.findById(employeeId);
		
		if(opt.isPresent()) {
			
			employeerepository.delete(opt.get());
			
			return opt.get();
		}else {
			
			throw new EmployeeException("Please enter valid employee Id");
		}
		
	}

}
