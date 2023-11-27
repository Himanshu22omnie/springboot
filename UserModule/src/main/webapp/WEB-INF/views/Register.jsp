<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Registration Page</title>
<link rel="stylesheet" href="styles.css">
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 50%;
	margin: 0 auto;
	text-align: center;
}

form {
	max-width: 300px;
	margin: 0 auto;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	box-sizing: border-box;
}

button {
	width: 100%;
	background-color: #4caf50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<c:if test="${not empty successMsg}">
			<div style="color: green;">${successMsg}</div>
		</c:if><br>

		<h2>Registration Form</h2>
		<form action="registerUser" method="post">
			<label for="userName">Username:</label> 
			<input type="text" id="username" name="userName" required><br> 
			
				<label for="email">Email:</label> 
				<input type="email" id="email" name="email" required><br> 
				
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" required><br>
				
				<label for="company">Company:</label> 
				<input type="text" id="company" name="company" required><br> 
				
				<label for="technoloy">Technology:</label> 
				<input type="text" id="technoloy" name="technoloy" required><br> 
				
				
				<label for=designation>Designation:</label> 
				<input type="text" id="designation" name="designation" required><br>

			<button type="submit">Register</button>
		</form>
	</div>
</body>
</html>
