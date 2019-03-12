<!--지시자 하나에 여러 속성 사용 -->
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="Page Directive 연습"%>
<%@ page buffer="8kb" autoFlush="true" %>
<%@ page isThreadSafe="true" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar" %>
<%@ page isELIgnored="false" %>
<%@ page errorPage="page_directive1.jsp" %>
<%@ page session="true" %>
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
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		if(new Random().nextBoolean()){
			throw new Exception("예외 강제 발생!");
		}//end if
		
		session.setAttribute("name", "정택성");
	%>
	<%=date %>, <%=year %>
	<div>
		<strong>EL(Expression Language)</strong>
		<br/>
		3+11=${3+11}<br/>
		<%-- web parameter: <%=request.getParameter("name") %> --%>
		web parameter: ${param.name }
		<br/>
		<a href="page_directive.jsp?name=heechul">요청</a>
	</div>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>