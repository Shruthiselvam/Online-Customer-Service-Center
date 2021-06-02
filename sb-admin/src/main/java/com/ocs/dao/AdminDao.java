package com.ocs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocs.model.Admin;
//import com.ocs.model.Department;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
	

 }
