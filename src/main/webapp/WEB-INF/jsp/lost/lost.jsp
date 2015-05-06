
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
<title>lost</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<style>
.img {
	margin-top: 10px;
	margin-left: 10px;
}

.img_icon {
	width: 10px;
	height: 10px;
	margin-right: 6px;
}

.span {
	font-size: 12px;
	font-weight: 300;
	color: gray;
}

p {
	word-wrap: break-word !important;
	white-space: normal !important;
}

.addButton {
	position: fixed;
	z-index: 15;
	right: 35px;
	bottom: 95px;
}
</style>


<script type="text/javascript">

	$(document).on("pageinit","#pageone",function(){
	  $(document).on("scrollstop",function(){
	    
		  var scrollBottom = $(document).height() - $(window).height() - $(window).scrollTop();
		  
		  if(parseInt(scrollBottom)<90){
			  appendView();  
		  }
	  });                       
	});


	var page = 1;


	function appendView() {

		var list = "";

		$.getJSON("petlost/queryPetLostByPull",{
			page : page
		}, function(result) {
			
			$.each(result, function(i, field) {
				
				var list = "<li>";

				list += "<a href='lostinfo.html?" + field.id+ " data-ajax='false'>";

				list += "<img src='"+field.img_url+"' class='img' />";
				
				list += "<p>";
				
				list +="<img src='<%=path%>/image/location_pin-16.png' class='img_icon' />";
				
				list +="<strong>走失地点:</strong>";
				
				list +="<span class='span'>"+field.loseLocation+"<span>";
				
				list += "</p>";
				
				list += "<p>";
				
				list +="<img src='<%=path%>/image/access-time-16.png' class='img_icon' />";
				
				list +="<strong>走失时间:</strong>";
				
				list +="<span class='span'>"+field.loseDate+"<span>";
				
				list += "</p>";
				
				list += "<p>";
				
				list += "<img src='<%=path%>/image/news.png' class='img_icon' />";

				list += "<strong>走失描述:</strong>";

				list += "<span class='span'>"+ field.loseDescribe+ "<span>";

				list += "</p>";

				list += "</a>";

				list += "</li>";

				$("#petLostList").append(list);

				$("#petLostList").listview('refresh');});
		});

		page++;

	}
</script>

</head>

<body>

	<div data-role="page" id="pageone">
		<div data-role="header" data-position="fixed">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="#" data-icon="location" class="ui-btn-active">全部地区</a></li>
					<li><a href="#" data-icon="home">我的城市</a></li>
				</ul>
			</div>
		</div>
		<div role="main" class="ui-content">
				<ul id="petLostList" data-role="listview" data-icon="false">
					<c:forEach items="${petList }" var="pet">
						<li><a href="lostinfo.html?${pet.id }" data-ajax="false">
								<img src="${pet.img_url }" class="img" />
								<p>
									<img src="<%=path%>/image/location_pin-16.png" class="img_icon" /><strong>走失地点:</strong> <span class="span">${pet.loseLocation }<span>
								</p>
								<p>
									<img src="<%=path%>/image/access-time-16.png" class="img_icon" /><strong>走失时间:</strong><span
										class="span">${pet.loseDate }</span>
								</p>
								<p>
									<img src="<%=path%>/image/news.png" class="img_icon" /><strong>走失描述:</strong><span
										class="span">${pet.loseDescribe }</span>
								</p>
						</a></li>
					</c:forEach>
				</ul>
			

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

		<div class="addButton">
			<a href="<%=path%>/petlost/toAddPetLostInfoPage" data-ajax="false"><img width="35" height="35" src="<%=path%>/image/add.png"></a>
		</div>
	</div>

</body>
</html>
