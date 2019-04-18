package kr.co.sist.controller.webparam;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.co.sist.service.AjaxService;
@Controller
public class AjaxController {
/*   @ResponseBody//로 했을때 값이 바로 출력*/
     @RequestMapping(value="/ajax/ajax.do",  method=RequestMethod.GET)
     public String getJsonForm() {
           //AjaxService as=new AjaxService();
           //JSONObject json=as.createJson();
           //return json.toJSONString();//값이 그대로 출력된다.
           
           return "ajax/ajax_form";
     }//getJsonForm
     
     @ResponseBody
     @RequestMapping(value="/ajax/ajax_process.do",  method=RequestMethod.GET)
     public String getJsonObject() {
           JSONObject json=null;
           AjaxService as=new AjaxService();
           
           json=as.createJson();
           //System.out.println(json.toJSONString());//잘  나오는데 한글이라 깨짐
           return json.toJSONString();
     }//getJsonObject
     
}//class