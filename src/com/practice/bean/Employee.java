package com.practice.bean;

public class Employee {
	int eid;
	String ename;
	String job;
	public Employee(int eid, String ename, String job) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.job = job;
	}
	public int getEid() {
		return eid;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
}