<%@page import="xml0326.RssVO"%>
<%@page import="xml0326.JtbcRssParsing"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
#container{width:800px; min-height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}
td{padding:3px;}
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
	<div id="subject" style="text-align:center; margin-top:20px">
	[<a href="jtbc_rss.jsp?title=newsflash">속보</a> |
	<a href="jtbc_rss.jsp?title=politics">정치</a> |	
	<a href="jtbc_rss.jsp?title=economy">경제</a> |	
	<a href="jtbc_rss.jsp?title=society">사회</a> |	
	<a href="jtbc_rss.jsp?title=international">국제</a>	|
	<a href="jtbc_rss.jsp?title=culture">문화</a> |	
	<a href="jtbc_rss.jsp?title=entertainment">연예</a> |	
	<a href="jtbc_rss.jsp?title=sports">스포츠</a> |	
	<a href="jtbc_rss.jsp?title=fullvideo">풀영상</a> |
	<a href="jtbc_rss.jsp?title=newsrank">뉴스랭킹</a> |	
	<a href="jtbc_rss.jsp?title=newsroom">뉴스룸</a> ]
	</div>
	<div id="newsView">
	<%
	String title=request.getParameter("title");
	if(title==null){
		title="newsflash";
	}//end if
	JtbcRssParsing jrp=JtbcRssParsing.getInstance();
	List<RssVO> list=jrp.getNews(title);
	pageContext.setAttribute("newsList", list);
	%>
	<c:if test="${empty newsList}">
	네떡 연결이 불안정합니다. 잠시 후 다시 시도해주세요.
	</c:if>
	<c:forEach var="news" items="${newsList}">
	<table style="border:1px solid #333333; border-spacing:0px; margin-top:6px" >
	<tr>
		<td style="width:50px; text-align: center; border-right:1px solid #333">제목</td>
		<td colspan="3" style="width:650px; text-align: left">
			<c:out value="${news.title}"/>
		</td>
	</tr>
	<tr>
		<td style="width:50px; text-align: center; border-right:1px solid #333 ">링크</td>
		<td style="width:300px; text-align: left">
			<a href="${news.link}" target="_new">뉴스 이동</a></td>
		<td style="width:50px; text-align: center">작성일</td>
		<td style="width:300px; text-align: left">
			<c:out value="${news.pubDate}" />
		</td>
	</tr>
	<tr>
		<td style="width:50px; text-align: center; border-right:1px solid #333">설명</td>
		<td colspan="3" style="height:50px; width:650px; text-align: left">
			<c:out value="${news.description}" escapeXml="false"/>
		</td>
	</tr>
	</table>
	</c:forEach>
	
	</div>
	
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>