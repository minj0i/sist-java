package day0305;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UseInitParameter extends HttpServlet {

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
	/////////////////////////////////////////////////////////////////////////////

	      //DD의 <init-param>에 설정된 값 얻기.
	      //1.ServeltConfig 얻기 (HttpServlet으로부터 얻는다.)
	      ServletConfig sc = getServletConfig();
	      //2. <init-param>의 값들을 얻기
	      Enumeration<String> en = sc.getInitParameterNames();
	      String nodeName="";
	      out.println("<ul>");
	      while(en.hasMoreElements()) {
	    	  nodeName=en.nextElement();
	    	  out.print("<li> 노드 명: <strong>");
	    	  out.print(nodeName);
	    	  out.print("</strong>  노드 값 : ");
	    	  out.print(sc.getInitParameter(nodeName));
	    	  out.println("</li>");
	      }//end while
	      out.println("</ul>");
	      out.println("<div style='width:300px; height:200px; border:1px solid #333'>");
	      //값 얻기
	      out.print("<marquee>");
	      out.print(sc.getInitParameter("name"));
	      out.println("</marquee>");
	      out.print("<strong>");
	      out.print(sc.getInitParameter("addr"));
	      out.println("</strong>");
	      out.print("<mark>");
	      out.print(sc.getInitParameter("birth"));
	      out.println("</mark><br/>");
	      
	      out.println("<a href='use_dd_param'>init-param정의하지 않은 서블릿</a>");
	      out.println("</div>");
	      
	/////////////////////////////////////////////////////////////////////////////
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

}//class
