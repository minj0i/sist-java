<%@page import="kr.co.sist.exam.domain.Zipcode"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MyBatisService1 mbs = new MyBatisService1();

String dong=request.getParameter("dong");
	
	if(dong!=null){
		List<Zipcode> list=mbs.like(dong);
		pageContext.setAttribute("zipList", list);
	}//end if
%>
<form name="frm" action="main.jsp">
<input type="hidden" name="page" value="day0405/like"/>
<label>동</label>
<input type="text" name="dong" class="inputBox"/>
<input type="submit" value="조회" class="btn"/><br/>
예) 상도동, 역삼동
</form>
<div>
<c:if test="${not empty param.dong}">
<div>
	${param.dong}의 조회
</div>
	<table border="1">
		<tr>
			<th width="80">우편번호</th>
			<th width="400">주소</th>
		</tr>
		<c:if test="${empty zipList}">
		<tr>
			<td colspan="2" align="center">
			<strong>${param.dong}</strong>은 존재하지 않습니다.</td>
		</tr>
		</c:if>
		<c:forEach var="zip" items="${zipList }">
			<tr>
				<td><a href="#void" onclick="setMarker('${zip.sido} ${zip.gugun} ${zip.dong}','${zip.dong}')"><c:out value="${zip.zipcode}"/></a></td>
				<td><a href="#void" onclick="setMarker('${zip.sido} ${zip.gugun} ${zip.dong}','${zip.dong}')"><c:out value="${zip.sido} ${zip.gugun} ${zip.dong} ${zip.bunji}"/></a></td>
				<%-- <td><c:out value="${zip.sido} ${zip.gugun} ${zip.dong} ${zip.bunji}" /></td> --%>
			</tr>
		</c:forEach>
	</table>
</c:if>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8b857dc566b8eab149bd0974724f3d9d&libraries=services"></script>
<script type="text/javascript">

var mapContainer = null;
var mapOption = null;
$(function(){
/* var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  
var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴 */
mapContainer = document.getElementById("map"),//지도를 표시할 div
mapOption = {
    center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

setMarker("서울시 동작구 상도동", "살기 좋은 상도동")

});//function  

function setMarker(addr, dong){
//지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

//주소로 좌표를 검색합니다
geocoder.addressSearch(addr, function(result, status) {

// 정상적으로 검색이 완료됐으면 
 if (status === daum.maps.services.Status.OK) {

    var coords = new daum.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new daum.maps.Marker({
        map: map,
        position: coords
    });

    // 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new daum.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0;">'+dong+'</div>'
    });
    infowindow.open(map, marker);

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
	}//end if
});//addressSearch
}//setMarker
</script>

<div id="map" style="width:500px;height:400px;"></div>

</div>