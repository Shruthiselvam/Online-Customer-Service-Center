package com.ocs.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.dao.AdminDao;
import com.ocs.dao.DepartmentDao;
import com.ocs.dao.OperatorDao;
import com.ocs.exception.DepartmentNotFoundException;
import com.ocs.exception.OperatorNotFoundException;
import com.ocs.model.Department;
import com.ocs.model.Operator;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private DepartmentDao dnRepo;
	@Autowired
	private OperatorDao oprRepo;
	@Autowired
	private AdminDaoService addao;
	public AdminServiceImpl() {
		addao=new AdminDaoServiceImpl();
	}
	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
	return addao.addDepartment(department);
	}

	@Override
	public void removeDepartment(int departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
	// dnRepo.deleteById(departmentId);
	 addao.removeDepartment(departmentId);
	}

	@Override
	public Department modifyDepartment(Department department) {
		// TODO Auto-generated method stub
		//return dnRepo.save(department);
		Department dept=addao.modifyDepartment(department);
		return dept;
	}

	@Override
	public Optional<Department> findDepartmentById(int departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		//return dnRepo.findById(departmentId).get();
		Optional<Department> dept=addao.findDepartmentById(departmentId);
		return dept;
	}

	@Override
	public Operator addOperator(Operator operator) {
		// TODO Auto-generated method stub
		return addao.addOperator(operator);
	}

	@Override
	public void removeOperator(int operatorId) throws OperatorNotFoundException {
		// TODO Auto-generated method stub
		// oprRepo.deleteById(operatorId);
		addao.removeOperator(operatorId);
	}

	@Override
	public Operator modifyOperator(Operator operator) {
		// TODO Auto-generated method stub
		//return oprRepo.save(operator);
		Operator op=addao.modifyOperator(operator);
		return op;
	}

	@Override
	public Optional<Operator> findOperatorById(int operatorId) throws OperatorNotFoundException {
		// TODO Auto-generated method stub
		//return oprRepo.findById(operatorId).get();
		Optional<Operator> op=addao.findOperatorById(operatorId);
		
		return op;
	}

	@Override
	public List<Operator> findAllOperators() {
		// TODO Auto-generated method stub
		return addao.findAllOperators();
	}

	
}
