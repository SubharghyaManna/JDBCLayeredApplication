package com.practice.service;

import com.practice.bean.Employee;

public interface EmployeeService {
	public Employee[] showEmployee();
	public String addEmployee(Employee e);
	public Employee searchEmployee(int id);
	public String updateEmployee(Employee e);
	public String deleteEmployee(int id);
}