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

	//method�� get�̳� post�� �������
	@RequestMapping(value="/view_request.do", method=GET)
	//JSP�� �����ϱ� ���� scope ��ü�� �Ű������� �޴´�.
	//HttpServletRequest�� POJO������ Ŭ������ �ƴϰ� �ǹǷ� �������� �ʴ´�.
	public String useRequest(HttpServletRequest request) {
		
		//��������
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//���������� ��ȸ�Ͽ� JSP�� �����Ѵ�. (scope ��ü ���)
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletRequest���");
		
		//views ��
		return "data/use_data";
	}//useRequest
	
	@RequestMapping(value="/view_model.do", method=GET)
	//Model�� ����Ͽ� ������ ����(����)
	public String useModel(Model m) {
		
		//��������
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//���������� ��ȸ�Ͽ� JSP�� �����Ѵ�. (scope ��ü ���)
		//"req_data", noticList���� ���� map�̶�� ��. Ű�� ���� ��
		//map�� Ȱ���� ���� ���� ��ü : Session, Cookie=>(���� �ذ�) LocalStorage, SessionStorage
		m.addAttribute("req_data", noticeList);
		m.addAttribute("msg", "Model���");
		
		return "data/use_data";
	}
	
	@RequestMapping(value="/view_modelandview.do", method=GET)
	public ModelAndView useModelAndView() {
		
		//��������
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//���������� ��ȸ�Ͽ� JSP�� �����Ѵ�. (scope ��ü ���)
		//1.��ü ����
		ModelAndView mav = new ModelAndView();
		//2.view�� JSP���� ����
		mav.setViewName("data/use_data");
		//3.�����͸� ����
		mav.addObject("req_data", noticeList);
		mav.addObject("msg", "ModelAndView���");
		return mav;
	}//useModelAndView
	
	@RequestMapping(value="/use_redirect.do", method=GET)
	public String moveRedirect() {
		//redirect�� return �� �տ� �پ� ������ WEB-INF/views������ �̵��ϴ� ���� �ƴϰ�
		//WebContent �� redirect �� ����/jsp���Ϸ� �Ѿ
		
		//redirect�� �̵��� ���� ��� �� ����� ��
		return "redirect:day0415/use_redirect.jsp";
		//�����ϰ� ���� 
	}//moveRedirect
	
}//class
