package com.ocs.service;
import com.ocs.model.*;
import com.ocs.exception.*;

import java.util.List;
import java.util.Optional;


public interface AdminService {
	public Department addDepartment(Department department);
	public void removeDepartment(int departmentId)throws DepartmentNotFoundException;
	public Department modifyDepartment(Department department);
	public Optional<Department> findDepartmentById(int departmentId)throws DepartmentNotFoundException;
	public Operator addOperator(Operator operator);
	public void removeOperator(int operatorId)throws OperatorNotFoundException;
	public Operator modifyOperator(Operator operator);
	public Optional<Operator> findOperatorById(int operatorId)throws OperatorNotFoundException;
	public List<Operator> findAllOperators();
}
