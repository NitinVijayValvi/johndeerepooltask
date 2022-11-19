package com.yash.ems.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.model.Department;
import com.yash.ems.repository.DepartmentRepository;
import com.yash.ems.service.DepartmentService;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department findDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department saveDepartmentandEmployees(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

}
