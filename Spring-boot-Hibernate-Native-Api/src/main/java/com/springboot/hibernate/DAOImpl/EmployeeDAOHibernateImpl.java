package com.springboot.hibernate.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hibernate.DAO.EmployeeDAO;
import com.springboot.hibernate.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theentityManager) //constructor injection //entity Manager is created automatically 
	                                                                  //by spring boot simply you need to inject
	{
		this.entityManager=theentityManager;
	}
	
	@Override
	@Transactional //start end transaction automatic by spring boot
	public List<Employee> getAllEmloyees() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Employee> qry=currentSession.createQuery("from Employee",Employee.class);
		
		List<Employee> employees=qry.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Employee emp=currentSession.get(Employee.class, id);
		
		return emp;
	}

	@Override
	public void save(Employee emp) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
		
	}

	@Override
	public void delete(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query qry=currentSession.createQuery("delete from Employee where id=:empId");
		qry.setParameter("empId", id);
		qry.executeUpdate();
		
	}

}
