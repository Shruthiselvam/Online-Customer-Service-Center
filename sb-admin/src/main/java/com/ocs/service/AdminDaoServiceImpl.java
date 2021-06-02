package com.ocs.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.dao.AdminDao;
import com.ocs.dao.DepartmentDao;
import com.ocs.dao.OperatorDao;
import com.ocs.model.Admin;
import com.ocs.model.Department;
import com.ocs.model.Operator;

@Service
public class AdminDaoServiceImpl implements AdminDaoService{
	
	
	@Autowired
	private DepartmentDao dnRepo;
	@Autowired
	private OperatorDao oprRepo;
	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		 return dnRepo.save(department);
		/*if( dept != null)
			return true;
		else
			return false;*/
	}
	@Override
	public void removeDepartment(int departmentId) {
		// TODO Auto-generated method stub
		dnRepo.deleteById(departmentId);
		// return true;
	}
	@Override
	public Department modifyDepartment(Department department) {
		// TODO Auto-generated method stub
		return dnRepo.save(department);
	}
	@Override
	public Optional<Department> findDepartmentById(int departmentId) {
		// TODO Auto-generated method stub
		return dnRepo.findById(departmentId);
	}
	@Override
	public Operator addOperator(Operator operator) {
		// TODO Auto-generated method stub
	return oprRepo.save(operator);
		/*if(opt != null) 
			return true;
		else
			return false;*/
	}
	@Override
	public void removeOperator(int operatorId) {
		// TODO Auto-generated method stub
		 oprRepo.deleteById(operatorId);
			//return true;
	}
	@Override
	public Operator modifyOperator(Operator operator) {
		// TODO Auto-generated method stub
		return oprRepo.save(operator);
	}
	@Override
	public Optional<Operator> findOperatorById(int operatorId) {
		// TODO Auto-generated method stub
		//System.out.println("operator"+oprRepo.findById(operatorId).get());
		return oprRepo.findById(operatorId);
	}
	@Override
	public List<Operator> findAllOperators() {
		// TODO Auto-generated method stub
		return oprRepo.findAll();
	}
	
 }
