package day0228;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WhySessionB extends HttpServlet {
	private Map<String, String> loginMap;//한번만 생성
	
	public void init() {
		loginMap=new HashMap<String,String>();
		loginMap.put("kong", "공선의");
		loginMap.put("rho", "노진경");
		loginMap.put("kim", "김희철");
		loginMap.put("lee", "이재찬");
		
	}//init
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
				
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

	      //사용자가 입력한 값을 받기
	      String id=request.getParameter("id");
	      String pass=request.getParameter("pass");
	      
	      if(loginMap.containsKey(id) && "1234".equals(pass)) {
	    	  String name=loginMap.get(id);//지역변수이기때문에 이름값을 받아올 수 없다..!
	    	  out.println("<div>");
	    	  out.print("<strong>");
	    	  out.print(id);
	    	  out.print("</strong>(");
	    	  out.print(name);
	    	  out.println(")님 로그인 하셨습니다.<br/>");
//	    	  out.println("작업페이지로<a href='why_session_c?name="+name+">이동</a>");
	    	  out.println("작업페이지로<a href='why_session_c'>이동</a>");
	    	  out.println("</div>");
	      }else {
	    	  out.println("아이디나 비밀번호를 확인해 주세요.");
	    	  out.println("<a href='#void' onclick='history.back();'>로그인</a>");
	    	  
	      }//end else
	      
	      
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
