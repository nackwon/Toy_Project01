<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/register.css">
</head>
<body>
	<div class="register-box">
		<img src="assets/img/avatar.png" class="avatar" />
		<h1>Register</h1>
		<form id="register-form" method="post" action="/Music_Finder/user?a=join" enctype="application/x-www-form-urlencoded">
			<p>Username</p>
			<input type="text" name="username" placeholder="Enter Username" value="" />
			<p>Password</p>
			<input type="password" name="userpassword" placeholder="Enter UserPassword" />
			<input type="submit" name="submit" value="Register" /> <br/> 
			<a href="/Music_Finder/user?a=loginform">go to Login</a>
		</form>
	</div>
</body>
</html>