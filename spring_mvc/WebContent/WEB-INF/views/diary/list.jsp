<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto; width:800px; height:860px;}
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; min-height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}

#diary{margin-top:20px;}
#diaryHeader{font-size:19px; font-weight:bold; text-align:center; height:40px}
#diaryContents{min-height: 450px; }
#diaryIndexList{height: 30px; text-align:center;}
#diarySearch{height: 400px; text-align:center;}

#listTab{border-top:2px solid #3C4790; border-spacing: 0px}
#numTitle{width:50px; height:25px; background-color:#F3F3F3}
#subjectTitle{width:350px; height:25px; background-color:#F3F3F3}
#writerTitle{width:120px; height:25px; background-color:#F3F3F3}
#evtDayTitle{width:150px; height:25px; background-color:#F3F3F3}
#wriDayTitle{width:150px; height:25px; background-color:#F3F3F3}
tr,td{border-bottom: 1px solid #EEEEEE;}
td{height:27px; text-align:center;}
tr:HOVER{background-color:#F3F3F3}
.center{text-align:center;}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(function(){
	 
 });//ready
</script>
</head>
<body>
<div id="wrap">
   <div id="header">
      <div id="headerTitle">SIST Class4</div>
      <div style="padding-top:100px; ">
      <c:import url="/common/jsp/main_menu.jsp"></c:import>
      </div>
   </div>
   <div id="container">
   <div>
   <div id="diary">
	<div id="diaryHeader">
	<span style="float:left"><a href="list.do"><img src="/spring_mvc/common/images/btn_all.png"/></a></span>
	이벤트 리스트
	</div>
	<div id="diaryContents" style="height:450px">
		<table id="listTab">
		<tr>
			<th id="numTitle">번호</th>
			<th id="subjectTitle">이벤트 제목</th>
			<th id="writerTitle">작성자</th>
			<th id="evtDayTitle">이벤트일자</th>
			<th id="wriDayTitle">작성일자</th>
		</tr>
	
		<c:if test="${not empty e}">
		<tr>
			<td colspan="5">서비스가 원활하지 못합니다. 뎨둉</td>
		</tr>
		</c:if>
		<c:if test="${empty diaryList}">
		<tr>
		<td colspan="5">이벤트가 존재하지 않습니다.<br/>
			<a href="diary.jsp">이벤트 작성하러 고고</a>
		</td>
		</tr>
		</c:if>
		<c:forEach var="data" items="${diaryList}">
		<c:set var="i" value="${i+1}"/>
		<tr>
			<td><c:out value="${(totalCount-(currentPage-1)*pageScale-i)+1}"/></td>
			<td><a href="bbs_read.do?num=${data.num }"><c:out value="${data.subject}"/></a></td>
			<td><c:out value="${data.writer}"/></td>
			<td><c:out value="${data.e_year}-${data.e_month}-${data.e_day}"/></td>
			<td><c:out value="${data.w_date}"/></td>
		</tr>
		</c:forEach>
		</table>
	</div>
	<div id="diaryIndexList" style="text-align:center">
	<!-- escapeXml="false" c:out으로 태그를 출력할 때 -->
	<c:out value="${indexList}" escapeXml="false"/>
	</div>
   </div>
   </div>
   <div id="view">
      
   </div>
   </div>
   <div id="footer">
      <div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
   </div>
</div>
</body>
</html>