<%@page import="org.jdom2.output.Format"
%><%@page import="org.jdom2.output.XMLOutputter"
%><%@page import="org.jdom2.Element"
%><%@page import="org.jdom2.Document"
%><%@ page language="java" contentType="text/xml; charset=UTF-8"   pageEncoding="UTF-8"%><%
String name=request.getParameter("name");
//HTML 응답.
String[] temp=null;
if("이봉현".equals(name)){
	temp="이재찬, 정택성, 백인재".split(",");
}else if("박영민".equals(name)){
	temp="최지우, 김정윤, 노진경, 김희철".split(",");
}else if("오영근".equals(name)){
	temp="공선의, 이재현".split(",");
}else{
	temp="김건하, 박소영".split(",");
}//end else
	
	//1. XML문서객체 생성
	Document xmlDoc = new Document();
	
	//2.최상위 노드 생성
	Element rootNode=new Element("names");
	
	//3.자식 노드 생성
	Element nameNode=null;
	
	for(int i=0; i<temp.length; i++){
		//자식 노드 생성
		nameNode=new Element("name");
		//자식노드에 값을 설정
		nameNode.setText(temp[i]);
		//4. 생성된 자식 노드를 부모노드에 추가
		rootNode.addContent(nameNode);
	}//end for
	//5.자식노드를 가진 부모노드를 문서노드에 추가
	xmlDoc.addContent(rootNode);
	//6.출력
	XMLOutputter x_out=new XMLOutputter(Format.getPrettyFormat());
	x_out.output(xmlDoc, out);		
%>