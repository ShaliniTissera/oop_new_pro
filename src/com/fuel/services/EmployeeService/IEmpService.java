package com.fuel.services.EmployeeService;

import java.util.ArrayList; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.fuel.model.Employee.Employee;


public interface IEmpService {

	public boolean addEmpDetails(Employee emp);

	public Employee getEmpDetailsByID(int empID);
	
	public ArrayList<Employee> getEmpDetails();

	public boolean updateEmpDetails(Employee emp);

	public boolean removeEmpDetails(int empID);

	public String isEmailAlreadyInUse(String email);
}
