package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ChainController {
	@RequestMapping(value="/chain/chain_a.do", method=GET)
	public String chainA(Model model) {
		
		String[] lunch= {"버거킹","KFC","맥날","넙데리아","맘터"};
		model.addAttribute("lunch",lunch);
		return "forward:chain_b.do";
		//return에는 forward나 redirect가 붙어 있으면 ViewResolver를 거치지 않고
		//정의된 URL을 직접 호출할 수 있다.
	}//chainA
	
	@RequestMapping(value="/chain/chain_b.do", method=GET)
	public String chainB() {//직접 호출 될 수도 있고, A를 거쳐서 호출 될 수도 있다.
		
		return "chain/chain_b_result";
	}//chainB
	
	
	
}//class
