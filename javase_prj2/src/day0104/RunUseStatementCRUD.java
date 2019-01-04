package day0104;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RunUseStatementCRUD { //DataAccessObject DB�� ���õ� ������ ó���ϴ� Ŭ������ DAO��� �θ�

	private UseStatementCRUD us_crud;

	public RunUseStatementCRUD() {
		us_crud = new UseStatementCRUD();
	}// RunUseStatementCRUD

	public void addCpDept() {
		String tempData = JOptionPane.showInputDialog("�μ������߰�\n�Է� ��)�μ���ȣ, �μ���, ��ġ");
		if(tempData != null && !tempData.equals("")/*&&�̱⶧���� ������ false�̸� ������ �������� ����*/) {
			String[] data = tempData.split(",");
			if(data.length!=3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���");
				return;
			}//end if
			
			int deptno=0;
			String dname = "";
			String loc ="";
			
			try {
				deptno=Integer.parseInt(data[0]);
				dname=data[1];
				loc=data[2];
				
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�");
				return;
			}//end catch
			//ó���� �Էµ����͸� VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			//VO�� ���� DB�� insert�Ѵ�.
			try {
			us_crud.insertCpDept(cdvo);//�߰�����
			JOptionPane.showMessageDialog(null, deptno+"�� �μ����� �߰�");
			}catch (SQLException se) {//����
				
				String errMsg = "";
				switch(se.getErrorCode()) {
					case 1 : errMsg=deptno+"�� �μ��� �̹� �����մϴ�.";break;
					case 1438 : errMsg="�μ���ȣ�� ���ڸ� �Դϴ�.";break;
					case 12899 : errMsg="�μ����̳� ��ġ�� �ʹ� ��ϴ�.";break;
					default: errMsg ="���E�մϴ�. ��� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ����ּ���";break;
				}//end switch
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}//end catch
			
		}//end if
		
	}// addCpDept
	
	public void modifyCpDept() {
		String tempData = JOptionPane.showInputDialog("�μ���������\n �μ���ȣ�� ��ġ�ϴ� �μ���� ��ġ�� �����մϴ�.\n�Է� ��)�μ���ȣ, �μ���, ��ġ");
		if(tempData != null && !tempData.equals("")/*&&�̱⶧���� ������ false�̸� ������ �������� ����*/) {
			String[] data = tempData.split(",");
			if(data.length!=3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���");
				return;
			}//end if
			
			int deptno=0;
			String dname = "";
			String loc ="";
			
			try {
				deptno=Integer.parseInt(data[0]);
				dname=data[1];
				loc=data[2];
				
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�");
				return;
			}//end catch
			//ó���� �Էµ����͸� VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			//VO�� ���� DB�� update�Ѵ�.
			try {
				String msg = "";
			if(us_crud.updateCpDept(cdvo)) {//����� ���ڵ� ����
				msg = deptno+"�� �μ��� ������ �����Ͽ����ϴ�.";
			}else{ //����� ���ڵ尡 �������� ����
				 msg = deptno+"�� �μ��� �������� �ʽ��ϴ�.";
			}//end else
			JOptionPane.showMessageDialog(null, msg);
			
			}catch (SQLException se) {//����
				
				String errMsg = "";
				switch(se.getErrorCode()) {
					case 12899 : errMsg="�μ����̳� ��ġ�� �ʹ� ��ϴ�.";break;
					default: errMsg ="���E�մϴ�. ��� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ����ּ���";break;
				}//end switch
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}//end catch
			
		}//end if
		
		
	}// modifyCpDept
	
	public void removeCpDept() {
		String inputData = JOptionPane.showInputDialog("�μ�����\n������ �μ���ȣ �Է�");
		if(inputData!=null && !inputData.equals("")) {
			int deptno = 0;
			try {
				deptno=Integer.parseInt(inputData);
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����̾�� �մϴ�.");
				return;
			}//end catch
			try {
				String msg = deptno+"�� �μ��� �������� �ʽ��ϴ�.";

			if(us_crud.deleteCpDept(deptno)) {
				msg = deptno+"�� �μ� ������ �����Ͽ����ϴ�.";
			}//end if
		
			JOptionPane.showMessageDialog(null, msg);
			
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		}//end catch
			
		}//end if
	}// removeCpDept
	
	public void searchAllCpDept() {
		
	}// searchAllCpDept
	
	public void searchOneCpDept() {
		
	}// searchOneCpDept

	public static void main(String[] args) {
		RunUseStatementCRUD rus_crud = new RunUseStatementCRUD();

		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("�޴�����\n1.�μ��߰� 2.�μ����� 3.�μ����� 4.��ü�μ���ȸ 5.Ư���μ���ȸ 6.����");

			switch (inputMenu) {
			case "1":
				rus_crud.addCpDept();
				break;
			case "2":
				rus_crud.modifyCpDept();
				break;
			case "3":
				rus_crud.removeCpDept();
				break;
			case "4":
				rus_crud.searchAllCpDept();
				break;
			case "5":
				rus_crud.searchOneCpDept();
				break;
			case "6":
				exitFlag = true;
				break;
				
			default: JOptionPane.showMessageDialog(null, inputMenu+"�� �����Ǵ� ���񽺰� �ƴմϴ�.");
				break;
			}//switch
			
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "������ּż� �����մϴ�");

	}// main

}// class
