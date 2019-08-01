package com.springboot.springData.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springData.DAO.EmployeeSpringDataDAO;
import com.springboot.springData.entity.Employee;
import com.springboot.springData.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpoyeeController {
	
	private EmployeeService empServ;
	
	public EmpoyeeController(EmployeeService theEmpServ)
	{
		this.empServ=theEmpServ;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmloyees()
	{
		return empServ.getAllEmloyees();
	}
	
	@GetMapping(path="/employees/{empId}")
	public Employee getFindEmploy(@PathVariable int empId)
	{
		return empServ.findById(empId);
	}
	
	@PostMapping(path="/employees")
	public Employee save(@RequestBody Employee emp)
	{
		emp.setId(0);
		empServ.save(emp);
		
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp)
	{
	  empServ.save(emp);
	  return emp;
	}
	
	@DeleteMapping(path="/employees/{empId}")
	public String deletEmp(@PathVariable int empId)
	{
		 empServ.delete(empId);
		 
		 return "deleted- " +empId;
	}
	
	
	
	

}
