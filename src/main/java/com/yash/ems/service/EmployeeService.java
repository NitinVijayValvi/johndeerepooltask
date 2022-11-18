package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.Employee;

public interface EmployeeService {

	
	List<Employee> getEmployees();

	//List<Employee> getEmployeesByName(String employeeName);

	Employee saveEmployeewithDepartment(Employee employee);

	Employee findEmployeeById(Long employeeId);

	//List<Employee> findByEmployeeName(String employeeName);

	void deleteEmployee(Long id);

	Employee get(Long id);
}
