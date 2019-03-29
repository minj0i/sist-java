<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.vo.DiaryDetailVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
		<div style="padding-top:100px">
			<c:import url="../common/jsp/main_menu.jsp"/>
		</div>
	</div>
	
	<div id="container">
	<div id="readFrm">
<%
	DiaryDAO d_dao=DiaryDAO.getInstance();
	try{ //proxy : 
		int num=Integer.parseInt(request.getParameter("num"));
		DiaryDetailVO dd_vo= d_dao.selectDetailEvent(num);
		if(dd_vo==null){
			throw new NullPointerException();
		}//end if
%>
<form action="list.jsp" method="post" name="readFrm">
<input type="hidden" name="pageFlag" />
<input type="hidden" name="num" value="${param.num}" />
<input type="hidden" name="param_year" value="${param.param_year}"/>
<input type="hidden" name="param_month" value="${param.param_month}"/>
<table id="readTab">
	 <tr>
		<th colspan="2" style="text-align:center">
			<span style="font-size:18px">이벤트 작성</span>
			<span style="float:right; padding-right:5px;">
			<!-- <a href="#void" id="btnCloseFrm"><img src="images/X.png"/></a> -->
			</span>
		<th>
	</tr> 
	<tr>
		<td style="width:80px">제목</td>
		<td style="width:400px">
			<div id="subject"><strong><%= dd_vo.getSubject() %></strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px">내용</td>
		<td style="width:400px">
			<%= dd_vo.getContents() %>
		</td>
	</tr>
	<tr>
		<td style="width:80px">작성자</td>
		<td style="width:400px">
			<div id="writer"><strong><%=dd_vo.getWriter() %></strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px">비밀번호</td>
		<td style="width:400px">
			<input type="password" name="pass" id="pass" class="inputBox"
				style="width:120px"/>
		</td>
	</tr>
	<tr>
		<td style="width:80px">작성일</td>
		<td style="width:400px">
			<div id="wDate"><strong><%= dd_vo.getW_date() %></strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px">작성IP</td>
		<td style="width:400px">
			<div id="ip"><strong><%=dd_vo.getIp() %></strong></div>(작성 시 IP : <%= request.getRemoteAddr() %>)
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href="#void" onclick="history.back()">리스트 보기</a>
		</td>
	</tr>
	
</table>
</form>
<%
	}catch(IOException ioe){
%>
	글의 내용을 읽어들이지 못하였습니다. ㅈㅅ
<% 		
	}catch(NumberFormatException nfe){
%>
	유효하지 않은 파라미터가 입력되었습니다.
<%
	}catch(NullPointerException npe){
%>
	해당 글을 찾을 수 없습니다.<br/>
<% 
	}catch(SQLException se){
		se.printStackTrace();
	%>
	<img src="images/construnction.jpg" title="뎨둉합니다.T^T 빠른 복구를 위해 노력중입니다."/>
	<%
	}//end catch
%>
</div>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>