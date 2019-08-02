package com.springboot.springData.Rest.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springData.Rest.entity.Employee;



public interface EmployeeSpringDataDAO extends JpaRepository<Employee, Integer> {	
	

}
