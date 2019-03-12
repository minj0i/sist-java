<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="HTML에서 JSP를 요청"%>
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
<% if("GET".equals(request.getMethod())){ %>
#method{font-weight:bold; font-size:14px; color:#FF0000;}
<% }else{ %>
#method{font-weight:bold; font-size:16px; color:#0000FF;}
<% }//end else %>

</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
	</div>
	
	<div id="container">
	<ul>
		<li><strong> 요청 방식 : </strong>
		<span id="method"><%= request.getMethod() %></span></li>	
		<li><strong> 접속자의 IP Address : </strong>: <%= request.getRemoteAddr() %></li>
		<!--history.back()은 JavaScript 영역. html영역에서 JavaScript영역으로 바꾸고 싶다면 앞에 javascript:을 붙여준다.  -->
		<li><a href="javascript:history.back();" >뒤로</a></li>	 
	</ul>
	</div>
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>