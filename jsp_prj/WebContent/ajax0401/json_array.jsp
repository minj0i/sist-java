<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArr={"김희철","김정윤","노진경","공선의"};
	String[] addrArr={"서울시 동작구","서울시 역삼동","서울시 방화동","서울시 신정동"};
	int[] ageArr={30,28,31,29};
	
	
	JSONArray json_arr=new JSONArray();
	JSONObject json_obj=null;
	for(int i=0; i<nameArr.length; i++){
		//배열이 존재한다면 JSONObject을 생성한다.
		json_obj=new JSONObject();
		json_obj.put("name", nameArr[i]);
		json_obj.put("age", ageArr[i]);
		json_obj.put("addr",addrArr[i]);
		//순차적으로 존재하지 않기때문에 생성된 JSONObject을 JSONArray에 추가
		json_arr.add(json_obj);
	}//end for
	out.println(json_arr.toJSONString());
%>