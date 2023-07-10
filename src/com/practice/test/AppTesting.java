package com.practice.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.practice.bean.Employee;
import com.practice.factory.EmployeeServiceFactory;
import com.practice.service.EmployeeService;

public class AppTesting {
	private static EmployeeService empService = null;
	static {
		empService = EmployeeServiceFactory.getEmployeeService();
	}
	public static void main(String[] args) {
		BufferedReader br = null;
		int choice = 0;
		int id = 0;
		Employee[] emp = null;
		Employee e = null;
		String name = null;
		String job = null;
		String status = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Welcome to JDBC with MySQL\n");
		try {
			while(true) {
				System.out.println("1. Show all Employee Details");
				System.out.println("2. Add Employee Details");
				System.out.println("3. Search Employee Details");
				System.out.println("4. Update Employee Details");
				System.out.println("5. Delete Employee Details");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				
				choice = Integer.parseInt(br.readLine());
				
				switch(choice) {
				case 1:
					System.out.println("=== Display Section ===");
					emp = empService.showEmployee();
					if(emp == null)
						System.out.println("No Employee Details Found\n");
					else {
						System.out.println("Available Employees are:");
						System.out.println("Id\tName\tJob");
						for(Employee e1 : emp) {
							System.out.println(e1.getEid()+"\t"+e1.getEname()+"\t"+e1.getJob());
						}
						System.out.println();
					}
					break;
				case 2:
					System.out.println("=== Add Data Section ===");
					System.out.print("Enter Id: ");
					id = Integer.parseInt(br.readLine());
					System.out.print("Enter name: ");
					name = br.readLine();
					System.out.print("Enter job: ");
					job = br.readLine();
					
					status = empService.addEmployee(new Employee(id, name, job));
					if(status.equalsIgnoreCase("success"))
						System.out.println("Successfully Added Data\n");
					else
						System.out.println("failed to Add !!!\n");
					break;
				case 3:
					System.out.println("=== Search Data Section ===");
					System.out.print("Enter Id: ");
					id = Integer.parseInt(br.readLine());
					e = empService.searchEmployee(id);
					if(e==null)
						System.out.println("No Employee Details Found\n");
					else
						System.out.println("Employee Name: "+e.getEname()+"\tEmployee Job: "+e.getJob()+"\n");
					break;
				case 4:
					System.out.println("=== Update Data Section ===");
					System.out.print("Enter Id: ");
					id = Integer.parseInt(br.readLine());
					System.out.print("Enter new name: ");
					name = br.readLine();
					System.out.print("Enter new job: ");
					job = br.readLine();
					
					status = empService.updateEmployee(new Employee(id, name, job));
					if(status.equalsIgnoreCase("success"))
						System.out.println("Successfully Updated Data\n");
					else
						System.out.println("failed to Update !!!\n");
					break;
				case 5:
					System.out.println("=== Delete Data Section ===");
					System.out.print("Enter Id: ");
					id = Integer.parseInt(br.readLine());
					status = empService.deleteEmployee(id);
					if(status.equalsIgnoreCase("success"))
						System.out.println("Successfully Deleted Data\n");
					else
						System.out.println("failed to Delete !!!\n");
					break;
				case 6:
					System.out.println("+++ Thank you for trying this small software +++");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Choice!!! Try again...\n");
				}
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}