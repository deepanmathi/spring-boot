package com.springboot.JPA.DAO;

import java.util.List;

import com.springboot.JPA.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmloyees();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void delete(int id);
	

}
