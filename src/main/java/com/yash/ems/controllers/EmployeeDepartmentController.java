package com.yash.ems.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Department;
import com.yash.ems.model.Employee;
import com.yash.ems.service.DepartmentService;
import com.yash.ems.service.EmployeeService;

@RestController
@RequestMapping("/emstask/api")
public class EmployeeDepartmentController {

	Logger logger = LoggerFactory.getLogger(EmployeeDepartmentController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	public EmployeeDepartmentController(EmployeeService employeeService,DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.departmentService=departmentService;
	}
	
	@PostMapping("/employee/department")
	public Employee savEmployeewithDepartment(@RequestBody Employee employee) {
		
	Employee saveemployee =	employeeService.saveEmployeewithDepartment(employee);
		return saveemployee;
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		
	List<Employee> emplist = employeeService.getEmployees();
		
		return new ResponseEntity<List<Employee>>( emplist,HttpStatus.OK);
	}
	
	@GetMapping("/findemp/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
		
		Employee employee = employeeService.findEmployeeById(id);
	
			return new  ResponseEntity<Employee>(employee,HttpStatus.OK) ;
	}
	

	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id){
		
		Employee updateEmployee = employeeService.get(id);
		
		employeeService.saveEmployeewithDepartment(employee);
		return  new ResponseEntity<>(updateEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") Long id){
		
		Department department = departmentService.findDepartmentById(id);
		
		return new ResponseEntity<Department>(department,HttpStatus.OK);
	}
	
	@GetMapping("/alldepartment")
	public ResponseEntity<List<Department>> getAllDepartment(){
		
		List<Department> departments= departmentService.getDepartments();
	
		logger.info("departments" +departments.toString());
		return new ResponseEntity<>(departments,HttpStatus.OK);
	}
}



