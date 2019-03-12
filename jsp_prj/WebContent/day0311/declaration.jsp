<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%! /* 느낌표를 지워서 지역변수로 만들게 되면 초기화가 필요하기 때문에 아래에서 에러남 */
	 int i;//instance 변수
	 
	 public String name(){
		 
		 return "공선의";
	 }//test
	 
		/* public String ip(){
	  //선언은 내장 객체를 쓸 수 없음
		 String ip = request.getRemoteAddr();
		 return ip;
	 } */
	%>
	<%! 
		public void test(){
	 	int j=0;
	%>
		<%-- <%= j %> : declaration사이에서 정의된 코드지만 생성되는 위치가 달라 출력할 수 없다. --%>
	<%!
	}//test
	%>
	
	
	i=<%= i %> <!-- 정수형 데이터형의 기본 0이 들어감 -->
	이름: <%= name() %>
	<%
	//request: 내장(내재)객체 - _jspService 메소드 안에서 자동 선언되어 있는 객체
		String ip = request.getRemoteAddr();
	%>
	접속자 Ip Address : <%= ip %>
	<%-- <% 
		/* public void test(){
		} */
	%> --%>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>