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
		//���� ���� ������
		//1.���� ���
		HttpSession session=request.getSession();
		//2.���� �� ����
		//(���� �� Ȯ��)
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("user_name");
		
		System.out.println("���̵�: "+id + " �̸�: "+ name);
		
		//(�� ����)
		session.removeAttribute("id");
		session.removeAttribute("user_name");
		
		String id2=(String)session.getAttribute("id");
		String name2=(String)session.getAttribute("user_name");
	
		System.out.println("���̵�: "+id2 + " �̸�: "+ name2);
		
		//3.�������� �Ҵ�� ���� ��ü�� ��ȿȭ
		//�ڵ忡�� ����ǥ�ð� ���� ������ �α׾ƿ��� ������ HTTP-STATUS-500 Internet Server Error�� ��
		//������ ��ȿȭ�ǰ� �� ���Ŀ��� ���ǿ��� ���� ���� �� ����.
		session.invalidate();
		
		/*String id3=(String)session.getAttribute("id");
		String name3=(String)session.getAttribute("user_name");
		
		System.out.println("���̵�: "+id3 + " �̸�: "+ name3);*/
		
		//�̵��� ������ ����
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
