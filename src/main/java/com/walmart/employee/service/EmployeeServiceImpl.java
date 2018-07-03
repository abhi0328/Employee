package com.walmart.employee.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.walmart.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	  private static final AtomicInteger count = new AtomicInteger(0); 
	
	static Set<Employee> employees = new HashSet<Employee>();
	static {
		Employee e1 = new Employee(101, "Jay", "(618)233-6381", 5000.00, " 1414 Ross Street", "MALE", 2);
		Employee e2 = new Employee(102, "Abi", "(618)233-6381", 5000.00, " 1414 Ross Street", "MALE", 1);
		Employee e3 = new Employee(103, "Chris", "(618)233-6381", 5000.00, " 1414 Ross Street", "MALE", 3);
		Employee e4 = new Employee(104, "Vasu", "(618)233-6381", 5000.00, " 1414 Ross Street", "MALE", 1);
		Employee e5 = new Employee(105, "surya", "000000000", 5000.00, " 1414 Ross Street", "MALE", 4);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
	}

	public Set<Employee> findAll() {
		return employees;
	}

	public Employee findOne(int eid) {
		Employee e = new Employee();
		for (Employee employee : employees) {

			if (employee.getEid() == eid) {
				e= employee;
				break;
			}
		}
		return e;
	}

	public void save(Employee contact) {/*
		
		
		boolean res= true;
	
		for (Employee employee : employees) {

			if (employee.getEid() == contact.getEid()) {
			System.out.println(contact.getEid()+" contact");
			System.out.println(employee.getEid()+" employee");

				employees.remove(employee);
				res=false;
				break;
			}
		}
		if (!res) {
			System.out.println("ress ");

			employees.add(contact);
		}
	*/
		employees.add(contact);
	}

	public void delete(int eid) {

		employees.remove(new EmployeeServiceImpl().findOne(eid));
	}

	public java.util.List<Employee> search(String name) {

		java.util.List<Employee> list = new ArrayList<Employee>();
		Employee e = new Employee();
		for (Employee employee : employees) {
			if (name.toLowerCase().equals(employee.getName().toLowerCase()))
				list.add(employee);

		}
		return list;

	}

	
	public void Update(Employee employee) {
		int id = employee.getEid();
		Employee emp = new Employee();
		for (Employee e : employees) {
			if (e.getEid() == id)
				emp = e;
		}
		emp.setName(employee.getName());
		emp.setPhoneNumber(employee.getPhoneNumber());
		
		
	}
}
