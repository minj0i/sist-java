<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajax0401.WebMemeberService"%>
<%@page import="json0328.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	WebMemeberService wm_service=new WebMemeberService();
	JSONObject json=wm_service.searchId(id);
	out.println(json.toJSONString());
%>