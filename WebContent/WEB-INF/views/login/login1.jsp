<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login </title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/SERVLET_CRM/static/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/css/util.css">
	<link rel="stylesheet" type="text/css" href="/SERVLET_CRM/static/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
				<form class="login100-form validate-form" action='<c:url value="/login"/>' method="POST">
					<span class="login100-form-title p-b-43">
						Account Login
					</span>
					
					<div class="wrap-input100 rs1 validate-input" data-validate = "Username is required">
						<input class="input100" type="email" name="email">
						<span class="label-input100">Email</span>
					</div>
					
					
					<div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="password">
						<span class="label-input100">Password</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit"> 
							Sign in
						</button>
					</div>
					
				
				</form>
					<p></p>
					<p class="text-center txt1">${message }</p>
			</div>
		</div>
	</div>
	
	

	
	
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/vendor/bootstrap/js/popper.js"></script>
	<script src="/SERVLET_CRM/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/vendor/daterangepicker/moment.min.js"></script>
	<script src="/SERVLET_CRM/static/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/SERVLET_CRM/static/js/main.js"></script>

</body>
</html>