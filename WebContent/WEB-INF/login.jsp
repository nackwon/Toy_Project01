<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="assets/js/jquery/jquery-1.9.0.js"></script> <!-- jQuery -->
<link rel="stylesheet" href="assets/css/login.css">
<title>Insert title here</title>
</head>
<body>
	<div class="login-box">
		<img src="assets/img/avatar.png" class="avatar">
		<h1>Login Here</h1>
		<h2>Welcome to Music Finder</h2>
		<br>
        <form method="post" action="/Music_Finder/user?a=login">
		<p>Username</p>
		<input type="text" id="userName" name="username" placeholder="Enter Username"> <br>
		<p>Password</p>
		<input type="password" id="userpw" name="userpw" placeholder="Enter Password"> <br>
		<input onclick="login()" type="submit" value="Login"> <br>
		<a href="#">ForgetPassword</a>
		</form>
	</div>
</body>
</html>