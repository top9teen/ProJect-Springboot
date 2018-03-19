<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String result = "";
%>
<%
	result = (String) request.getAttribute("messessError");
%>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style type="text/css">
form {

}
</style>
</head>
<body>
	<div class="container" >
		<form name="login" action="adminlogin" method="post">
			<div class="panel panel-primary" style="margin-top: 15%">
				<div class="panel-heading" align="center"></div>
				<h2 align="center">WELCOME PROJECT ADMIN</h2>
				<br>
				<div class="panel-body">
				<%
						if (result.equals("F")) {
					%>
					<div class="alert alert-danger">
						<strong>ผิดพลาด ! </strong> กรุณากรอก ให้ถูกต้อง !!
					</div>
					<%
						}else if(result.equals("L")){
					%>
							<div class="alert alert-success">
						<strong>Success </strong> Logout Success
					</div>
					<%} %>
					<div class="form-group">
						<label for="exampleInputEmail1"></label> <input type="text"
							class="form-control" placeholder="Usermane" name="username">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"></label> <input
							type="password" class="form-control" placeholder="Password"
							name="password">
					</div>
					<!-- <div class="form-group">
					<select name="roleId" class="form-control">
					<option value="1"> Admin </option>
					<option value="2"> User </option>
					</select>
					</div>  -->
				</div>
				<br>
				<div class="panel-footer" align="right">
					<input type="submit" class="btn btn-outline-primary" value="Login">&nbsp;
				</div>
			</div>

		</form>
	</div>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>


	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>