package day0304;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UseSessionC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 삭제 페이지
		//1.세션 얻기
		HttpSession session=request.getSession();
		//2.세션 값 삭제
		//(원래 값 확인)
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("user_name");
		
		System.out.println("아이디: "+id + " 이름: "+ name);
		
		//(값 삭제)
		session.removeAttribute("id");
		session.removeAttribute("user_name");
		
		String id2=(String)session.getAttribute("id");
		String name2=(String)session.getAttribute("user_name");
	
		System.out.println("아이디: "+id2 + " 이름: "+ name2);
		
		//3.브라우저에 할당된 세션 자체를 무효화
		//코드에서 에러표시가 되지 않지만 로그아웃을 누르면 HTTP-STATUS-500 Internet Server Error가 뜸
		//세션이 무효화되고 난 이후에는 세션에서 값을 얻을 수 없다.
		session.invalidate();
		
		/*String id3=(String)session.getAttribute("id");
		String name3=(String)session.getAttribute("user_name");
		
		System.out.println("아이디: "+id3 + " 이름: "+ name3);*/
		
		//이동할 페이지 설정
		//response.sendRedirect("day0304/use_session.html");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script type='text/javascript'>");
	    out.println("window.onload=function(){");
	    out.println("\tlocation.replace('day0304/use_session.html');");
	    out.println("}//onload");
	    out.println("</script>");
		
		
	}//doGet
}//class
