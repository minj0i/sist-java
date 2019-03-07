package kr.co.sist.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.user.dao.WebMemberDAO;
import kr.co.sist.user.vo.WebMemberVO;
import kr.co.sist.util.ShaUtil;

@SuppressWarnings("serial")
public class WebMemberJoin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	//post방식일 때 한글 처리
	request.setCharacterEncoding("UTF-8");//사용자가 쓰고 있는 character랑 같은 것
	//사용자가 입력한 값 (HTML Form Control) 받기 (getParameter)
	String id=request.getParameter("id");
	String pass1=request.getParameter("pass1");
	String name=request.getParameter("name");
	String ssn1=request.getParameter("ssn1");
	String ssn2=request.getParameter("ssn2");
	String gender=request.getParameter("gender");
	String b_year=request.getParameter("b_year");
	String b_month=request.getParameter("b_month");
	String b_day=request.getParameter("b_day");
	String age=request.getParameter("age");
	String[] interestlang=request.getParameterValues("interestlang");
	String marriageFlag=request.getParameter("marriageFlag");
	String m_year=request.getParameter("m_year");
	String m_month=request.getParameter("m_month");
	String m_day=request.getParameter("m_day");
	String zipcode=request.getParameter("zipcode");
	String addr1=request.getParameter("addr1");
	String addr2=request.getParameter("addr2");
	String greetings=request.getParameter("greetings");
	
	//파라메터 값을 VO에 저장
	WebMemberVO wm_vo = new WebMemberVO(id, ShaUtil.shaEncoding(pass1), name,
			ShaUtil.shaEncoding(ssn1+"-"+ssn2), gender, b_year+"-"+b_month+"-"+b_day,
			age, marriageFlag, m_year+"-"+m_month+"-"+m_day, zipcode, addr1, addr2, greetings, request.getRemoteAddr(), interestlang);
	
	
    out.write("<!DOCTYPE html>\r\n");
    out.write("<html>\r\n");
    out.write("<head>\r\n");
    out.write("<meta charset=\"UTF-8\">\r\n");
    out.write("<title>회원가입</title>\r\n");
    out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
    out.write("<style type=\"text/css\">\r\n");
    out.write("\t#joinTitle{ font-weight: bold; font-size: 20px;  }\r\n");
    out.write("\t.tdAlign{ text-align: center  }\r\n");
    out.write("\ttable{ margin: 0px auto }\r\n");
    out.write("\ttr{ height: 25px}\r\n");
    out.write("\t\r\n");
    out.write("\t#wrap{ width: 1007px; margin:0px auto }\r\n");
    out.write("\t#joinHeader{ width: 1007px; height: 195px; \r\n");
    out.write("\t\t\t\t\tbackground: #FFFFFF url(http://localhost:8080/servlet_prj/web_member/images/header.png) no-repeat; }\t\r\n");
    out.write("\t\t\t\t\t\r\n");
    out.write("\t.span{ color: #FF0000 }\r\n");
    out.write("\t#joinContent{ position: relative;\r\n");
    out.write("\t\t\twidth:773px ; height:369px ; background:#FFFFFF url(http://localhost:8080/servlet_prj/web_member/images/welcome_background.png) no-repeat; }\r\n");
    out.write("\t#resultTitle{ position: absolute;top:130px; left:320px}\r\n");
    out.write("\t#resultInput{ position: absolute;top:150px; left:330px;}\r\n");
    out.write("</style>\r\n");
    out.write("<script type=\"text/javascript\">\r\n");
    out.write("\t\r\n");
    
    out.write("</script>\r\n");
    out.write("</head>\r\n");
    out.write("<body>\r\n");
    out.write("<div id=\"wrap\">\r\n");
    out.write("<div id=\"joinHeader\"></div>\r\n");
    out.write("<div id=\"joinContent\">\r\n");
    
    try {
    	//비연결성을 해결하기 위해
    	//추가 전에 아이디를 사용중인지 다시 재조회를하여 처리한다.
    	addWebMember(wm_vo);
    
    out.write("\t<div id=\"resultTitle\">\r\n");
    out.write("\t\t<span>");
    out.print(name);
    out.print("</span>님께서 입력하신 정보는 아래와 같습니다.\r\n");
    out.write("\t</div>\r\n");
    out.write("\t<div id=\"resultInput\">\r\n");
    out.write("\t\t<ul>\r\n");
    out.write("\t\t\t<li>아이디 : <strong>");
    out.print(id);
    out.print("</strong></li>\r\n");
    out.write("\t\t\t<li>성별 : <strong>");
    out.print(gender);
    out.print("</strong></li>\r\n");
    out.write("\t\t\t<li>생년월일 : <strong>");
    out.print(b_year+" "+b_month+" "+b_day);
    out.print("</strong></li>\r\n");
    out.write("\t\t\t<li>결혼여부 : <strong>");
    out.print(marriageFlag);
    out.print("</strong></li>\r\n");
    out.write("\t\t\t<li>관심언어 : ");
    if(interestlang!=null) {
    	for(int i=0; i<interestlang.length; i++) {
    		out.write("\t\t\t\t<strong>");
    		out.print(interestlang[i]);
    		out.print(" </strong>");
    	}//end for
    }else {
    	out.write("\t\t\t\t<strong>관심언어 없음.</strong>");
    }//end else
    out.print("\r\n");
    out.write("\t\t\t</li>\r\n");
    out.write("\t\t\t<li><a href=\"#void\">로그인</a></li>\r\n");
    out.write("\t\t</ul>\r\n");
    out.write("\t</div>\r\n");
    }catch(RuntimeException re) {
    	out.println("아이디가 이미 사용 중 입니다.<br/>");
    	out.println("<a href='#void' onclick='history.back();'>다시 입력</a><br/>");
    	
    }catch(SQLException se) {
    	se.printStackTrace();
    	out.println("회원가입이 정상적으로 이루어지지 않았습니다.<br/>");
    	out.println("서비스가 원활하지 못한 점 뎨둉합니다.<br/>");
    	out.println("정상적인 서비스를 위해서 저희 임직원들은 최선을 다하고 있습니다.<br/>");
    	out.println("신속하게 복구하겠습니다. 사용 중 불편한점은 010-디잘잘에게 연락해주세요<br/>");
    }//end catch
    out.write("\t\t\r\n");
    out.write("\t</div>\r\n");
    out.write("</div>\r\n");
    out.write("</body>\r\n");
    out.write("</html>\r\n");
 
	}//doPost

	private void addWebMember(WebMemberVO wm_vo) throws SQLException, RuntimeException{
		
		WebMemberDAO wm_dao = WebMemberDAO.getInstance();
		//추가 전에 동일 아이디가 존재하는지 다시 검색하여 처리(비연결성의 처리)
		
		if(wm_dao.selectId(wm_vo.getId())){
			throw new RuntimeException();
		};
		wm_dao.insertMember(wm_vo);
		
	}//addWebMember
	
}//class
