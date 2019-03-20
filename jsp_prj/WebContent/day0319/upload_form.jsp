<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파일 업로드 폼"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto; width:800px; height:860px;}
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		if($("#uploader").val()==""){
			$("#uploader").focus();
			return;
		}//end if
		if($("#upfile").val()==""){
			alert("업로드할 파일을 선택해 주세요.");
			return;
		}//end if
		
		//확장자가 jsp, java,class, xml은 업로드하지 못하도록 막는다.
		var ext=["jsp", "java", "class", "xml"];
		var flag=false;
		/*
		var fileName=$("#upfile").val();
		var inputExt = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		*/
		var fileName=$("#upfile").val().split(".");
		var inputExt = fileName[fileName.length-1].toLowerCase();
		
		for(var i=0; i<ext.length; i++){
			if(ext[i]==inputExt){
				flag=true;
				break;
			}//end if
		}//end if
		if(!flag){
			alert("업로드 정책에 위배되는 파일확장자입니다.");
			return;
		}
		<%-- <% String[] ext = {".jsp", ".java", ".class", ".xml"};
		for(int i=0; i<ext.length; i++){
		%>
		if($("#upfile").val().substring($("#upfile").val().lastIndexOf("."))=="<%= ext[i]%>"){
			alert("안돼요!!");
			return;
		}
		<%
		}//end for
		%> --%>
		$("#uploadFrm").submit();
	});//click
});//ready

</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
	</div>
	
	<div id="container">
	<!-- enctype="multipart/form-data"인 경우 parameter를 받을 수 없다. -->
	<!-- HTML 폼기반의 파일 업로드
		1. enctype="multipart/from-data"
		2. method="post"
	-->
	<a href="file_list.jsp">파일리스트</a><br/>
	<!-- <form action=upload_process.jsp" id="uploadFrm" method="post" enctype="application/x-www-form-urlencoder"> -->
	<form action="upload_process.jsp" id="uploadFrm" method="post" enctype="multipart/form-data"> <!-- multipart/form-data인경우엔 get으로 못함  -->
	<label>업로더</label>
	<input type="text" name="uploader" class="inputBox" id="uploader"/><br/>
	<label>나이</label>
	<select name="age" id="age">
	<c:forEach var="i" begin="10" end="80" step="10">
	<option value="${i}"><c:out value="${i}"/></option>
	</c:forEach>
	</select>
	<br/>
	<label>파일</label>
	<input type="file" name="upfile" class="inputBox" style="width:200px" id="upfile"/>
	<input type="button" value="업로드" class="btn" id="btn"/>
	</form>
<%-- 	<%=
		System.getProperties()
	%> --%>
	</div>
	
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>