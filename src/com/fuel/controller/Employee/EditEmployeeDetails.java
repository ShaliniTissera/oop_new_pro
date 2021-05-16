package com.fuel.controller.Employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuel.model.Employee.Customer;
import com.fuel.services.EmployeeService.CusServiceImpl;
import com.fuel.services.EmployeeService.ICusService;

@WebServlet("/EditEmployeeDetails")
public class EditEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ICusService customerService= new  CusServiceImpl();
		
		Customer customer;
		try {
			customer = customerService.getCusDetailsByID(Integer.parseInt(request.getParameter("empID")));
			
			request.setAttribute("customer", customer);
			System.out.println(customer);
			System.out.println(Integer.parseInt(request.getParameter("empID")));
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/edit_employee.jsp");
			rd1.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
