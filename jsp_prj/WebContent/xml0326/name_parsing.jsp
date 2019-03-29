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
<%!
	public List<String> xmlParsing() throws IOException{
		List<String> list = new ArrayList<String>();
		//1. XML과 연결
		
		BufferedReader br = null;
		try{
			File file=new File("C:/dev/workspace/jsp_prj/WebContent/xml0326/names.xml");
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			
		//2. 줄단위로 읽어 들인다.
		String temp="";
		while((temp=br.readLine())!=null){
			if(temp.contains("<name>")){//줄 단위로 읽어들인 내용에 <name> 이 있다면
				list.add(temp.substring(temp.indexOf(">")+1,temp.lastIndexOf("<"))); //list에 데이터를 잘라서 담는다.
			}//end if
		}//end while
			
		}finally{
			if(br!=null){br.close();}//end if
			
		}//end finally
	
		return list;
	}//xmlParsing
%>
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
	<table border="1">
		<tr>
			<td width="100">이름</td>
		</tr>
		<c:forEach var="name" items="<%= xmlParsing() %>" >
		<tr>
			<td style="text-align: center">${name}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>