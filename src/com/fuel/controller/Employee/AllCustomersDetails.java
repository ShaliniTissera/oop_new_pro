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

/**
 * Servlet implementation class AllCustomersDetails
 */
@WebServlet("/AllCustomersDetails")
public class AllCustomersDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ICusService service = new CusServiceImpl();
			ArrayList<Customer> customerList = service.getCusDetails();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/list_employee.jsp");
			rd1.forward(request, response);
		}

}
