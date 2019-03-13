<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="localhost또는 ip를 식별하여 다른 언어를 사용하는 페이지로 이동하는 일"
%>
<!--html 내용을 가지지 않고 이동하는 표시만 -->
<!--scriptlet에서는 javacode만 가능 -->
<%
	request.setCharacterEncoding("UTF-8");
	String ip=request.getRemoteAddr();
	String lang="English";
	String url="eng.jsp";
	
	String[]loc={"서울","경기","강원","충청","경상","전라","제주"};
	request.setAttribute("loc", loc);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	if("0:0:0:0:0:0:0:1".equals(ip)){//한국어 페이지로 이동
		url="kor.jsp";
		lang="한국어";
	}//end if
%>
<%--이 페이지에서 생산한 파라메터가 없을 때
 <jsp:forward page="<%=url %>"/> --%>
<!--이 페이지에서 생산할 파라메터가 있을 때 // html주석이 forward tag안으로 들어가면 에러남-->
<jsp:forward page="<%=url %>">
	<jsp:param value="<%=lang %>" name="lang"/>
	<jsp:param value="<%=sdf.format(new Date()) %>" name="date"/>
</jsp:forward>

<%-- <jsp:forward page="kor.jsp"/>	
<%	}else{//영어 페이지로 이동%>
<jsp:forward page="eng.jsp"/> 
<%
	}//end else
%>--%>
