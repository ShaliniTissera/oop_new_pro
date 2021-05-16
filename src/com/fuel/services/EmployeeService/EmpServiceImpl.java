package com.fuel.services.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fuel.Util.Employee.CommonConstant;
import com.fuel.Util.Employee.CusDBConnection;
import com.fuel.model.Employee.Employee;

public class EmpServiceImpl implements IEmpService {

	public static Connection connection;

	public static Statement statment;

	public static PreparedStatement prepared;

	@Override
	public boolean addEmpDetails(Employee emp) {

		try {
			connection = CusDBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(CommonConstant.insertEmpDetails);
			preparedStatement.setString(1, emp.getFname());
			preparedStatement.setString(2,emp.getLname());
			preparedStatement.setDouble(3, emp.getSalary());
			preparedStatement.setString(4,emp.getDesignation());
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
	public Employee getEmpDetailsByID(int empID) {
		try {
			connection = CusDBConnection.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(CommonConstant.getEmpDetailsByID);
			preparedStatement.setInt(1,empID);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			Employee emp = new Employee();
			if(rs.next()) {
				emp.setEmpID(rs.getInt(CommonConstant.CLM_EMPID));
				emp.setFname(rs.getString(CommonConstant.CLM_FNAME));
				emp.setLname(rs.getString(CommonConstant.CLM_LNAME));
				emp.setSalary(rs.getDouble(CommonConstant.CLM_SALARY));
				emp.setDesignation(rs.getString(CommonConstant.CLM_DESIGNATION));
				emp.setEmail(rs.getString(CommonConstant.CLM_EMAIL));
				}
			return emp;
			
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Employee> getEmpDetails() {
		try {

			ArrayList<Employee> employeeDetails = new ArrayList<Employee>();

			connection = CusDBConnection.getDBConnection();

			statment = connection.createStatement();

			ResultSet rs = statment.executeQuery(CommonConstant.getEmpDetails);

			while (rs.next()) {

				Employee emp= new Employee();

				emp.setEmpID(rs.getInt(CommonConstant.CLM_EMPID));
				emp.setFname(rs.getString(CommonConstant.CLM_FNAME));
				emp.setLname(rs.getString(CommonConstant.CLM_LNAME));
				emp.setSalary(rs.getDouble(CommonConstant.CLM_SALARY));
				emp.setDesignation(rs.getString(CommonConstant.CLM_DESIGNATION));
				emp.setEmail(rs.getString(CommonConstant.CLM_EMAIL));
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
	public boolean updateEmpDetails(Employee emp) {
		try {
			connection = CusDBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(CommonConstant.updateEmpDetails);
			preparedStatement.setString(1, emp.getFname());
			preparedStatement.setString(2, emp.getLname());
			preparedStatement.setDouble(3, emp.getSalary());
			preparedStatement.setString(4, emp.getDesignation());
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
	public boolean removeEmpDetails(int empID) {
		try {
			connection = CusDBConnection.getDBConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(CommonConstant.deleteEmpDetails);
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
		try {
			connection = CusDBConnection.getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(CommonConstant.getEmpDetailsByEmail);
			preparedStatement.setString(1,email);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return rs.getString(CommonConstant.CLM_EMAIL);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return null;
	}

}
