package kr.co.sist.controller.webparam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.domain.Notice;
import kr.co.sist.service.NoticeService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class DataController {

	//method는 get이나 post나 상관없음
	@RequestMapping(value="/view_request.do", method=GET)
	//JSP로 전달하기 위해 scope 객체를 매개변수로 받는다.
	//HttpServletRequest는 POJO형식의 클래스가 아니게 되므로 권장하지 않는다.
	public String useRequest(HttpServletRequest request) {
		
		//업무수행
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//공지사항을 조회하여 JSP로 전달한다. (scope 객체 사용)
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletRequest사용");
		
		//views 안
		return "data/use_data";
	}//useRequest
	
	@RequestMapping(value="/view_model.do", method=GET)
	//Model을 사용하여 데이터 전달(권장)
	public String useModel(Model m) {
		
		//업무수행
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//공지사항을 조회하여 JSP로 전달한다. (scope 객체 사용)
		//"req_data", noticList같은 것을 map이라고 함. 키와 값의 쌍
		//map을 활용한 관계 유지 객체 : Session, Cookie=>(단점 해결) LocalStorage, SessionStorage
		m.addAttribute("req_data", noticeList);
		m.addAttribute("msg", "Model사용");
		
		return "data/use_data";
	}
	
	@RequestMapping(value="/view_modelandview.do", method=GET)
	public ModelAndView useModelAndView() {
		
		//업무수행
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//공지사항을 조회하여 JSP로 전달한다. (scope 객체 사용)
		//1.객체 생성
		ModelAndView mav = new ModelAndView();
		//2.view할 JSP명을 설정
		mav.setViewName("data/use_data");
		//3.데이터를 설정
		mav.addObject("req_data", noticeList);
		mav.addObject("msg", "ModelAndView사용");
		return mav;
	}//useModelAndView
	
	@RequestMapping(value="/use_redirect.do", method=GET)
	public String moveRedirect() {
		//redirect가 return 값 앞에 붙어 있으면 WEB-INF/views폴더로 이동하는 것이 아니고
		//WebContent 내 redirect 뒤 폴더/jsp파일로 넘어감
		
		//redirect로 이동할 때는 경로 다 써줘야 함
		return "redirect:day0415/use_redirect.jsp";
		//실행하고 나면 
	}//moveRedirect
	
}//class
