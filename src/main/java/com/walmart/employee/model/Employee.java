package com.walmart.employee.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;


public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	  private static final AtomicInteger count = new AtomicInteger(200); 
	
	private int eid;
	
	
	private String name;
	
	private String phoneNumber;
	
	
	private Double salary;
	

	private String officeLocation;
	
	
	private String sex;
	
	private Integer level;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Employee() {
		
       
    }

    public Employee( String name, Double salary) {
        super();
        this.eid = count.incrementAndGet();;
        this.name = name;
        this.salary = salary;
    }

	public Employee(int eid, String name, String phoneNumber, Double salary,
			String officeLocation, String sex, Integer level) {
		super();
		this.eid = eid;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.officeLocation = officeLocation;
		this.sex = sex;
		this.level = level;
	}
}
