<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="script 연습"%>
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
td:hover{font-size:10px; background-color:#FF0000}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".t").click(function(){
		alert($(this).children().val());
	});//click
	
	var d=new Date();
	var time="";
	time+=d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate()+" "
	+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
	$("#c_time").text(time);
	
});//
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
	</div>
	
	<div id="container">
	
	<%
	//scriptlet은 _jspService method내에 코드가 생성된다.
		int i=3;//지역 변수 : 자동초기화가 되지 않음. 값을 직접 넣어줘야 함
	%>
	<%= i %>
	<%
	for(int j=1; j<7; j++){	%>
		<h<%=j%>>오늘은 불금입니다.</h<%=j%>>
	<% }//end for%>
	<%
		String[]names={"노진경", "김정윤", "박영민", "김희철", "이지수"};
	%>
	<table border="1">
	<tr>
		<th width="100">이름</th>
	</tr>
	<%for(int k=0; k<names.length; k++){ %>
	<tr>
		<td><%= names[k] %></td>
	<tr>
	<% }//end for %>
	</table>
	<!-- 1~100까지 합만 출력 -->
	<% int sum=0;
		for(int l=1; l<101; l++){
		sum+=l;
	}//end for%>
	1에서부터 100까지 합은 <%=sum %> 입니다.
	</div>
	<div>
	<!-- 구구단 출력 세로-->
	<table border="1">
	<% for(int m=1; m<10; m++) {%>
	<tr>
		<td> 3 * <%= m %> = <%=3*m%> </td>
	</tr>
	<% }//end for %>
	</table>
	</div>
	<div>
	<!-- 구구단 출력 가로-->
	<table border="1">
	<tr>
	<% for(int m=1; m<10; m++) {%>
		<td> 3 * <%= m %> = <%=3*m%> </td>
	<% }//end for %>
	</tr>
	</table>
	</div>
	
	
	<!-- 구구단 출력 전체-->
	<div>
	<table border="1">
	<% for(int m=1; m<10; m++) {%>
	<tr>
	<% for(int l=2; l<10; l++) {%>
		<%-- <td width=40; align="center" id="dan" onclick="alert('<%=l*m%>')">  --%>
		<td width=40; align="center" class="t">
		<%= l %> * <%= m %> 
		<input type="hidden" name="sum" value="l*m">
		</td>
	<% }//end for %>
	</tr>
	<% }//end for %>
	</table>
	</div>
	
	<!-- 년-월-일 요일 시:분 서버의 시간으로 얻어와서
	문자열로 보여주세요.
	버튼을 클릭하면 일자가 3초동안 서서히 사라지도록 만들 것
	-->
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEEE hh:mm:ss");
		String date=sdf.format(new Date());
	%>
	<div> SSS (Server Side Script : ASP/JSP를 지칭하는 말)
		서버 시간<span id="s_time"><%= date %></span>
		접속자 시간 : <span id="c_time"></span>
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</body>
</html>