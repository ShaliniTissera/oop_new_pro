<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="com.fuel.model.Employee.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Pizza Ordering System</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<a class="navbar-brand" href="#">Pizza Ordering System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<form method="POST" action="AllEmployeeDetails">
						<button class="btn btn-link mt-3" style="color: white">All
							Customer</button>
					</form>
					<form method="POST" action="ViewAddEmployeeServelet">
						<button class="btn btn-link mt-3" style="color: white">Add
							Customer</button>
					</form>
					<a class="nav-item nav-link" href="#">Add Customer</a>
				</div>
			</div>
		</nav>

		<%
			Customer emp = (Customer) request.getAttribute("customer");
		%>

		<form method="POST" action="UpadateEmployeeDetailsServlet" class="mt-5">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="fname">First Name</label> <input type="text"
						class="form-control" id="fname" name="fname"
						placeholder="First Name" value="<%=emp.getFname()%>">
				</div>
				<div class="form-group col-md-6">
					<label for="lname">Last Name</label> <input type="text"
						class="form-control" id="lname" name="lname"
						placeholder="Last Name" value="<%=emp.getLname()%>">
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="address">Address</label> <input type="text"
						class="form-control" id="address" name="address"
						placeholder="Address" value="<%=emp.getAddress()%>">
				</div>
				<div class="form-group col-md-6">
					<label for="phone">Phone</label> <input type="text"
						class="form-control" id="phone" name="phone"
						placeholder="Phone" value="<%=emp.getPhone()%>">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="E-mail"
						value="<%=emp.getEmail()%>">
				</div>
			</div>
			<input type="hidden" name="empID" value="<%=emp.getEmpID()%>" />

			<%
				if (request.getAttribute("error1") != null) {
			%>

			<div class="alert alert-danger" role="alert">E-mail Already
				Taken</div>

			<%
				}
			%>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>


