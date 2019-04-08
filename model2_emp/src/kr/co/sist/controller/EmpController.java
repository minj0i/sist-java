package kr.co.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.EmpService;
import kr.co.sist.vo.EmpVO;

/**
 * 모든 부서정보를 조회하는 일. (요청 하나를 클래스 하나가 처리한다.)
 * @author owner
 *
 */
public class EmpController implements Controller{
	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptno=request.getParameter("deptno");
		int tempDeptno=Integer.parseInt(deptno);
		
		EmpService es=new EmpService();
		List<EmpVO> list=es.searchEmp(tempDeptno);
		//처리한 결과를 scope객체에 저장하여 view로 전달
		request.setAttribute("empList", list);
		url="emp/emp_list.jsp";
		forwardFlag=true;
	}

	@Override
	public String moveURL() {
		return url;
	}//moveURL

	@Override
	public boolean isForward() {
		return forwardFlag;
	}//isForward
	
}//DeptController
