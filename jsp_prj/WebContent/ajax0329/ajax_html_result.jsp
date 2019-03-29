<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
%>
<table>
	<tr>
		<td width="80">번호</td>
		<td width="120">이름</td>
	</tr>
	<%
	for(int i=0; i<temp.length; i++){
	%>
	<tr>
		<td><%= i+1 %></td>
		<td><%= temp[i] %></td>
	</tr>
	<%
	}
	%>
</table>