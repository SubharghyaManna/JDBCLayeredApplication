package com.practice.factory;

import com.practice.dao.EmployeeDao;
import com.practice.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	private static EmployeeDao empDao = null;
	static {
		empDao = new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao() {
		return empDao;
	}
}