<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto; width:800px; height:860px;}
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/spring_mvc/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; min-height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		<c:if test="${cookieFlag}">
			alert("${msg}");
		</c:if>
	});//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
		<div style="padding-top:100px">
			<c:import url="/common/jsp/main_menu.jsp"/>
		</div>
	</div>
	
	<div id="container">
	<div>
		<strong>Model에 들어 있는 쿠키들 읽기</strong><br/>
		<c:choose>
		<c:when test="${empty an_name and empty an_age}">
			쿠키가 존재하지 않습니다.<br/>
			<a href="an_add_cookie.do">쿠키심기</a>
		</c:when>
		<c:otherwise>
			이름 : <strong>${an_name}</strong><br/>
			나이 : <strong>${an_age}</strong><br/>
		</c:otherwise>
		</c:choose>
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>