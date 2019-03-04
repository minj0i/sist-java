package day0227;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTML Form Control의 값 받기
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWebParameter extends HttpServlet {
//	public String encoding() {
//		return"";
//	}
	//파일의 이름은 있으나 요청방식의 처리 메소드가 잘못 정의 되어있을 때: 405 Error (Get으로 불렀는데 Post가 있거나 등등..)
	//웹사이트들은 에러페이지를 따로 만들어서 그걸 띄어줌
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	      out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	      out.write("\t\t\tposition: relative; }\r\n");
	      out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	      out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	      out.write("#container{  width:800px; height: 600px; }\r\n");
	      out.write("#footer{  width:800px; height: 120px; }\r\n");
	      out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div\tid=\"wrap\">\r\n");
	      out.write("\t<div id=\"header\">\r\n");
	      out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"container\">\r\n");
	      
	      //parameter값 받기 : Tomcat 8.0부터는 GET방식의 Parameter는 한글이 깨지지 않는다.
	      //parameter값과 변수명은 달라도 됨
	      String name=request.getParameter("name");//text
	      String age=request.getParameter("age");//password
	      String mailing=request.getParameter("mailing");//checkbox지만 한개
	      String gender=request.getParameter("gender");//radio
	      String addr=request.getParameter("addr");//hidden
	      String email=request.getParameter("email");//select
	      String greeting=request.getParameter("greeting");//textarea
	      
	      out.print("\t<div>");
	      out.print("\t<h2> GET방식으로 요청한 파라메터 값 처리</h2>");
	      out.print("\t<div>");
	      out.println("\t<ul>");
	      
	      out.print("\t<li>이름:<strong>");
//	      out.print(HangulConv.toUTF(name)); Tomcat이 8.x 이하일때는 한글처리를 해야한다. 항목마다 다 해줘야 함
	      out.print(name);
	      out.print("</strong></li>");
	      
	      out.print("\t<li>나이:<strong>");
	      out.print(age);
	      out.print("</strong></li>");
	      
	      out.print("\t<li>메일링 여부:<strong>");
	      out.print(mailing); //체크되면 on, 체크되지 않으면 null
	      out.print("</strong></li>");
	      
	      out.print("\t<li>성별:<strong>");
	      out.print(gender);
	      out.print("</strong></li>");
	      
	      out.print("\t<li>주소:<strong>");
	      out.print(addr);
	      out.print("</strong></li>");
	      
	      out.print("\t<li>이메일:<strong>");
	      out.print(email);
	      out.print("</strong></li>");
	      
	      out.print("\t<li>가입인사:<strong>");
	      out.print(greeting);
	      out.print("</strong></li>");
	      
	      out.println("\t</ul>");
	      out.print("\t</div>");
	      out.print("\t<a href='day0227/test_param.html'>뒤로</a>");
	      out.print("\t</div>");
	     
	      
	      out.write("\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"footer\">\r\n");
	      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
		
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST방식의 한글 처리 (Tomcat 모든 버전에 동일하게 적용).
	    //객체가 제공하는 method를 사용하기 전에 코딩해야 한다.
		//눈에 잘띄는 곳에 넣기
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset='\"UTF-8\"'>\r\n");
	    out.write("<title>Insert title here</title>\r\n");
	    out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
	    out.write("<style type=\"text/css\">\r\n");
	    out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	    out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	    out.write("\t\t\tposition: relative; }\r\n");
	    out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	    out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	    out.write("#container{  width:800px; height: 600px; }\r\n");
	    out.write("#footer{  width:800px; height: 120px; }\r\n");
	    out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	    out.write("</style>\r\n");
	    out.write("</head>\r\n");
	    out.write("<body>\r\n");
	    out.write("<div\tid=\"wrap\">\r\n");
	    out.write("\t<div id=\"header\">\r\n");
	    out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	    out.write("\t</div>\r\n");
	    out.write("\t<div id=\"container\">\r\n");
	     
      //parameter값 받기 : Tomcat 8.0부터는 GET방식의 Parameter는 한글이 깨지지 않는다.
      //parameter값과 변수명은 달라도 됨
      String name=request.getParameter("name");//text
      String age=request.getParameter("age");//password
      String mailing=request.getParameter("mailing");//checkbox지만 한개
      String gender=request.getParameter("gender");//radio
      String addr=request.getParameter("addr");//hidden
      String email=request.getParameter("email");//select
      String greeting=request.getParameter("greeting");//textarea
	      
      out.print("\t<div>");
      out.print("\t<h2 style='color:#0000FF'> POST방식으로 요청한 파라메터 값 처리</h2>");
      out.print("\t<div>");
      out.println("\t<ul>");
      
      out.print("\t<li>이름:<strong>");
      out.print(name);
      out.print("</strong></li>");
      
      out.print("\t<li>나이:<strong>");
      out.print(age);
      out.print("</strong></li>");
      
      out.print("\t<li>메일링 여부:<strong>");
      out.print(mailing); //체크되면 on, 체크되지 않으면 null
      out.print("</strong></li>");
      
      out.print("\t<li>성별:<strong>");
      out.print(gender);
      out.print("</strong></li>");
      
      out.print("\t<li>주소:<strong>");
      out.print(addr);
      out.print("</strong></li>");
      
      out.print("\t<li>이메일:<strong>");
      out.print(email);
      out.print("</strong></li>");
      
      out.print("\t<li>가입인사:<strong>");
      out.print(greeting);
      out.print("</strong></li>");
      
      out.println("\t</ul>");
      out.print("\t</div>");
      out.print("\t<a href='day0227/test_param.html'>뒤로</a>");
      out.print("\t</div>");
     
      
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"footer\">\r\n");
      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
	
	}//doPost

}//class
