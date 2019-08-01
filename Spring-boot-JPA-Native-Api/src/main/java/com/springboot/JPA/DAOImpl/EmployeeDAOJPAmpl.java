package com.springboot.JPA.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.JPA.DAO.EmployeeDAO;
import com.springboot.JPA.entity.Employee;

@Repository
public class EmployeeDAOJPAmpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAmpl(EntityManager theentityManager) //constructor injection //entity Manager is created automatically 
	                                                                  //by spring boot simply you need to inject
	{
		this.entityManager=theentityManager;
	}
	
	@Override
	@Transactional //start end transaction automatic by spring boot
	public List<Employee> getAllEmloyees() {
		
		
		Query qry=entityManager.createQuery("from Employee",Employee.class);
		
		List<Employee> employees=qry.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		
		Employee emp=entityManager.find(Employee.class, id);
		
		return emp;
	}

	@Override
	public void save(Employee emp) {
		Employee dbEmp=entityManager.merge(emp); //if id ==0 then save else update
		
		emp.setId(dbEmp.getId()); //this is used rest api to return generated ID
	}

	@Override
	public void delete(int id) {
		Query qry=entityManager.createQuery("delete from Employee where id=:empId");
		qry.setParameter("empId", id);
		qry.executeUpdate();
		
	}

}
