
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

<script type="text/javascript">
	function chancePetType(petType) {

		var selOpt = $("#petTypeId");

		$.getJSON("petlost/queryPetTypeList", {
			petType : petType
		}, function(result) {

			if(result.length>0){
				selOpt.empty();
			}

			$.each(result, function(i, field) {

				selOpt.append("<option value='"+field.id+"'>" + field.typeName
						+ "</option>");

			});

			selOpt.selectmenu('refresh');
		});

	}
	
	function checkForm(){
		
		if($("#petName").val()==""){
			
			alert("填写完整信息");
			
			return false;
		}
		
		if($("#loseLocation").val()==""){
			
			alert("填写完整信息");
			
			return false;
		}
		
		
		
		
	}
	
</script>

</head>

<body>

	<div data-role="page" id="pageone">
		<div data-role="header" data-position="fixed">
			<h2>发布宠物丢失记录</h2>
		</div>
		<div role="main" class="ui-content">

			<form action="<%=path %>/petlost/addPetLostInfoPage" data-ajax="false" onsubmit="return checkForm();" method="post" enctype="multipart/form-data">
				<label for="petName" class="ui-hidden-accessible">宠物昵称:</label> <input
					type="text" name="petName" id="petName" placeholder="请输入宠物昵称"
					value="">

				<fieldset data-role="controlgroup" data-type="horizontal"
					data-mini="true">
					<legend>宠物性别:</legend>
					        <input type="radio" name="petSex" id="radio-choice-c"
						value="1" checked="checked">         <label
						for="radio-choice-c">酷哥</label>         <input type="radio"
						name="petSex" id="radio-choice-d" value="2">         <label
						for="radio-choice-d">萌妹</label>
				</fieldset>

				<fieldset data-role="controlgroup" data-type="horizontal"
					data-mini="true">
					<legend>宠物类型:</legend>
					  <input type="radio" name="petType" id="radio-choice-e" value="1"
						onclick="javascript:chancePetType(this.value);" checked="checked">
					         <label for="radio-choice-e">狗</label>   <input
						type="radio" name="petType" id="radio-choice-f" value="2"
						onclick="javascript:chancePetType(this.value);">   <label
						for="radio-choice-f">猫</label> <input type="radio" name="petType"
						id="radio-choice-g" value="3"
						onclick="javascript:chancePetType(this.value);">          <label
						for="radio-choice-g">其他</label>
				</fieldset>

				<select name="petTypeId" id="petTypeId">
					<c:forEach items="${petTypeList}" var="petType">
						<option value="${petType.id }">${petType.typeName }</option>
					</c:forEach>
				</select> <label for="loseLocation" class="ui-hidden-accessible">丢失地址:</label>
				<input type="text" name="loseLocation" id="loseLocation"
					placeholder="丢失地址" value=""> <label for="loseDate">丢失时间:</label>
				<input type="date" name="loseDate" id="loseDate" value=""> <label
					for="petBirthday">宝贝生日:</label> <input type="date"
					name="petBirthday" id="petBirthday" value=""> <label
					for="rewards">悬赏金额:</label> <input type="number" name="rewards"
					pattern="[0-9]*" id="rewards" value=""> <label
					for="loseDescribe">丢失描述:</label>
				<textarea cols="40" rows="8" name="loseDescribe" id="loseDescribe"></textarea>

				<label for="imageFile">宝贝图片:</label> <input type="file"
					name="imageFile" id="imageFile" value="">

				<button type="submit">提交</button>
			</form>
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
