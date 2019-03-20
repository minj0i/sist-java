<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="예외처리"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
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
	
	<c:catch var="e">
	<%
	/* try{ */
		//코드생성
		Class.forName("Test");//예외를 throws하는 method를 호출하더라도 _jspServcie()가
		//코드를 try~catch로 감싸고 있기 때문에 코드 에러가 발생하지 않는다.
	/* }catch(ClassNotFoundException cnfe){
		out.print("뎨둉합니다.");
	} */
	%>
	</c:catch>
<%-- 	<c:if test="${e ne null }"> --%>
	<c:if test="${not empty e }">
	서비스 도중 문제가 발생하였습니다.<br/>
	${ e }
	</c:if>
	
	<%-- <%!
		public void test(){
		Class.forName("");
	}
	%> --%>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>