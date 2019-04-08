<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name="김정윤";
	int age=30;
	//JSONObject 생성
	JSONObject json=new JSONObject();
	//값 할당
	json.put("name", name);
	json.put("age",age);
	
	out.println(json.toJSONString());
%>
