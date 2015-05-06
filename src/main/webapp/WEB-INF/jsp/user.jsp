<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="bs-example bs-navbar-top-example"
		data-example-id="navbar-fixed-to-top">
		<nav class="navbar navbar-default navbar-fixed-top"> <!-- We use the fluid option here to avoid overriding the fixed width of a normal container within the narrow content columns. -->
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-6">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">用户管理</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-6">
				<ul class="nav navbar-nav">
					<li><a href="<%=path%>/inputUser">添加用户</a></li>
					<li><a href="#">修改用户</a></li>
				</ul>
			</div>
		</div>
		</nav>
	</div>

	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">Panel heading</div>
		<div class="panel-body">
			<p>用户表</p>
		</div>

		<table class="table">
			<tr>
				<th>ID</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>
			
			<c:forEach items="${userlist}" var="user">
							
				<tr>
					<th>${user.id }</th>
					<th>${user.username }</th>
					<th>${user.userpwd }</th>
					<th><a href="<%=path %>/delUser/${user.id}" class="btn btn-danger">删除</a></th>
					<th><a href="<%=path %>/toUpdateUser/${user.id}" class="btn btn-info">修改</a></th>
					
				</tr>
			
			</c:forEach>
			
		</table>
	</div>


</body>
</html>