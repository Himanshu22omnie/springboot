<%@page import="com.config.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link rel=”stylesheet” href=”https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css”/>
	<!-- Bootstrap JS and Dependencies (jQuery and Popper.js) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	
</head>
<body>
<!--	<h5 class="card-title">Welcome ${user.userName}, To Our Website!</h5> 
	<div align="right">
		<a href="/logout">Logout</a>
	</div> -->
	
 <!-- 	<form action="/logout" method="post">
    <input type="submit" value="Logout"/>
	</form>  -->
	
	
	
	
	
	 <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            
            <div>
                <img src="image/profile.png" style="width: 40px; height: 40px;">
                <span>Hi, ${user.userName}!</span>
            </div>
			<a href="/logins" class="btn btn-danger ms-auto">Logout</a>
            <!-- <button class="btn btn-danger ms-auto" type="submit">Logout</button> -->
      </div>
    </nav>

	
	<section style="background-color: #eee;">
		<div class="container py-5">	
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-6 col-xl-4">
					<div class="card text-black">
						<i class="fab fa-apple fa-lg pt-3 pb-1 px-3"></i> <img
							src="image/user-large-solid.svg"
							class="card-img-top" alt="User" style="height: 100px", width="100px"/>
						<div class="card-body">
							<div class="text-center">
								<h5 class="card-title">Welcome ${user.userName}!</h5>
								<p class="text-muted mb-4">Thanks for getting in touch!</p>
							</div>
							<div>
								
								
								<div class="d-flex justify-content-between">
									<span>Technology </span><span>${user.technoloy}</span>
								</div>
								<div class="d-flex justify-content-between">
									<span>Designation</span><span>${user.designation}</span>
								</div>
								<div class="d-flex justify-content-between">
									<span>Company</span><span>${user.company}</span>
								</div>
							</div>
							<div
								class="d-flex justify-content-between total font-weight-bold mt-4">
								<span>Rating</span><span>5</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> 


</body>
</html>
