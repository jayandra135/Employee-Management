package com.emplogin.bean;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class EmpBean {
	protected int id;
	protected String name;
	protected String email;
	protected String country;
	protected int phoneno;
	protected String job;
	protected int salary;
	
	
	public EmpBean() {
	}
	public EmpBean(String email ,String country) {
		this.email = email;
		this.country = country;
	}
	
	
	public EmpBean(String name, String email, String country,int phoneno,String job,int salary) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.phoneno = phoneno;
		this.job=job;
	
		this.salary=salary;
	}

	public EmpBean(int id, String name, String email, String country,int phoneno, String job,int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.phoneno = phoneno;
		this.job=job;
	
		this.salary=salary;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	/*
	 * public int getHiredate() { return hiredate; } public void setHiredate(int
	 * hiredate) { this.hiredate = hiredate; }
	 */
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}