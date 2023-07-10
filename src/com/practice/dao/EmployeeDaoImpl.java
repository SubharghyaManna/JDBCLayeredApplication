package com.practice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.practice.bean.Employee;
import com.practice.factory.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao{
	private static Connection con = null;
	static {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public Employee[] show() {
		List<Employee> al = null;
		Employee[] emps = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			if(con!=null)
				st = con.createStatement();
			
			if(st!=null)
				rs = st.executeQuery("SELECT * FROM emp");
			
			al = new ArrayList<>();
			while(rs.next()) {
				al.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
			emps = new Employee[al.size()];
			al.toArray(emps);
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public String add(Employee emp) {
		Statement st = null;
		int count = 0;
		try {
			if(con!=null)
				st = con.createStatement();
			
			if(st!=null)
				count = st.executeUpdate("INSERT INTO EMP VALUES("+emp.getEid()+", '"+emp.getEname()+"', '"+emp.getJob()+"')");
			
			if(count!=0)
				return "success";
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee search(int id) {
		Employee emp = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			if(con!=null)
				st = con.createStatement();
			
			if(st!=null)
				rs = st.executeQuery("SELECT * FROM emp WHERE eid="+id);
			
			if(rs.next()) {
				emp = new Employee(id, rs.getString(2), rs.getString(3));
			}

		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String update(Employee emp) {
		Statement st = null;
		int count = 0;
		try {
			if(con!=null)
				st = con.createStatement();
			
			if(st!=null)
				count = st.executeUpdate("UPDATE EMP SET ENAME='"+emp.getEname()+"', JOB='"+emp.getJob()+"' WHERE EID = "+emp.getEid());
			
			if(count!=0)
				return "success";
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(int id) {
		Statement st = null;
		int count = 0;
		try {
			if(con!=null)
				st = con.createStatement();
			
			if(st!=null)
				count = st.executeUpdate("DELETE FROM EMP WHERE eid="+id);
			
			if(count!=0)
				return "success";
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
