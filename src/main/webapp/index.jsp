<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Untitled Document</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
.ui-block-a, .ui-block-b, .ui-block-c {
	text-align: center;
	padding: 10px;
	width: 15%;
}

.block {
	width: 57px;
	height: 57px;
	line-height: 57px;
	display: inline-block;
	background-image:
		url(http://7oxh58.com2.z0.glb.clouddn.com/Content/Images/home-block.png);
	background-repeat: no-repeat;
	background-size: 57px 456px;
}

.label {
	display: block;
	text-shadow: 1px 1px 1px #FFF;
}
</style>

</head>

<body>

	<div data-role="page"
		style="background-image: url(http://7oxh58.com2.z0.glb.clouddn.com/Content/Images/home-bg1.jpg); background-repeat: no-repeat; background-size: cover;">
		<div data-role="header" data-position="fixed">
			<h1>宠物助手</h1>
		</div>
		<div role="main" class="ui-content">

			<div style="position: fixed; bottom: 18%; width: 100%;">

				<div class="ui-grid-b" align="center" style="margin-left: -23px;">
					<div class="ui-block-a">
						<a href="adopt.html" data-ajax="false"><i class="block"
							style="background-position: 0 0;"></i><span class="label">领养</span></a>
					</div>
					<div class="ui-block-b">
						<a href="getHelp.html"  data-ajax="false"><i class="block"
							style="background-position: 0 -57px;"></i><span class="label">求助</span></a>
					</div>
					<div class="ui-block-c">
						<a href="bikan.html" data-ajax="false"><i class="block"
							style="background-position: 0 -114px;"></i><span class="label">必看</span></a>
					</div>
					<div class="ui-block-a" >
						<a href="<%=path %>/petlost/queryPetLostInfo?page=0" data-ajax="false"><i class="block"
							style="background-position: 0 -285px;"></i><span class="label">走失</span></a>
					</div>
					<div class="ui-block-b">
						<a href="huodong.html"  data-ajax="false"><i class="block"
							style="backsground-position: 0 -342px;"></i><span class="label">活动</span></a>
					</div>
					<div class="ui-block-c">
						<a href="us.html"  data-ajax="false"><i class="block"
							style="background-position: 0 -399px;"></i> <span class="label">我们</span></a>
					</div>
				</div>

			</div>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="#" data-icon="home" class="ui-btn-active">首页</a></li>
					<li><a href="#" data-icon="grid">必看</a></li>
					<li><a href="#" data-icon="gear">我</a></li>
					<li><a href="#" data-icon="refresh">刷新</a></li>
				</ul>
			</div>
		</div>
	</div>



</body>
</html>