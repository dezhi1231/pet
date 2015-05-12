<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>lostinfo</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>


.img {
	margin-top: 0px;
	margin-left: 0px;
	width: 120px;
	height: 120px;
}

td {
	word-wrap: break-word !important;
	white-space: normal !important;
	font-size: small;
}
</style>
</head>

<body>


	<div data-role="page">
		<div data-role="header" data-position="fixed">
			<h1>宠物助手</h1>
		</div>

		<div role="main" class="ui-content">

			<table>


				<tr>
					<td><strong>宠物名称:</strong></td>
					<td>${petLostInfo.petName }</td>
				</tr>
				<tr>
					<td><strong>性&nbsp;&nbsp;&nbsp;&nbsp;别:</strong></td>
					<td>${petLostInfo.petSex }</td>
				</tr>
				<tr>
					<td><strong>种&nbsp;&nbsp;&nbsp;&nbsp;类:</strong></td>
					<td>${petLostInfo.petTypeId }</td>
				</tr>
				<tr>
					<td><strong>走失地点:</strong></td>
					<td>${petLostInfo.loseLocation }</td>
				</tr>
				<tr>
					<td><strong>走失时间:</strong></td>
					<td>${petLostInfo.loseDate }</td>
				</tr>
				<tr>
					<td><strong>宠物生日:</strong></td>
					<td>${petLostInfo.petBirthday }</td>
				</tr>
				<tr>
					<td><strong>悬赏金额:</strong></td>
					<td>${petLostInfo.rewards }</td>
				</tr>
				<tr>
					<td><strong>走失描述:</strong></td>
					<td>${petLostInfo.loseDescribe }</td>
				</tr>
				<tr>
					<td><strong>发&nbsp;布&nbsp;人:</strong></td>
					<td>${petLostInfo.user_id }</td>
				</tr>

				<tr>
					<td></td>
					<td>
			<table cellspacing="0" cellpadding="0">
			<tr>
				<td><img src="<%=path %>/upload/${petLostInfo.img_url }" class="img"/></td>
				<td><img src="<%=path %>/upload/${petLostInfo.img_url }" class="img"/></td>
			</tr>
			<tr>
				<td><img src="<%=path %>/upload/${petLostInfo.img_url }" class="img"/></td>
				<td><img src="<%=path %>/upload/${petLostInfo.img_url }" class="img"/></td>
			</tr>
			<tr>
				<td><img src="<%=path %>/upload/${petLostInfo.img_url }" class="img"/></td>
				<td><img src="<%=path %>/upload/${petLostInfo.img_url }" class="img"/></td>
			</tr>
			
		</table> 
					</td>
				</tr>


			</table>



			<div style="width: 100%; background-color:#E0E0E0;">
				<table style="width: 100%">
					<tr>
						<td style="width: 80%;"><input type="text" name="message"
							placeholder="留言记录" /></td>
						<td>
							<button class="ui-btn ui-mini">发送</button>
						</td>
					</tr>
				</table>
			</div>

		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="#" data-icon="home">首页</a></li>
					<li><a href="#" data-icon="grid">必看</a></li>
					<li><a href="#" data-icon="gear">我</a></li>
					<li><a href="#" data-icon="refresh">刷新</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
