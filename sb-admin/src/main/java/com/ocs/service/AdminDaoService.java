package com.ocs.service;

import java.util.List;
import java.util.Optional;

import com.ocs.model.Department;
import com.ocs.model.Operator;

public interface AdminDaoService {
	public Department addDepartment(Department department);
	public void removeDepartment(int departmentId);
	public Department modifyDepartment(Department department);
	public Optional<Department> findDepartmentById(int departmentId);
	public Operator addOperator(Operator operator);
	public void removeOperator(int operatorId);
	public Operator modifyOperator(Operator operator);
	public Optional<Operator> findOperatorById(int operatorId);
	public List<Operator> findAllOperators();

}
