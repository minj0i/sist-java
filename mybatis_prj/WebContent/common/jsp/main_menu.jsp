<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- smartmenu 시작 -->
   <!-- SmartMenus core CSS (required) -->
   <link href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />
   
   <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
   <link href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
   
   <!-- jQuery -->
   <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 위에 있는 것으로 실행 할 거기 때문에-->

    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="http://localhost:8080/mybatis_prj/common/smartmenu/jquery.smartmenus.js"></script>

    <!-- SmartMenus jQuery init -->
    <script type="text/javascript">
       $(function() {
          $('#main-menu').smartmenus({
             subMenusSubOffsetX: 1,
             subMenusSubOffsetY: -8
          });
       });
    </script>
<!-- smartmenu 끝 -->
   	 <nav id="main-nav">
      <!-- Sample menu definition -->
      <ul id="main-menu" class="sm sm-simple">
        <li><a href="#void">홈으로</a></li>
        <li><a href="#void">쿼리실행</a>
          <ul>
            <li><a href="#void">1일차</a>
              <ul>
                <li><a href="main.jsp?page=day0404/single_column">컬럼하나에 레코드 하나</a></li>
                <li><a href="main.jsp?page=day0404/multi_column">컬럼여러개에 레코드 하나</a></li>
                <li><a href="main.jsp?page=day0404/multi_row">컬럼하나에 레코드 여러개</a></li>
              </ul>
            </li>
            <li><a href="#void">2일차</a>
              <ul>
                <li><a href="main.jsp?page=day0405/multi_column_row">컬럼 여러개 레코드 여러개</a></li>
                <li><a href="main.jsp?page=day0405/multi_param">where의 값이 여러개</a></li>
                <li><a href="main.jsp?page=day0405/lessthan">&lt;의 비교</a></li>
                <li><a href="main.jsp?page=day0405/greaterthan">>의 비교</a></li>
                <li><a href="main.jsp?page=day0405/like">like</a></li>
              </ul>
            </li>
            <li><a href="#void">3일차</a>
              <ul>
                <li><a href="main.jsp?page=day0408/subquery">subquery</a></li>
                <li><a href="main.jsp?page=day0408/union">union</a></li>
                <li><a href="main.jsp?page=day0408/join">join</a></li>
              </ul>
            </li>
          </ul>
        </li>
        </ul>
        </nav>
