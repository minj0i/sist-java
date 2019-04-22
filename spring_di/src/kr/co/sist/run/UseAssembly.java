package kr.co.sist.run;

import java.util.List;

import kr.co.sist.assembly.Assembly;
import kr.co.sist.service.Service;
import kr.co.sist.vo.EmpVO;

/**
 * ������ Ŭ������ ����Ͽ� ���񽺰�ü�� ��� ���񽺸� ����ϴ� ��. 
 * @author owner
 */
public class UseAssembly {

	public static void main(String[] args) {
		Assembly as = new Assembly();
		Service service=as.getBean();
		service.addEmp(new EmpVO(1234, "�׽�Ʈ"));
		System.out.println("------------------");
		List<EmpVO> list=service.searchEmp();
		for(EmpVO emp:list) {
			System.out.println(emp.getEmpno()+" / "+emp.getEname());
		}//end for
	}//main
	
}//class