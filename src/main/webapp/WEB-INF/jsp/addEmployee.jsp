<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="/addNewEmployee" method="post" modelAttribute="emp">
			<p>
				<label>Enter Employee Id</label>
				<form:input type="text" path="empId" placeholder="Employee ID in numeric." size="30"/>
			</p>
			<p>
				<label>Enter Name</label>
				<form:input type="text" path="empName" placeholder="Enter valid Employee name." size="30"/>
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
