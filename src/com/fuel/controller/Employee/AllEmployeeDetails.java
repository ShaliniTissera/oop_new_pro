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

@WebServlet("/AllEmployeeDetails")
public class AllEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IEmpService service = new EmpServiceImpl();
		ArrayList<Employee> employeeList = service.getEmpDetails();

		request.setAttribute("employeeList", employeeList);
		RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/list_employee.jsp");
		rd1.forward(request, response);
	}

}
