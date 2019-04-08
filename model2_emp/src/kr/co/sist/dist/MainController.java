package kr.co.sist.dist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.controller.Controller;
import kr.co.sist.controller.DeptController;
import kr.co.sist.controller.EmpController;

/**
 * 진입점 : 모든 요청을 받고, 요청을 처리할 Controller를 찾아서 실행을 한다.
 * 			view로 이동
 * @author owner
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	//instance영역 - 실행되자마자 딱 한번만 실행
	
	//클래스의 필드에서는 변수의 선언, 메소드의 선언만 되고 일을 하는 것은 안됨.
	//한번만 만들어서 쓰게 하고 싶을 때
	private static Map<String, Controller> distMap;
	
	static{//영역 : 개발자가 호출하지 않고 잡자코드를 자동으로 실행해야 할 때 
		//instance영역 : 객체가 생성되면 자동 호출
		//static 영역: JVM이 실행되고 관련클래스가 생성되면 자동 호출
		distMap=new HashMap<String, Controller>();
		distMap.put("D001", new DeptController());//부서조회업무
		distMap.put("E001", new EmpController());//사원조회업무
	}//static
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);//GET방식의 요청이 있어도 doPost로 처리
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글처리
		
		String cmd=request.getParameter("cmd");
		if(cmd==null||"".equals(cmd)) {//NullPoint방지 (cmd가 없거나, cmd에 값이 없을 때)
			cmd="D001";
		}//end if
		
		Controller controller=distMap.get(cmd);
		if(controller==null) {//cmd를 외부에서 임의로 변경했을 때 처리
			controller=distMap.get("D001");//외부에서 임의로 변경하면 메인을 제공한다.
		}//end if
		//웹의 파라메터처리, 관계유지, 업무처리 결과를 scope객체 설정하는 일 
		controller.execute(request, response);
		//이동할 페이지 URL받기
		String url=controller.moveURL();
		//이동방식 받기
		boolean forwardFlag=controller.isForward();
		//System.out.println(url);
		
		pageMove(request, response, url, forwardFlag);//페이지 이동
		
	}//doPost
	
	public void pageMove(HttpServletRequest request, HttpServletResponse response, String moveURL, boolean isForward) 
		throws ServletException, IOException{
		if(isForward) {//forward 이동
			RequestDispatcher rd = request.getRequestDispatcher(moveURL);
			rd.forward(request, response);
		}else {//redirect이동
			response.sendRedirect(moveURL);
		}//end else
	}//pageMove

}//class
