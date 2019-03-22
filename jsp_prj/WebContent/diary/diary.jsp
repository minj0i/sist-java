<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Arrays"%>
<%@page import="kr.co.sist.diary.vo.MonthVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
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
/* 달력 설정  */
#diaryTab{margin:0px auto; border-spacing:0px; border:1px solid #CECECE}
#diaryContent{position:relative;}
#diaryJob{position:absolute; top:30px; left:160px; }
.sunTitle{text-align:center; width:100px; height:25px; border:1px solid #CECECE; font-weight:bold; color:#FFFFFF; background-color:#b71540 ;}
.weekTitle{text-align:center; width:100px; height:25px; border:1px solid #CECECE}
.satTitle{text-align:center; width:100px; height:25px; border:1px solid #CECECE; font-weight:bold; color:#FFFFFF; background-color:#6a89cc ;}
#diaryTitle{text-align:center; margin-bottom:10px; margin-top:20px;}
#diaryToday{width:100px; font-family:고딕체; font-size:28px; font-weight:bold; vertical-align:bottom;}
.diaryTd{width:100px; height:60px; border:1px solid #CECECE; text-align:right; vertical-align: top; font-size:14px; font-weight:bold;}
.todayTd{width:100px; height:60px; border:1px solid #d7e2e9; background-color:#e9f4fb; text-align:right; vertical-align: top; font-size:14px; font-weight:bold;}
.blankTd{width:100px; height:60px; border:1px solid #CECECE; color:#CCCCCC;  text-align:right; vertical-align: top; font-size:14px; font-weight:bold;}
.sunColor{font-weight:bold; font-size:15px; color:#b71540;}
.weekColor{color:#222222;}
.satColor{font-size:15px; color:#141744;}

#writeFrm{background-color:#FFFFFF; border:1px solid #5C5C5C;
		box-shadow: 5px 5px 5px #444444;
		padding:10px}
#readFrm{background-color:#FBFBFB; border:1px solid #0F143C;
		box-shadow: 5px 5px 5px #1C2E6B;
		padding:10px}
		
/* 달력 설정  끝*/
</style>
<!-- summernote 관련 library 시작 -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="../common/summernote/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../common/summernote/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="../common/summernote/summernote-lite.css" rel="stylesheet">
<script src="../common/summernote/summernote-lite.min.js"></script>
<script src="../common/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
/* $(document).ready(function() { */
$(function() {
	$('#summernote').summernote({
       placeholder: '이벤트를 작성해 주세요',
       tabsize: 2,
       height: 150,
       width: 390,
       lang: 'ko-KR'
    });
});//ready

</script>
<!-- summernote 관련 library 끝 -->
<!-- Tooltip 시작 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="../common/js/jquery-ui.js"></script>
  <script>
  $(function() {
    $(document).tooltip1({
      position: {
        my: "center bottom-20",
        at: "center top",
        using: function( position, feedback ) {
          $( this ).css( position );
          $( "<div>" )
            .addClass( "arrow" )
            .addClass( feedback.vertical )
            .addClass( feedback.horizontal )
            .appendTo( this );
        }
      }
    });
  } );
  </script>
   <style>
  .ui-tooltip, .arrow:after {
    background: white;
    border: 2px solid white;
  }
  .ui-tooltip {
    padding: 10px 20px;
    color: black;
    border-radius: 20px;
    font: bold 14px "Helvetica Neue", Sans-Serif;
    text-transform: uppercase;
    box-shadow: 0 0 7px black;
  }
  .arrow {
    width: 70px;
    height: 16px;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -35px;
    bottom: -16px;
  }
  .arrow.top {
    top: -16px;
    bottom: auto;
  }
  .arrow.left {
    left: 20%;
  }
  .arrow:after {
    content: "";
    position: absolute;
    left: 20px;
    top: -20px;
    width: 25px;
    height: 25px;
    box-shadow: 6px 5px 9px -9px black;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
  }
  .arrow.top:after {
    bottom: -20px;
    top: auto;
  }
  </style>
  
<script type="text/javascript">
	function moveMonth(month, year){
		/* location.href="diary.jsp?param_year="+year+"&param_month="+month; */
		/* var obj=document.diaryFrm;
		obj.param_month.value=month;
		obj.param_year.value=year;
		obj.submit(); */
		
		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='diaryFrm']").submit();
	}//moveMonth
</script>

<script type="text/javascript">

$(function(){
	$("#btnCloseFrm").click(function(){
		//location.href="diary.jsp?param_year=${param.param_year}&param_month=${param.param_month}";
		moveMonth("${param.param_month}","${param.param_year}");
	});//click
	$("#btnWriteFrm").click(function(){
		//location.href="diary.jsp?param_year=${param.param_year}&param_month=${param.param_month}";
		moveMonth("${param.param_month}","${param.param_year}");
	});//click
	
	//글작성 처리	
	$("#btnWrite").click(function(){
		if($("#subject").val()==""){
			alert("이벤트 제목은 필수입력!!!!");
			$("#subject").focus();
			return;
		}//end if
		if($("#summernote").val()==""){
			alert("이벤트 내용은 필수입력!!!!");
			$("#summernote").focus();
			return;
		}//end if
		if($("#writer").val()==""){
			alert("작성자는 필수입력!!!!");
			$("#writer").focus();
			return;
		}//end if
		if($("#pass").val()==""){
			alert("비밀번호는 필수입력!!!!");
			$("#pass").focus();
			return;
		}//end if
		$("[name='writeFrm']").submit();
		});//click
		
		$("#btnUpdate").click(function(){
			if($("#summernote").val()==""){
				alert("이벤트 내용은 필수입력!!!!");
				$("#summernote").focus();
				return;
			}//end if
			if($("#pass").val()==""){
				alert("비밀번호는 필수입력!!!!");
				$("#pass").focus();
				return;
			}//end if
			
			$("[name='pageFlag']").val("update_process");
			$("[name='readFrm']").submit();
			
		});//click
		$("#btnRemove").click(function(){
			if($("#pass").val()==""){
				alert("비밀번호는 필수입력!!!!");
				$("#pass").focus();
				return;
			}//end if
			
			$("[name='pageFlag']").val("delete_process");
			$("[name='readFrm']").submit();
		});//click
});//ready

function writeEvt(year, month, day, pageFlag, evtCnt){
	if(evtCnt>4){
			alert("하루에 5건까지만 작성 가능합니다");
			return;
	}//end if

	$("[name='param_year']").val(year);
	$("[name='param_month']").val(month);
	$("[name='param_day']").val(day);
	$("[name='pageFlag']").val(pageFlag);
	$("[name='diaryFrm']").submit();
}//writeEvt

function readEvt(num, year, month, day){
	$("[name='param_year']").val(year);
	$("[name='param_month']").val(month);
	$("[name='param_day']").val(day);
	$("[name='pageFlag']").val("read_form");
	$("[name='num']").val(num);
	$("[name='diaryFrm']").submit();
	
}//read Evt

</script>
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
	<div id= "diaryWrap">
	<%! //declaration
		public static final int START_DAY=1;	
	%>
	<%
		Calendar cal = Calendar.getInstance();
	//오늘 설정
		StringBuilder todate=new StringBuilder();
		todate.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)+1).append(cal.get(Calendar.DATE));
		
		int nowYear=0;
		int nowMonth=0;
		int nowDay=cal.get(Calendar.DAY_OF_MONTH);
		
		//사람 : 1 2 3 4 5
		//자바 : 0 1 2 3 4
		String param_month=request.getParameter("param_month");
		cal.set(Calendar.DAY_OF_MONTH,1);//요청했을 때 해당 달에 없는 날이 존재한다면
		//다음달 1일로 넘어가버리므로 무조건 1일로 세팅한다
		if(param_month!=null &&  !"".equals(param_month)){//파라메터 월이 존재하면 현재 캘린더 객체의 월을 변경
			cal.set(Calendar.MONTH, Integer.parseInt(param_month)-1);
		}//end if
		nowMonth=cal.get(Calendar.MONTH)+1;
		
		String param_year=request.getParameter("param_year");
		if(param_year!=null &&  !"".equals(param_year)){//파라메터 년이 존재하면 현재 캘린더 객체의 년을 변경
			cal.set(Calendar.YEAR, Integer.parseInt(param_year));
		}//end if
		nowYear=cal.get(Calendar.YEAR);
		
		boolean toDayFlag=false;//오늘인 경우에만 표시하고, 다음달의 오늘 날짜는 표시하지 않게 하기 위해서
		StringBuilder nowDate = new StringBuilder();
		nowDate.append(nowYear).append(nowMonth).append(nowDay);
		
		if(todate.toString().equals(nowDate.toString())){//주소가 같은지를 물어보는 equals
			toDayFlag = true;			
		}//end if
		//log(todate+"/"+nowDate+"/"+toDayFlag);
		pageContext.setAttribute("nowYear", nowYear);
		pageContext.setAttribute("nowMonth", nowMonth);
		pageContext.setAttribute("nowDay", nowDay);
	%>
	
	<form action="diary.jsp" name="diaryFrm" method="post">
		<input type="hidden" name="num"/>
		<input type="hidden" name="param_month"/>
		<input type="hidden" name="param_year"/>
		<input type="hidden" name="param_day"/>
		<input type="hidden" name="pageFlag"/>
	</form>
		
	<div id="diaryTitle">
<%-- 	<a href="#diary.jsp?param_month=${nowMonth-1==0?12:nowMonth-1}&param_year=${nowMonth-1==0?nowYear-1 : nowYear}"><img src="images/btn_prev.png" title="이전 월"/></a> --%>
		<a href="#void" onclick="moveMonth(${nowMonth-1==0?12:nowMonth-1},${nowMonth-1==0?nowYear-1 : nowYear})"><img src="images/btn_prev.png" title="이전 월"/></a>
		<span id="diaryToday" title="${nowYear}년 ${nowMonth}월"><c:out value="${nowYear}"/>.<c:out value="${nowMonth}"/></span>
		<a href="#void" onclick="moveMonth(${nowMonth+1==13?1:nowMonth+1},${nowMonth+1==13?nowYear+1:nowYear})"><img src="images/btn_next.png" title="다음 월"/></a>
		<!-- <a href="diary.jsp"><img src="images/btn_today.png" title="오늘"/></a> -->
		<a href="#void" onclick="moveMonth('','')"><img src="images/btn_today.png" title="오늘"/></a>
	</div>
	<div id="diaryContent">
	<table id="diaryTab">
	<tr>
		<th class="sunTitle">일</th>
		<th class="weekTitle">월</th>
		<th class="weekTitle">화</th>
		<th class="weekTitle">수</th>
		<th class="weekTitle">목</th>
		<th class="weekTitle">금</th>
		<th class="satTitle">토</th>
	</tr>
	<tr>
	<%
		String dayClass="";//요일별 색
		String todayClass="";//오늘이거나 평일의 Td색
		//요청되는 년, 월의 모든 이벤트를 조회
		DiaryDAO d_dao=DiaryDAO.getInstance();
		try{
		MonthVO[][] monthEvtData= d_dao.selectMonthEvent(String.valueOf(nowYear), String.valueOf(nowMonth));
		MonthVO[] dayEvt=null;//해당 일에 글이 존재한다면 저장할 배열
		
		String tempSubject="";//20자 이상인 제목을 잘라 ...을 붙이기 위해
		int evtCnt=0; //이벤트 건수를 제한하기 위해 
		
		//매월마다 끝나는 날짜가 다르기 때문에 무한 루프를 사용한다.
		for(int tempDay=1; tempDay<33; tempDay++){
			cal.set(Calendar.DAY_OF_MONTH, tempDay); //임시일자를 설정한다.
			/* out.println(cal.get(Calendar.DAY_OF_MONTH)+" / "+ tempDay+"<br/>"); */
			if(cal.get(Calendar.DAY_OF_MONTH)!=tempDay){
				//설정된 날짜가 현재 일자가 아니라면 마지막 일자 다음달 1일이므로 공백을 출력한 후
				//반복문을 빠져나간다.
				int week=cal.get(Calendar.DAY_OF_WEEK);
				if(week!=Calendar.SUNDAY){//마지막 일이 일요일이 아니면 출력
					int nextDay=1;
					int nextMonth=cal.get(Calendar.MONTH)+1;
					for(int blankTd = week; blankTd<8; blankTd++){
						%>
						<td class="blankTd"><div><%= nextMonth	%>/<%= nextDay %></div></td>
					<%
					nextDay++;
					}//end for
				}//end if
				break;
			}//end if
			
			//1일을 출력하기 전 공백 출력
			switch(tempDay){
			case START_DAY : 
				//전달의 마지막 날
				cal.set(Calendar.MONTH, nowMonth-2);
				int prevMonth=cal.get(Calendar.MONTH)+1; //이전 월
				int prevLastDay=cal.getActualMaximum(Calendar.DATE);//이전월의 마지막 일
			
				cal.set(Calendar.MONTH, nowMonth-1);
				//다시 현재 월로 변경하여 1일에 맞는 공백을 출력
				int week=cal.get(Calendar.DAY_OF_WEEK);
				
				for(int blankTd=1; blankTd<cal.get(Calendar.DAY_OF_WEEK); blankTd++){
				%>
				<td class="blankTd"><%= prevMonth %>/<%= prevLastDay-week+blankTd+1 %></td>
				<% 
				}//end for
			}//end switch	
			
			//요일별 색 설정
			switch(cal.get(Calendar.DAY_OF_WEEK)){
			case Calendar.SUNDAY: 			dayClass="sunColor";				break;
			case Calendar.SATURDAY:			dayClass="satColor";				break;
			default :dayClass="weekColor";
			}//end switch
			
			todayClass="diaryTd"; //평일의 CSS 설정
			//오늘이면 파란색
			if(toDayFlag){//요청한 년원일과 오늘의 년월일이 같다면 
				if(nowDay==tempDay){ //오늘일자에만 다른 CSS를 적용한다.
					todayClass="todayTd";
				}//end if
			}//end if
			%>
			<td class="<%= todayClass %>">
			<%
				dayEvt=monthEvtData[tempDay-1];
				evtCnt=0;
				if(dayEvt!=null){
					//해당 일자의 이벤트 건수를 저장
					evtCnt=dayEvt.length;
				}//end if
			%>
			<div>
			<a href="#void" onclick="writeEvt(${nowYear},${nowMonth},<%=tempDay%>,'write_form',<%= evtCnt %>)"><span class="<%= dayClass%>">
				<%= tempDay %></span></a>
				</div>
				<div>
				<%if(dayEvt!=null){ 
					for(int i=0; i<dayEvt.length; i++){
					tempSubject=dayEvt[i].getSubject();
					if(tempSubject.length()>21){
						tempSubject=tempSubject.substring(0,20)+"...";
					}
				%> 
				<a href="#void" onclick="readEvt(<%= dayEvt[i].getNum()
				%>, ${nowYear},${nowMonth},<%=tempDay%>)"><img src="images/evtflag.png" title="<%=tempSubject%>"/></a>
				<% 
					}//end for
				}//end if
				%>
				</div>
			</td>
			<%
			//토요일이면 줄 변경
			switch(cal.get(Calendar.DAY_OF_WEEK)){
			case Calendar.SATURDAY :
				out.println("</tr><tr>");
			}//end switch
		}//end for
	}catch(SQLException se){
		se.printStackTrace();
		%>
		<tr>
			<td colspan="7" style="text-align:cetner; height:400px">
			<img src="images/construction.jpg" title="뎨둉T_T"/>
			</td>
		</tr>
		<% 
	}//end catch
		%>
	</table>
	
	<div id="diaryJob">
		<c:if test="${not empty param.pageFlag }">
			<c:import url="${ param.pageFlag }.jsp"/>
		</c:if>
	</div>
	
	</div>
	
	</div>
	
	</div>
	
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>