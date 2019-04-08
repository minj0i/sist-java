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
#wrap{margin:0px auto; width:800px; height:860px;}
#header{width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position:relative;}
#headerTitle{ font-family: HY견고딕, 고딕; font-size:35px; font-weight:bold; text-align:center;
			position:absolute; top:40px; left:290px;}
#container{width:800px; min-height:600px;}
#footer{width:800px; height:120px;}
#footerTitle{float:right; font-size:15px; padding-top:20px; padding-right:20px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			var deptno=$("#deptno").val();
			if(deptno==""){
				alert("부서번호는 필수 입력!!");
				$("#deptno").focus();
				return;
			}//end if
			
			$.ajax({
				url:"json_db.jsp",
				type:"post",
				data:"deptno="+deptno,
				dataType:"json",
				error:function(xhr){
					alert(xhr.status+" "+xhr.statusText);
				},
				success:function(json_obj){
					
					var result=json_obj.result;
					if(result){
						//alert("검색 데이터 존재");
						var output="<strong>"+deptno+"<strong>번 부서사원 조회 결과<br/>";
						
						var json_arr=json_obj.resultData;
						
						$.each(json_arr,function(idx,jsonEmpData){
							output+="<div style='margin-bottom:10px'>"
									+"<table border='1'><tr><td width='80'>사원번호</td><td width='100'>"						
									+jsonEmpData.empno+"</td><td width='120'>사원명</td><td width='120'>"
									+jsonEmpData.ename+"</td><td width='80'>입사일</td><td width='150'>"
									+jsonEmpData.hiredate+"</td></tr>"
									+"<tr><td width='80'>연봉</td><td width='150'>"
									+"<input type='text' name='sal' value='"
									+jsonEmpData.sal+"'/></td><td width='80'>직무</td><td colspan='3'>"
									+"<input type='text' name='job' value='"
									+jsonEmpData.job+"'/></td></tr></table></div>";
						});
						output+="데이터 생성 일자: "+json_obj.pubData;
						$("#empView").html(output);
					}else{
						var img="<img src='../common/images/sist_logo.jpg'><br/>부서에 사원정보가 존재하지 않습니다 ";
						$("#empView").html(img);
					}//end else
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
			<c:import url="../common/jsp/main_menu.jsp"/>
		</div>
	</div>
	
	<div id="container">
	<div>
		 <label>부서번호:</label>
		 <input type="text" name="deptno" id="deptno" class="inputBox"/>
		 <input type="button" value="사원조회" id="btn" class="btn"/>
	</div>
	<div id="empView">
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle"> copyright&copy; all right reserved class4 </div>
	</div>
</div>
</body>
</html>