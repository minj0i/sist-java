<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에서 값을 얻어와서 값이 존재하지 않는다면 로그인 페이지로 이동
	String ses_id=(String)session.getAttribute("user_id");
	String ses_name=(String)session.getAttribute("user_name");
	
	if(ses_id==null||"".equals(ses_id)){
		response.sendRedirect("http://localhost:8080/jsp_prj/day0312/use_session.html");
		return;
	}//end if
%>