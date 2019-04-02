package com.arcbus.dao.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.arcbus.dao.EmployeeDao;
import com.arcbus.model.Employee;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeDaoImpl.class);
	
	@PostConstruct
	private void initialize() {
	}

	@Override
	public void insertEmployee(Employee emp) {
		objectToJson(emp);
		LOGGER.info("Employee Added:" + emp.toString());
	}

	private void objectToJson(Employee emp) {
		// Create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);

			// Convert object to JSON string
			String json = mapper.writeValueAsString(emp);
			System.out.println(json);

			// Save JSON string to file
			FileOutputStream fileOutputStream = new FileOutputStream("employee.json");
			mapper.writeValue(fileOutputStream, emp);
			fileOutputStream.close();

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Employee jsonToObject() {
		Employee employee = null;
		// Create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Read JSON file and convert to java object
			FileInputStream fileInputStream = new FileInputStream("employee.json");
			employee = mapper.readValue(fileInputStream, Employee.class);
			fileInputStream.close();

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> result = new ArrayList<Employee>();
		result.add(jsonToObject());
		
		LOGGER.info("Employee retrived:" + result.toString());
		
		return result;
	}

}