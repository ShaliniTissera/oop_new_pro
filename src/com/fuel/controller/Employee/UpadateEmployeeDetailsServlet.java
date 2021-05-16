package com.fuel.controller.Employee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuel.Util.Employee.CommonConstant;
import com.fuel.model.Employee.Customer;
import com.fuel.model.Employee.Employee;
import com.fuel.services.EmployeeService.CusServiceImpl;
import com.fuel.services.EmployeeService.EmpServiceImpl;
import com.fuel.services.EmployeeService.ICusService;
import com.fuel.services.EmployeeService.IEmpService;

@WebServlet("/UpadateEmployeeDetailsServlet")
public class UpadateEmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer emp = new Customer();

		emp.setEmpID(Integer.parseInt(request.getParameter("empID")));
		emp.setFname(request.getParameter("fname"));
		emp.setLname(request.getParameter("lname"));
		emp.setAddress(request.getParameter("address"));
		emp.setPhone(Integer.parseInt(request.getParameter("phone"))); 
		emp.setEmail(request.getParameter("email"));
		
		ICusService empService= new CusServiceImpl();
		
		Customer currentEmp= empService.getCusDetailsByID(emp.getEmpID());
		if (!currentEmp.getEmail().equalsIgnoreCase(emp.getEmail()) && empService.isEmailAlreadyInUse(emp.getEmail()) != null) {			
			request.setAttribute("error1", "Email In Use");
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/edit_employee.jsp");
			rd1.forward(request, response);
			response.sendRedirect("/WEB-INF/views/edit_employee.jsp");
			return;
			
		}
		
		if (empService.updateCusDetails(emp)) {
			ArrayList<Customer> customerList = empService.getCusDetails();	
			
			request.setAttribute("success3", "CustomerUpdated");
			request.setAttribute("customerList", customerList);
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/list_employee.jsp");
			rd1.forward(request, response);
			response.sendRedirect("/WEB-INF/views/list_employee.jsp");
			return;
		} else {
			request.setAttribute("customer", emp);
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/edit_employee.jsp");
			rd1.forward(request, response);
		}

	}

}
