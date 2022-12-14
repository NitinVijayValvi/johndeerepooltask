package com.yash.ems.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.exception.EmployeeNotFoundException;
import com.yash.ems.model.Employee;
import com.yash.ems.repository.EmployeeRepository;
import com.yash.ems.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

//	@Override
//	public List<Employee> getEmployeesByName(String employeeName) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findByEmployeeName(employeeName);
//	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
	
		return employeeRepository.findById(employeeId)
				.orElseThrow(()->new EmployeeNotFoundException("Employee With Id" +employeeId+ "Not FOUND"));
	
	}

//	@Override
//	public List<Employee> findByEmployeeName(String employeeName) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findByEmployeeName(employeeName);
//	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub

		employeeRepository.deleteEmployeeById(id);
		throw new EmployeeNotFoundException("Employee with " +id+ "Not Found");
	}

	@Override
	public Employee get(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

//	@Override
//	public List<Employee> findByEmployeeName(String employeeName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
}
