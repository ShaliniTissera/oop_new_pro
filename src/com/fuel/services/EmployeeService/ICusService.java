package com.fuel.services.EmployeeService;

import java.util.ArrayList;

import com.fuel.model.Employee.Customer;

public interface ICusService {
	public boolean addCusDetails(Customer emp);

	public Customer getCusDetailsByID(int empID);
	
	public ArrayList<Customer> getCusDetails();

	public boolean updateCusDetails(Customer emp);

	public boolean removeCusDetails(int empID);

	public String isEmailAlreadyInUse(String email);
}
