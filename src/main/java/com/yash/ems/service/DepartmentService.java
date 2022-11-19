package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.Department;

public interface DepartmentService {

	
	
	List<Department> getDepartments();

	Department findDepartmentById(Long id);

	Department saveDepartment(Department department);
}
