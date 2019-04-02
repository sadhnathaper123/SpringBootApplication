package com.arcbus.dao;

import java.util.List;

import com.arcbus.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	List<Employee> getAllEmployees();
}