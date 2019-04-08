<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyBatisService mbs = new MyBatisService();
	String dname=mbs.deptName();
%>
10번 부서는 <strong><%=dname %></strong>입니다.