<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v190130.css"/>
<style type="text/css">
/* wrap에 background-color를 넣고 header, container, footer에도 background-color를 넣어 가려지는지 확인 */
#wrap{margin:0px auto; width:800px; height:860px;}
/* wrap안쪽 디자인들은 wrap안에 들어있기 때문에 width안줘도 자동으로 800이 됨 */
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}

#diary{margin-top:20px;}
#diaryHeader{font-size:19px; font-weight:bold; text-align:center; height:40px}
#diaryContents{height: 400px;}
#diaryIndexList{height: 30px;}
#diarySearch{height: 400px; text-align:center;}

#listTab{border-top:2px solid #3C4790; border-spacing: 0px}
#numTitle{width:50px; height:25px; background-color:#F3F3F3}
#subjectTitle{width:350px; height:25px; background-color:#F3F3F3}
#writerTitle{width:120px; height:25px; background-color:#F3F3F3}
#evtDayTitle{width:150px; height:25px; background-color:#F3F3F3}
#wriDayTitle{width:150px; height:25px; background-color:#F3F3F3}
tr,td{border-bottom: 1px solid #EEEEEE;}
td{height:27px;}
tr:HOVER{background-color:#F3F3F3}
.center{text-align:center;}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4 </div>
		<div style="padding-top: 100px">
			<c:import url="../common/jsp/main_menu.jsp"/>
		</div>
	</div>
	
	<div id="container">
	
	<div id="diary">
	<div id="diaryHeader">이벤트 리스트</div>
	<div id="diaryContents">
		<table id="listTab">
		<tr>
			<th id="numTitle">번호</th>
			<th id="subjectTitle">이벤트 제목</th>
			<th id="writerTitle">작성자</th>
			<th id="evtDayTitle">이벤트일자</th>
			<th id="wriDayTitle">작성일자</th>
		</tr>
		<tr>
			<td class="center">1</td>
			<td class="center">오늘은 금요일</td>
			<td class="center">노진경</td>
			<td class="center">2019-03-22</td>
			<td class="center">2019-03-22</td>
		</tr>
		<tr>
			<td class="center">2</td>
			<td class="center">오늘은 금요일 나는야 주 5일제 월화수목금금금</td>
			<td class="center">주 52간의 사나이</td>
			<td class="center">2019-03-22</td>
			<td class="center">2019-03-22</td>
		</tr>
		</table>
	</div>
	<div id="diaryIndexList">
	
	</div>
	<div id="diarySearch">
	<form action="list.jsp" method="post" id="searchFrm" name="searchFrm">
		<select name="fieldName" class="inputBox" id="fieldName">
			<option value="subject">제목</option>	
			<option value="contents">내용</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="keyword" class="inputBox"
			style="width:250px"/>
		<input type="button" value="검색" class="btn" id="btn"/>
	</form>
	</div>
	</div>
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>