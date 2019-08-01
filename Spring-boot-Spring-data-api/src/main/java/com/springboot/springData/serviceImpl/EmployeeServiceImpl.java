package com.springboot.springData.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.springData.DAO.EmployeeSpringDataDAO;
import com.springboot.springData.entity.Employee;
import com.springboot.springData.service.EmployeeService;

//service is to modify in future for many different dao layers -> customerDao, licenseDao
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeSpringDataDAO empSpringDataDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeSpringDataDAO theEmDao) {
		 this.empSpringDataDao=theEmDao;
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmloyees() {
		
		return empSpringDataDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalFindById = empSpringDataDao.findById(id);
		Employee emp=null;
		if(optionalFindById.isPresent())
			emp=optionalFindById.get();
		return emp;
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		empSpringDataDao.save(emp);
	}

	@Override
	@Transactional
	public void delete(int id) {
		empSpringDataDao.deleteById(id);

	}

}
