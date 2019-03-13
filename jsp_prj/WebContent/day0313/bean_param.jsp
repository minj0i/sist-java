<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="Web Parameter를 useBean action tag로 처리하는 방법."
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
	<!-- HTML Form Contorl의 값 받기 . 값의 사용범위를 생각하여 scope에 값 입력 -->
	<!--useBean을 쓰면 request.getParameter를 쓰지 않고도 접속자가 입력하는 값을 다 쓸 수 있다.  -->
<% request.setCharacterEncoding("UTF-8"); %>
	<!-- 1. Bean 생성 -->
	<jsp:useBean id="bp_vo" class="day0313.BeanParamVO" scope="page"/>
	<!-- 2. setter method를 불러서 값을 저장 -->
	<jsp:setProperty property="*" name="bp_vo"/>
	<%-- <%=bp_vo %>--%>
	<table>
	<tr>
		<td colspan="2">입력하신 정보는 아래와 같습니다.</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><jsp:getProperty property="id" name="bp_vo"/></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><jsp:getProperty property="name" name="bp_vo"/></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<!--숫자로 변환되어 저장된 값  -->
		<td><jsp:getProperty property="b_year" name="bp_vo"/>-
		<jsp:getProperty property="b_month" name="bp_vo"/>-
		<jsp:getProperty property="b_day" name="bp_vo"/>
		(만 <%=2019-bp_vo.getB_year() %>세)
		</td>
	</tr>
	<tr>
		<td>관심언어</td>
		<!-- 로 막으면 소스보기에 뜨기 때문에 <%-- --%>로 주석 달아줘야 한다. -->
		<%-- <td><jsp:getProperty property="interestlang" name="bp_vo"/></td> --%>
		<td>
		<%
		String[] lang=bp_vo.getinterestlang();
		if(lang!=null){
			for(int i=0; i<lang.length; i++){
				out.print(lang[i]);
				out.println(" ");
			}//end for
		}else{
			out.println("관심언어 없음");
		}//end else
		%>
	</tr>
	</table>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>