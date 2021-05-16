package com.fuel.controller.Employee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuel.model.Employee.Customer;

import com.fuel.services.EmployeeService.CusServiceImpl;

import com.fuel.services.EmployeeService.ICusService;

import com.fuel.Util.Employee.EmailInUse;
/**
 * Servlet implementation class AddCustomerDetailsServelt
 */
@WebServlet("/AddCustomerDetailsServelt")
public class AddCustomerDetailsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		Customer emp = new Customer();

		emp.setFname(request.getParameter("fname"));
		emp.setLname(request.getParameter("lname"));
		emp.setAddress(request.getParameter("address"));
		emp.setPhone(Integer.parseInt(request.getParameter("phone"))); 
		emp.setEmail(request.getParameter("email"));

		ICusService empService = new CusServiceImpl();
		
		if (empService.isEmailAlreadyInUse(emp.getEmail()) != null) {	
			throw new EmailInUse("Email is taken");
		}

		if (empService.addCusDetails(emp)) {
			ArrayList<Customer> customerList = empService.getCusDetails();	
			
			request.setAttribute("success1", "CustomerAdd");
			request.setAttribute("customerList", customerList);
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/list_employee.jsp");
			rd1.forward(request, response);
			response.sendRedirect("/WEB-INF/views/list_employee.jsp");
			return;

		} else {

			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/add_employee.jsp");
			rd1.forward(request, response);
		}

		}catch (EmailInUse e) {
			request.setAttribute("error1", "Email In use");
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/add_employee.jsp");
			rd1.forward(request, response);
			response.sendRedirect("/WEB-INF/views/add_employee.jsp");
			return;
		}catch(Exception e) {
			request.setAttribute("error1", "Something Went Wrong");
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/add_employee.jsp");
			rd1.forward(request, response);
			response.sendRedirect("/WEB-INF/views/add_employee.jsp");
			return;
		}
	}

}
