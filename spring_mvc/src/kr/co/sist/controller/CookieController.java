package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.CookieService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {
	@RequestMapping(value="/cookie/read_cookie.do", method=GET)
	public String readCookie(HttpServletRequest request, Model model) {
		
		//1. 쿠키들 얻기
		Cookie[] cookies = request.getCookies();
		model.addAttribute("rCookie", cookies);
		if(cookies !=null) {//읽어들인 쿠키 존재
			
			//읽어들인 모든 쿠키를 JSP에서 사용할 수 있다.
			CookieService cs = new CookieService();
			
			Cookie tempCookie = null;
			int cnt=0;
			for(int i=0; i<cookies.length; i++) {
				//Controller에서 쿠키의 값으로 업무처리를 하기 위해서 
				tempCookie=cookies[i];
				if("JSESSIONID".equals(tempCookie.getName())) {
					cnt++;
				}//end if
				//cookie name="ooo", age=32323;
				//name을 비교해서 value값을 넣어주는 형식이기 때문에 getName으로 비교해서 value값을 add.
				if("name".equals(tempCookie.getName())){
					model.addAttribute("name", cs.nameMsg(tempCookie.getValue()));
					cnt++;
				}//end if
				if("age".equals(tempCookie.getName())){
					model.addAttribute("birth", cs.birth(Integer.parseInt(tempCookie.getValue())));
				}//end if
			}//end for
			if(cnt==1) {//JESSIONID만 존재하는 경우
				model.addAttribute("rCookie", null);
			}//end if
		}//end if
		
		return "cookie/read_cookie";
	}//readCookie
	
	@RequestMapping(value="/cookie/add_cookie.do", method=GET)
	public String addCookie(HttpServletResponse response, Model model) {
		
		//1.쿠키생성
		Cookie nameCookie=new Cookie("name", "seonui.gong");
		Cookie ageCookie=new Cookie("age", "28");
		//2.쿠키생존시간 설정 : 브라우저가 열려있으면 계속 유지
		//브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(60*2);
		ageCookie.setMaxAge(60*2);
		//3. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg", "접속자 컴퓨터로 쿠키 생성");
		return "cookie/read_cookie";
	}//addCookie
	
	@RequestMapping(value="/cookie/remove_cookie.do", method=GET)
	public String removeCookie(HttpServletResponse response,Model model) {
		//1.같은 이름의 쿠키를 생성한다.
		//세션과 쿠키는 web에서 말을 안듣는 애들이기때문에. 혹시나 안되면 값이 없도록 설정한다.
		Cookie nameCookie=new Cookie("name", "");
		Cookie ageCookie=new Cookie("age", "");
		
		//2.생존시간을 0으로 설정한다.
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		
		//3. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg", "쿠키가 삭제 되었습니다.");
		return "cookie/read_cookie";
	}//removeCookie
	
	///////////////////@CookieValue annotation 사용////////////////////////
	@RequestMapping(value="/cookie/read_an_cookie.do", method=GET)
	public String anReadCookie(
			@CookieValue(value="an_name", defaultValue="")String an_name,
			@CookieValue(value="an_age", defaultValue="")String an_age, Model model) {
			System.out.println("쿠키 값 이름 : "+an_name);
			System.out.println("쿠키 값 나이 : "+an_age);
			
			model.addAttribute("an_name", an_name);
			model.addAttribute("an_age", an_age);
			
		return "cookie/an_read_cookie";
	}//anReadCookie
	
	@RequestMapping(value="/cookie/an_add_cookie.do", method=GET)
	public String anAddCookie(HttpServletResponse response) {
		
		//1.쿠키생성
		Cookie nameCookie=new Cookie("an_name", "jungyun");
		Cookie ageCookie=new Cookie("an_age", "30");
		//2.쿠키생존시간 설정 : 브라우저가 열려있으면 계속 유지
		//브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(60*2);
		ageCookie.setMaxAge(60*2);
		//3. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		return "cookie/an_cookie_result";
	}//addCookie
	
}//class
