package com.yash.ems.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

/*
 * Employee and Department Controller with POST ,PUT, GET functionality */

@RestController
@RequestMapping("/emstask/api")
public class EmployeeDepartmentController {

	Logger logger = LoggerFactory.getLogger(EmployeeDepartmentController.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	public EmployeeDepartmentController(EmployeeService employeeService, DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}

	@PostMapping("/saveemployee")
	public ResponseEntity<Employee> savEmployee(@RequestBody Employee employee) {

		Employee saveemployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveemployee, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> findAllEmployees() {

		List<Employee> emplist = employeeService.getEmployees();

		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
	}

	@GetMapping("/findemp/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {

		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/*
	 * @PutMapping("/update/{id}") public ResponseEntity<?>
	 * updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
	 * 
	 * Employee updateEmployee = employeeService.get(id);
	 * 
	 * employeeService.saveEmployeewithDepartment(employee); return new
	 * ResponseEntity<>(updateEmployee, HttpStatus.CREATED); }
	 */

	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") Long id) {

		Department department = departmentService.findDepartmentById(id);
		logger.info("department with Id :" + id + "is" + department.toString());
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	@GetMapping("/alldepartment")
	public ResponseEntity<List<Department>> getAllDepartment() {

		List<Department> departments = departmentService.getDepartments();

		logger.info("departments" + departments.toString());
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@PostMapping("/savedepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department newdepartment = departmentService.saveDepartment(department);

		return new ResponseEntity<>(newdepartment, HttpStatus.CREATED);
	}

	@PutMapping("/updatemp/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {

		Employee empfound = employeeService.findEmployeeById(id);
		if (empfound == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		try {
			empfound.setId(employee.getId());
			empfound.setFirstName(employee.getLastName());
			empfound.setLastName(employee.getLastName());
			empfound.setEmailId(employee.getEmailId());
			empfound.setPassword(employee.getPassword());
			empfound.setAddress(employee.getAddress());
			empfound.setCity(employee.getCity());
			empfound.setDateOfBirth(employee.getDateOfBirth());
			empfound.setPincode(employee.getPincode());
			empfound.setSalary(employee.getSalary());
			empfound.setUsername(employee.getUsername());
			empfound.setState(employee.getState());
			empfound.setRole(employee.getRole());
			empfound.setDepartment(empfound.getDepartment());
			return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			// TODO: handle exception
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatedept/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id,
			@RequestBody Department department) {
		Department deptfound = departmentService.findDepartmentById(id);

		if (deptfound == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		try {
			deptfound.setId(department.getId());
			deptfound.setDepartmentName(department.getDepartmentName());
			deptfound.setDescription(department.getDescription());
			//deptfound.setEmployees(department.getEmployees());

			return new ResponseEntity<Department>(departmentService.saveDepartment(department),
					HttpStatus.CREATED);
		} catch (DataAccessException e) {
			// TODO: handle exception
			return new ResponseEntity<Department>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}