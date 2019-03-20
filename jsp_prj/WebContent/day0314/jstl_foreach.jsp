<%@page import="day0313.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="반복문 forEach 사용"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<select>
		<c:forEach var="i" begin="1" end="100" step="1">
		<option value="${i}"><c:out value="${i}"/></option>
		</c:forEach>
	</select>
	<div>
	<%
	//배열의 값 출력
		String[] movie={"시네마 천국","주토피아","코어","7인의 사무라이","트루먼 쇼","인셉션"}; 
		pageContext.setAttribute("movie", movie);	
	%>
	<ul>
	<c:forEach var="movie" items="${movie}">
		<c:set var="i" value="${i+1}"/>
		<li>${i}.${movie}</li>
	</c:forEach>
	<%
		//List의 값 출력
		List<String> list = new ArrayList<String>();
		list.add("Java SE");
		list.add("Java EE");
		list.add("DBMS");
		list.add("HTML");
		pageContext.setAttribute("list", list);
	%>
	<ul>
	<c:forEach var="subject" items="${list}">
	<li><c:out value="${subject}"/></li>
	</c:forEach>
	</ul>
	<%
		//List가 Generic으로 VO를 가진 경우사용
		//forEach안에서 "변수명.getter명"
		List<TestVO> voList=new ArrayList<TestVO>();
		voList.add(new TestVO("정윤",30));
		voList.add(new TestVO("희철",27));
		voList.add(new TestVO("재찬",26));
		voList.add(new TestVO("택성",28));
		
		pageContext.setAttribute("vl", voList);
	%>
	</ul>
	<table>
	<thead>
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="50">나이</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="data" items="${vl}">
	<c:set var="cnt" value="${cnt+1}"/> <!--자동 초기화되어 0부터 들어감 -->
	<tr>
		<td><c:out value="${cnt}"/></td>
		<td><c:out value="${data.firstName}"/></td>
		<td><c:out value="${data.age}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

	</div>
	
	</div>
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>