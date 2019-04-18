<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto; width:800px; height:860px;}
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/spring_mvc/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; min-height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}
#reply{display:none}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
$(function(){
	$("#replyView").click(function(){
		var txt=$("#replyView").text();
		if(txt=="열기"){
			txt="접기";	
		}else{
			txt="열기";
		}//end if
		$("#replyView").text(txt);	
		$("#reply").toggle();	
	});//click
	
	$(".btn").click(function(){
		var writer = $("[name='writer']").val();
		if(writer==""){
			alert("작성자는 필수 입력!!!");
			$("[name='writer']").focus();
			return;
		}//end if
		var reply=$("[name='reply']").val();
		if(reply==""){
			alert("내용은 필수 입력!!!");
			$("[name='reply']").focus();
			return;
		}//end if
		
		var queryString="num_ref="+$("[name='num_ref']").val()+"&content="+reply+"&writer="+writer;
		$.ajax({
			url:"add_reply.do",
			data:queryString,
			type:"GET",
			dataType:"json",
			error:function(xhr){
				alert("댓글 작성 실패");
				console.log(xhr.status+"/"+xhr.statusText);
			},//error
			success:function(json){
				if(json.result){
					//<div>의 자식 노드로 작성한 값을 추가(append)
					//자식 노드 전에 추가 (prepend())
					var date=new Date();
					var output="<div style='border:1px solid #dfdfdf; width:600px; margin-bottom:3px;'>"
					+reply+"<br/>"+writer+"("+date.getFullYear()+"-"+(date.getMonth()+1)+"-"+
							date.getDate()+" "+date.getHours()+":"+date.getMinutes()+")</div>";
					
					$("#reply").prepend(output);
					$("[name='writer']").val("");
					$("[name='reply']").val("");
					
					alert("댓글이 정상적으로 등록되었습니다.");
				}//end if
			}//success
		});//ajax
		
	});//click
});//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
		<div style="padding-top:100px">
			<c:import url="/common/jsp/main_menu.jsp"/>
		</div>
	</div>
	
	<div id="container">
	<div id="readFrm">
<table id="readTab">
	 <tr>
		<th colspan="2" style="text-align:center">
			<span style="font-size:18px">이벤트 작성</span>
			<span style="float:right; padding-right:5px;">
			<!-- <a href="#void" id="btnCloseFrm"><img src="images/X.png"/></a> -->
			</span>
		<th>
	</tr> 
	<tr>
		<td style="width:80px">제목</td>
		<td style="width:400px">
			<div id="subject"><strong>${searchData.subject}</strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px">내용</td>
		<td style="width:400px">${searchData.contents}</td>
	</tr>
	<tr>
		<td style="width:80px">작성자</td>
		<td style="width:400px">
			<div id="writer"><strong>${searchData.writer}</strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px">작성일</td>
		<td style="width:400px">
			<div id="wDate"><strong>${searchData.w_date}</strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px">작성IP</td>
		<td style="width:400px">
			<div id="ip"><strong>${searchData.ip}</strong></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href="#void" onclick="history.back()">리스트 보기</a>
		</td>
	</tr>
</table>
<table>
	<tr>
		<td>댓글</td>
		<td><input type="text" name="reply" class="inputBox" style="width:500px"/>
		</td>
		<td>
		<input type="text" name="writer" class="inputBox" placeholder="작성자"/>
		<input type="button" value="쓰기" class="btn"/>
		<input type="hidden" name="num_ref" value="${param.num}"/>
		</td>
	</tr>
</table>
<a href="#void" id="replyView">열기</a>
<div id="reply">
	<c:forEach var="reply" items="${replyList}">
	<div style="border:1px solid #dfdfdf; width:600px; margin-bottom:3px;">
		<c:out value="${reply.content}"/><br/>
		<c:out value="${reply.writer}"/>(<c:out value="${reply.input_date}"/>)<br/>
	</div>	
	</c:forEach>
</div>
</div>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>