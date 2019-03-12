<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    %>
<%
	//세션의 값 삭제
	session.removeAttribute("user_id");
	session.removeAttribute("user_name");
	//세션 무효화
	session.invalidate();
	response.sendRedirect("http://localhost:8080/jsp_prj/day0312/use_session.html");
%>
