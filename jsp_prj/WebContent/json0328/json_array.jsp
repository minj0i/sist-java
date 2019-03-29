<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] name_arr = {"김정윤", "김희철", "박영민", "노진경"};
	int[] age_arr = {30, 28, 27, 31};
	JSONArray json_arr=new JSONArray();
 	
	JSONObject json_obj=null;
	for(int i=0; i<name_arr.length; i++){
		//배열이 존재한다면 JSONObject을 생성한다.
		json_obj=new JSONObject();
		json_obj.put("name", name_arr[i]);
		json_obj.put("age", age_arr[i]);
		//순차적으로 존재하지 않기때문에 생성된 JSONObject을 JSONArray에 추가
		json_arr.add(json_obj);
	}//end for
	out.println(json_arr.toJSONString());
%>
[
<%
	for(int i=0; i<name_arr.length; i++){
		if(i!=0){
			out.println(",");
		}//end if
%>
	{"name":"<%= name_arr[i]%>","age":<%=age_arr[i] %>}
<%
	}//end for
%>
]