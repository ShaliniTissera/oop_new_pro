package com.fuel.controller.Employee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuel.model.Employee.Employee;
import com.fuel.services.EmployeeService.EmpServiceImpl;
import com.fuel.services.EmployeeService.IEmpService;
import com.fuel.Util.Employee.EmailInUse;

@WebServlet("/AddEmployeeDetailsServelt")
public class AddEmployeeDetailsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		Employee emp = new Employee();

		emp.setFname(request.getParameter("fname"));
		emp.setLname(request.getParameter("lname"));
		emp.setDesignation(request.getParameter("designation"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary"))); // convert string to double
		emp.setEmail(request.getParameter("email"));

		IEmpService empService = new EmpServiceImpl();
		
		if (empService.isEmailAlreadyInUse(emp.getEmail()) != null) {	
			throw new EmailInUse("Email is taken");
		}

		if (empService.addEmpDetails(emp)) {
			ArrayList<Employee> employeeList = empService.getEmpDetails();	
			
			request.setAttribute("success1", "EmployeeAdd");
			request.setAttribute("employeeList", employeeList);
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
