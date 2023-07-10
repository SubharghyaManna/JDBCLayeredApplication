package com.practice.service;

import com.practice.bean.Employee;
import com.practice.dao.EmployeeDao;
import com.practice.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService{
	static EmployeeDao empDao = null;
	static {
		empDao = EmployeeDaoFactory.getEmployeeDao();
	}

	@Override
	public Employee[] showEmployee() {
		return empDao.show();
	}
	
	@Override
	public String addEmployee(Employee e) {
		String status = empDao.add(e);
		if(status == null)
			return "failure";
		return status;
	}

	@Override
	public Employee searchEmployee(int id) {
		return empDao.search(id);
	}

	@Override
	public String updateEmployee(Employee e) {
		String status = empDao.update(e);
		if(status == null)
			return "failure";
		return status;
	}

	@Override
	public String deleteEmployee(int id) {
		String status = empDao.delete(id);
		if(status == null)
			return "failure";
		return status;
	}
}