package com.fuel.services.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.fuel.Util.Employee.CommonCustConstant;
import com.fuel.Util.Employee.CusDBConnection;
import com.fuel.model.Employee.Customer;

public class CusServiceImpl implements ICusService {

	public static Connection connection;

	public static Statement statment;

	public static PreparedStatement prepared;
	
	
	@Override
	public boolean addCusDetails(Customer emp) {
		// TODO Auto-generated method stub
		try {
			connection = CusDBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(CommonCustConstant.insertCustomerDetails);
			preparedStatement.setString(1, emp.getFname());
			preparedStatement.setString(2,emp.getLname());
			preparedStatement.setInt(3, emp.getPhone());
			preparedStatement.setString(4,emp.getAddress());
			preparedStatement.setString(5,emp.getEmail());
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			
            return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return false;
	}

	@Override
	public Customer getCusDetailsByID(int empID) {
		// TODO Auto-generated method stub
		
		try {
			connection = CusDBConnection.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(CommonCustConstant.getCustomerDetailsByID);
			preparedStatement.setInt(1,empID);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			Customer emp = new Customer();
			if(rs.next()) {
				emp.setEmpID(rs.getInt(CommonCustConstant.CLM_EMPID));
				emp.setFname(rs.getString(CommonCustConstant.CLM_FNAME));
				emp.setLname(rs.getString(CommonCustConstant.CLM_LNAME));
				emp.setPhone(rs.getInt(CommonCustConstant.CLM_PHONE));
				emp.setAddress(rs.getString(CommonCustConstant.CLM_ADDRESS));
				emp.setEmail(rs.getString(CommonCustConstant.CLM_EMAIL));
				}
			return emp;
			
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Customer> getCusDetails() {
		// TODO Auto-generated method stub
		try {

			ArrayList<Customer> employeeDetails = new ArrayList<Customer>();

			connection = CusDBConnection.getDBConnection();

			statment = connection.createStatement();

			ResultSet rs = statment.executeQuery(CommonCustConstant.getCustomerDetails);

			while (rs.next()) {

				Customer emp= new Customer();

				emp.setEmpID(rs.getInt(CommonCustConstant.CLM_EMPID));
				emp.setFname(rs.getString(CommonCustConstant.CLM_FNAME));
				emp.setLname(rs.getString(CommonCustConstant.CLM_LNAME));
				emp.setPhone(rs.getInt(CommonCustConstant.CLM_PHONE));
				emp.setAddress(rs.getString(CommonCustConstant.CLM_ADDRESS));
				emp.setEmail(rs.getString(CommonCustConstant.CLM_EMAIL));
				employeeDetails.add(emp);
			}

			return employeeDetails;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateCusDetails(Customer emp) {
		// TODO Auto-generated method stub
		try {
			connection = CusDBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(CommonCustConstant.updateCustomerDetails);
			preparedStatement.setString(1, emp.getFname());
			preparedStatement.setString(2, emp.getLname());
			preparedStatement.setInt(3, emp.getPhone());
			preparedStatement.setString(4, emp.getAddress());
			preparedStatement.setString(5, emp.getEmail());
			preparedStatement.setInt(6, emp.getEmpID());
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeCusDetails(int empID) {
		// TODO Auto-generated method stub
		try {
			connection = CusDBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(CommonCustConstant.deleteCustomerDetails);
			preparedStatement.setInt(1, empID);
			
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String isEmailAlreadyInUse(String email) {
		// TODO Auto-generated method stub
		try {
			connection = CusDBConnection.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(CommonCustConstant.getCustomerDetailsByEmail);
			preparedStatement.setString(1,email);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return rs.getString(CommonCustConstant.CLM_EMAIL);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
