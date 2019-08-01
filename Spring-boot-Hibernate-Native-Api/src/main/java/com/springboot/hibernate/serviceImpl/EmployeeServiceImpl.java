package com.springboot.hibernate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hibernate.DAO.EmployeeDAO;
import com.springboot.hibernate.entity.Employee;
import com.springboot.hibernate.service.EmployeeService;

//service is to modify in future for many different dao layers -> customerDao, licenseDao
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmDao) {
		 this.empDao=theEmDao;
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmloyees() {
		
		return empDao.getAllEmloyees();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return empDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		empDao.save(emp);
	}

	@Override
	@Transactional
	public void delete(int id) {
		empDao.delete(id);

	}

}
