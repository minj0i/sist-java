<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="JSTL의 if문"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디자인</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v190130.css"/>
<style type="text/css">
/* wrap에 background-color를 넣고 header, container, footer에도 background-color를 넣어 가려지는지 확인 */
#wrap{margin:0px auto; width:800px; height:860px;}
/* wrap안쪽 디자인들은 wrap안에 들어있기 때문에 width안줘도 자동으로 800이 됨 */
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
	</div>
	
	 <div id="container">
	<%--
	조건은 true | false가 들어간다.
	<c:if test="true">
	오늘은 목요일 입니다.
	</c:if>
	--%>
	<a href="#void">공지사항 읽기</a>
	<c:if test="${param.user_role eq 'admin'}">
	<a href="#void">공지사항 쓰기</a>
	<a href="#void">공지사항 수정</a>
	<a href="#void">공지사항 삭제</a>
	</c:if>
	<div>
		<a href="use_if.jsp?user_role=user">일반사용자</a>
		<a href="use_if.jsp?user_role=admin">관리자</a>
	</div>
	<form action="use_if.jsp">
		<label>이름</label>:<input type="text" name="name" class="inputBox"/>
		<input type="submit" value="입력" class="btn"/>	
	</form>
	<div>
		위의 Form Control에서 입력된 이름을 출력하는데 이름이 '이재찬' 이라면
		흘러가도록 만들어보세요. JSTL
		<c:if test="${param.name eq '이재찬'}">
		<marquee>
		</c:if>
		<c:out value="${param.name}"/>
		<c:if test="${param.name eq '이재찬'}">
		</marquee>
		</c:if>
	</div>
	
	
	</div>
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>