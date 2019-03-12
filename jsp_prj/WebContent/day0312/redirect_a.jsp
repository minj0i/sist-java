<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="redirect의 사용"
    %>
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
	//정상적인 요청으로 이 페이지를 방문하면 정상적인 응답을 해주지만
	//비정상적인 요청이 있다면 다른 페이지로 이동할 때 사용.
	if(new Random().nextBoolean()){
		//response 내장객체를 사용하여 이동
		response.sendRedirect("redirect_b.jsp");//URL을 받으므로 다른 외부 site로 이동도 가능
		return;
	}//end if
	%>
	<img src="../common/images/img.png" title="내 목뼈는 정상임"/>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>