<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto;width:800px; height:860px;}
#header{width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
      position: relative; }
#headerTitle{font-family: HY견고딕,고딕; font-size:35px; font-weight:bold; text-align:center; 
         /* padding-top: 35px */ position:absolute; top:40px; left:290px; }
#container{width:800px; min-height: 600px; }
#footer{width:800px; height:120px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(function(){
    $(".btn").click(function(){
       $.ajax({
          url:"ajax_process.do",
          dataType:"JSON",
          type:"GET",
          error:function(xhr){
             alert("문제 발생"+xhr.status);
          },
          success:function(json_obj){
             //alert(json_obj);
             var output="<img src='http://localhost:8080/spring_mvc/common/images/img1_1.png'><br/>"
                      +decodeURI(json_obj.name)+"/"+json_obj.age+"세 ("+decodeURI(json_obj.type)+")";
             
             $("#view").html(output);
          }
       });//ajax
    });//click
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
      <input type="button" value="ajax요청" class="btn"/>
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