package com.practice.dao;

import com.practice.bean.Employee;

public interface EmployeeDao {
	public Employee[] show();
	public String add(Employee e);
	public Employee search(int id);
	public String update(Employee e);
	public String delete(int id);
}