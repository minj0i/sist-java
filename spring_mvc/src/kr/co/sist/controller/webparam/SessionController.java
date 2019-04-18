package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.vo.SessionVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Random;

import javax.servlet.http.HttpSession;

@SessionAttributes({"an_name","an_addr"})
@Controller
public class SessionController {
	
	//��û�� Ư���̸����� ��� ó���Ϸ��� value="/���� �̸�/��û.do"�� �������� ����Ѵ�.
	//���� �̸��� ���������� �ƴ����� �����ؼ� ���� �� �ִ�.
	//���� �־��ִ°� Annotation���� �� �� ����
	//�޴� �� Controller���� �Ű������� �޾ƾ� ��.
	//JSP�� �׳� �� �� ����
	@RequestMapping(value="/session/use_session.do", method=GET)  
	//���� ���� Controller���� �ޱ�
	public String sessionForm(HttpSession session) {
		String name = (String)session.getAttribute("ses_name");
		String addr = (String)session.getAttribute("ses_addr");
		System.out.println("----Controller���� ���� ���� �� : =------"+name+"/"+addr);
		
		return "session/session_form";
	}//sessionForm
	
	
	@RequestMapping(value="/session/session_param.do", method=POST)
	//�ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	//session_form.jsp�� <form action="session_param.do" method="post">�� �Ǿ� �־ post�� ó������� ��
	//get�� Tomcat�� �ѱ�ó���� �������� post�� request ���� setCharacter��
	
	public String sessionParam(SessionVO s_vo, HttpSession session){
		//�Ű������� HttpServletRequest request�� �ް�
		//request.setCharacterEncoding("UTF-8");//���⼭ ���൵ ����.
	
		//JSP������Ʈ�� �ִ� util��Ű�� �����ؼ� �ٿ��ֱ�
		//System.out.println(HangulConv.toUTF(s_vo.getName())+" "+s_vo.getAddr());
		//�׷��� �ȵ�. filter �����ؾ� ��
	
		//System.out.println("----param is -----"+s_vo.getName()+" / "+s_vo.getAddr());
		
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());
		//viewResolver�� ���ؼ� �̵�
		String url="session/use_session";
		session.setAttribute("flag", "forward�� �̵�");

		if(new Random().nextBoolean()) {
			session.setAttribute("flag", "redirect�� �̵�");
			url="redirect:use_session.jsp"; 
		}//end if
		
		return url;
	}//sessionForm
	
	@RequestMapping(value="session/remove_session.do", method=GET)
	//������ ���� �� ����
	public String removeSession(HttpSession session) {
		
		
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");
		session.invalidate();
		
		return "session/session_form"; 
	}//removeSession
	
	////////////////////////@SessionAttribute�� ����� ���� ó��////////////////////
	@RequestMapping(value="/session/an_use_session.do", method=GET)  
	//���� ���� Controller���� �ޱ�
	public String anSessionForm(HttpSession session) {
		String name = (String)session.getAttribute("an_name");
		String addr = (String)session.getAttribute("an_addr");
		System.out.println("----Controller anSessionForm���� ���� ���� �� : =------"+name+"/"+addr);
		
		return "session/an_session_form";
	}//sessionForm
	
	@RequestMapping(value="/session/an_session_param.do", method=POST)
	//�ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	//@SessionAttributes annotation�� ����ϸ� ������ ���� �ʰ� Model�� �޴´�
	public String anSessionParam(SessionVO s_vo, Model model){
		
		//���ǿ��� ����� ���� Model��ü�� �����Ѵ�.
		//��. �̸��� ������ ������ �̸��� ���ƾ� �������� ���� �Ҵ�ȴ�.
		//����� ���� requestScope�� sessionScope�� �����ϰ� �Ҵ�ȴ�.
		model.addAttribute("an_name", s_vo.getName());
		model.addAttribute("an_addr", s_vo.getAddr());
		
		String url="session/an_session_value";//viewResolver�� ���ؼ� �̵�
		model.addAttribute("an_flag", "forward�� �̵�");

		return url;
	}//sessionForm
	
	@RequestMapping(value="/session/an_remove_session.do", method=GET)
	//������ ���� �� ����(HttpSession�� �Ű������� �޾Ƽ��� @SessionAttribute
	//�� ������ ���� �������� �ʴ´�.
	/*public String anRemoveSession(HttpSession session) {
	session.removeAttribute("an_name");
	session.removeAttribute("an_addr");
	session.invalidate();
	return "session/an_session_form";
} */
	//1.SessionStatus��ü�� �Ű������� �����ϰ�
	public String anRemoveSession(SessionStatus ss) {
		ss.setComplete();
		System.out.println("----���ǻ��� ----");
		return "session/an_session_form"; 
	}//removeSession
	
}//class
