<%@page import="org.json.simple.JSONObject"%>
<%@page import="json0328.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String deptno=request.getParameter("deptno");
	if(deptno==null){
		deptno="20";
	}//end if
	
	int intDeptno=Integer.parseInt(deptno);
	JsonService js=new JsonService();
	JSONObject json_obj=js.searchEmpData(intDeptno);
	out.println(json_obj.toJSONString());
%>