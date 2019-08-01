package com.springboot.springData.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springData.entity.Employee;

public interface EmployeeSpringDataDAO extends JpaRepository<Employee, Integer> {	
	

}
