package com.practice.factory;

import com.practice.service.EmployeeService;
import com.practice.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService empService;
	static {
		empService = new EmployeeServiceImpl();
	}
	public static EmployeeService getEmployeeService() {
		return empService;
	}
}