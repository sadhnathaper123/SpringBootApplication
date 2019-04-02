package com.arcbus.service;

import java.util.List;

import com.arcbus.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	List<Employee> getAllEmployees();
}