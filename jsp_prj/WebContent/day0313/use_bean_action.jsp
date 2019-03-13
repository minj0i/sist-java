<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
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
	<!--객체 생성  -->
	<!--<%@ page import="day0313.TestVO" %> import해도 아래 class명에 TestVO만 쓰면 에러남  -->
	<jsp:useBean id="t_vo" class="day0313.TestVO" scope="page"/>
	<!--setter호출 : set을 제외한 method명을 set을 제외한 소문자로 시작되게 호출 -->
	<jsp:setProperty property="firstName" name="t_vo" value="노진경"/>
	<jsp:setProperty property="age" name="t_vo" value="20"/>
	<!--getter호출: get을 제외한 method명을 소문자로 기술
		Expression을 사용하지 않아도 화면 출력이 된다.
	-->
	이름 : <jsp:getProperty property="firstName" name="t_vo"/><br/>
	나이 : <jsp:getProperty property="age" name="t_vo"/><br/>
	<%
	//<jsp:useBean으로 생성된 객체는 자바코드로 접근하여 사용할 수 있다.
	//setter 호출
	t_vo.setFirstName("정윤");
	t_vo.setAge(30);
	%>
	<!--getter호출  -->
	<div>
	재설정 이름: <%=t_vo.getFirstName() %><br/>
	재설정 나이: <%=t_vo.getAge() %><br/>
	</div>
	
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>