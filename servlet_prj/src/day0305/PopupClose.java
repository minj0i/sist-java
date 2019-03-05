package day0305;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PopupClose extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//checkbox에 value가 없을 때, 체크 박스를 선택하고 submit이 되면 "on"이
		//들어오고 체크박스를 선택하지 않고 submit되면 null이 입력된다.
		String popupFlag=request.getParameter("popupFlag");//on/null
		//System.out.println(popupFlag);
		if(popupFlag != null) {//체크박스가 선텍된 경우 "on"
			
			//쿠키 심기 : 날짜를 가진 쿠키를 심어서 팝업창을 보여주지 않을 목적
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			
			//1.쿠키 생성
			Cookie popupCookie=new Cookie("popup_date", sdf.format(new Date()));
			//2.쿠키의 생존 시간
			popupCookie.setMaxAge(60*60*24);
			//3.쿠키 심기
			response.addCookie(popupCookie);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			out.println("<script type='text/javascript'>");
			out.println("window.onload=function(){");
			out.println("self.close();");
			out.println("}//function");
			out.println("</script>");
			
		}//end if
	
	}//doGet

}//class
