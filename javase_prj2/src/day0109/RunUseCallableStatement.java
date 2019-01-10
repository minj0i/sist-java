package day0109;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVO;

public class RunUseCallableStatement {

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보추가\n입력 예)사원번호, 사원명, 연봉, 직무");
		if(tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");
			if(data.length!=4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요");
				return;
			}//end if
			
			int empno=0, sal =0;
			String ename, job = "";
			
			try {
				empno=Integer.parseInt(data[0].trim());
				ename=data[1].trim();
				sal=Integer.parseInt(data[2].trim());
				job=data[3].trim();
				
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다");
				
				return;
			}//end catch
			
			//처리된 입력데이터를 VO에 설정하고
			TestProcVO tpvo = new TestProcVO(empno, sal, ename, job);
			
			//VO의 값을 DB에 insert한다.
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().insertProc(tpvo);
				JOptionPane.showMessageDialog(null, msg);//데이터상황에서 발생하는 에러메세지도 DB에서 처리가 되어있음
			}catch (SQLException se) {//예외
				
				JOptionPane.showMessageDialog(null, "DBMS에 사소한 문제가 발생하였습니다.");
				se.printStackTrace();
			}//end catch
			
		}//end if
	}//addTestProc
	
	public void modifyTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보변경\n 사원번호에 일치하는 직무와 연봉을 변경합니다.\n입력 예)사원번호, 직무, 연봉");
		if(tempData != null && !tempData.equals("")/*&&이기때문에 전항이 false이면 후항을 실행하지 않음*/) {
			String[] data = tempData.split(",");
			
			if(data.length!=3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요");
				return;
			}//end if
			
			int empno=0, sal=0;
			String job = "";

			try {
				empno=Integer.parseInt(data[0].trim());
				job=data[1].trim();
				sal=Integer.parseInt(data[2].trim());
				
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다");
				return;
			}//end catch
			
			//처리된 입력데이터를 VO에 설정하고
			TestProcUpdateVO tpuvo = new TestProcUpdateVO(empno, sal, job);
			//VO의 값을 DB에 update한다.
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().updateProc(tpuvo);
				//판정 자체가 프로시저 안에 있음
				JOptionPane.showMessageDialog(null, msg);
			
			}catch (SQLException se) {//예외
				
//				String errMsg = "";
//				switch(se.getErrorCode()) {
//					case 12899 : errMsg="부서명이나 위치가 너무 깁니다.";break;
//					default: errMsg ="뎨둉합니다. 잠시 문제가 발생했습니다. 잠시 후 다시 시도해주세요";break;
//				}//end switch
				JOptionPane.showMessageDialog(null, "ㅈㅅ! 잠시 후 다시 시도");
				se.printStackTrace();
			}//end catch
			}//end if
	}//modifyTestProc
	
	
	public void removeTestProc() {
		String inputData = JOptionPane.showInputDialog("사원삭제\n삭제할 사원번호 입력");
		if(inputData!=null && !inputData.equals("")) {
			int empno = 0;
			try {
				empno=Integer.parseInt(inputData.trim());
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야 합니다.");
				return;
			}//end catch
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().deleteProc(empno);
				
				JOptionPane.showMessageDialog(null, msg);
			
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
			se.printStackTrace();
		}//end catch
			
		}//end if
		
	}//removeTestProc
	
	public void searchAllTestProc() {
		StringBuilder viewTestProc = new StringBuilder();
		viewTestProc
		.append("---------------------------------------------------------------------------------------------------------\n")
		.append("번호\t사원번호\t사원명\t연봉\t직무\t입사일\n")
		.append("---------------------------------------------------------------------------------------------------------\n");
		
		int rowCount=0;
		
		try {
			//DB에서 조회한 결과 받기
			List<TestProcAllVO> list = UseCallableStatementDAO.getInstance().searchAllTestProc();
			
			TestProcAllVO tpavo = null;
			rowCount = list.size();
			
			for(int i=0; i<list.size(); i++) {
				tpavo = list.get(i);
				viewTestProc
				.append(i+1).append("\t")
				.append(tpavo.getEmpno()).append("\t")
				.append(tpavo.getEname()).append("\t")
				.append(tpavo.getSal()).append("\t")
				.append(tpavo.getJob()).append("\t")
				.append(tpavo.getHiredate()).append("\n");
			}//end for
			
		} catch (SQLException e) {
			viewTestProc.append("DBMS에서 문제가 발생했습니다. ㅈㅅ!\n");
			e.printStackTrace();
		}//end catch
		
		viewTestProc.append("---------------------------------------------------------------------------------------------------------\n")
		.append("\t\t총").append(rowCount).append("명의 사원정보가 조회되었습니다.\n")
		.append("---------------------------------------------------------------------------------------------------------\n");
		
		JTextArea jta = new JTextArea(20,50);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString());//만들어진 출력데이터를 T.A에 설정한다.
		
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 사원 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
		
	}//selectAllTestProc
	
	public void searchOneTestProc() {
		String inputData = JOptionPane.showInputDialog("사원조회\n조회할 사원번호 입력");
		if(inputData!=null && !inputData.equals("")) {
			try {
			int empno=Integer.parseInt(inputData.trim());
			//사원번호를 입력하여 사원번호에 해당하는 사원정보를 조회
			//조회한 사원이 있다면 생성된 객체(TestProcOneVO)가 반환되고 조회된 사원이 없다면
			//null이 반환된다.
			TestProcOneVO tpo_vo = UseCallableStatementDAO.getInstance().searchOneTestProc(empno);
			
			StringBuilder viewData = new StringBuilder();
			viewData.append("사원명: ").append(tpo_vo.getEname())
			.append(", 연봉: ").append(tpo_vo.getSal())
			.append(", 직급: ").append(tpo_vo.getJob())
			.append(", 입사일: ").append(tpo_vo.getHiredate());
			
			JLabel lbl = new JLabel(viewData.toString());
			lbl.setFont(new Font("SansSerif", Font.BOLD, 15));

			JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData+"번호의 사원은 존재하지 않습니다.");
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 정수형태로 입력하세요.");
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "서버에서 문제발생!");
				e.printStackTrace();
			}//end catch
		}//end if
	}//searchOneTestProc
	
	
	
	public static void main(String[] args) {
		RunUseCallableStatement rucs = new RunUseCallableStatement();
		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if(inputMenu!=null && !inputMenu.equals("")) {
			switch (inputMenu) {
			case "1":
				rucs.addTestProc();
				break;
			case "2":
				rucs.modifyTestProc();
				break;
			case "3":
				rucs.removeTestProc();
				break;
			case "4":
				rucs.searchAllTestProc();
				break;
			case "5":
				rucs.searchOneTestProc();
				break;
			case "6":
				exitFlag = true;
				break;
				
			default: JOptionPane.showMessageDialog(null, inputMenu+"는 제공되는 서비스가 아닙니다.");
				break;
			}//end switch
		}else{
			exitFlag=true;
		}//end else
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "사용해주셔서 감사합니다");
	}//main

}//class
