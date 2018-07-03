package com.walmart.employee.service;

import java.util.Set;

import com.walmart.employee.model.Employee;

public interface EmployeeService {
    Set<Employee> findAll();
    java.util.List<Employee>  search(String name);
    
void Update(Employee emp);
    Employee findOne(int id);

    void save(Employee contact);

    void delete(int id);
}