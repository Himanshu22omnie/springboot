<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .login-container {
            margin-top: 100px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center login-container">
            <div class="col-md-6 col-sm-12">
                <div class="card">
                    <div class="card-header">
                        Login
                    </div>
                    <div class="card-body">
                        <form action="/logins" method="Post" onsubmit="return validateForm()">
                            <div class="form-group">
                                <label for="userName">UserName:</label>
                                <input type="text" class="form-control" id="userName" name="userName" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="error-message" class="alert alert-danger" style="display: none;"></div>
    
    
	<!--  <c:if test="${param.logins!=null}">
	 <p style="color: green">You have successfully logged out.!</p>
	 </c:if>   -->
	 
	 
	 
	 
	 
	 
	 <script>
    function validateForm() {
        var userName = document.getElementById("userName").value;
        var password = document.getElementById("password").value;

        // Add your validation logic here, for example, checking if the fields are empty or have valid values.
        // For demonstration purposes, let's assume the validation fails.
        if (userName === "" || password === "") {
            document.getElementById("error-message").innerHTML = "Invalid login data. Please provide valid username and password.";
            document.getElementById("error-message").style.display = "block"; // Show the error message
            return false; // Prevent form submission
        }

        // If validation succeeds, you can submit the form.
        return true;
    }
</script>
	 
	 
	 
	 
	 
	 
	 
	 

</body>
</html>