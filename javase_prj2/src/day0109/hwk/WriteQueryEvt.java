package day0109.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WriteQueryEvt extends WindowAdapter implements ActionListener {
	private WriteQueryView wqv;
	private String selectDataType;
	private String selectConstraint;
	private boolean flag;// 쿼리를 최소 1번 실행한걸 확인하는 인스턴스 변수

	public WriteQueryEvt(WriteQueryView wqv) {
		this.wqv = wqv;
		flag = false;

		wqv.getJcbDataTypeSelect().addItem("varchar2");
		wqv.getJcbDataTypeSelect().addItem("char");
		wqv.getJcbDataTypeSelect().addItem("number");
		wqv.getJcbDataTypeSelect().addItem("date");

		wqv.getJcbConstraintSelect().addItem("null");
		wqv.getJcbConstraintSelect().addItem("primary key");
		wqv.getJcbConstraintSelect().addItem("unique");
		wqv.getJcbConstraintSelect().addItem("not null");

		selectDataType = "varchar2";
		selectConstraint = "null";

	}

	// 선택한 아이템 이름 전달하는 애
	public String selectName(JComboBox<String> jcb) {
		String selectedName = "";
		selectedName = jcb.getSelectedItem().toString();

		return selectedName;
	}

	// 테이블 추가 누를 시 작동하는 메서드
	public void addQueryToCreateTable() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = wqv.getJtaQueryView();
		String tableName = wqv.getjtfTableName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") != -1) {
			JOptionPane.showMessageDialog(wqv, "이미 create 쿼리가 있습니다.");
			return;
		}

		if (tableName.equals("")) {
			JOptionPane.showMessageDialog(wqv, "테이블명을 입력하세요");
			return;
		}

		sb.append("create table ").append(tableName).append("(\n").append(");");

		jta.setText(sb.toString());// jta에 적용
	}

	// 컬럼 추가 누를 시 작동하는 메서드
	public void addQueryToColumn() throws NumberFormatException {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = wqv.getJtaQueryView();
		String columnName = wqv.getjtfColumnName().getText();
		int dataSize = Integer.parseInt(wqv.getjtfDataSize().getText());
		String constructName = wqv.getjtfConstraintName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") == -1) {
			JOptionPane.showMessageDialog(wqv, "테이블명 추가 버튼을 먼저 누르세요.");
			return;
		}
		if (columnName.equals("")) {
			JOptionPane.showMessageDialog(wqv, "컬럼명을 입력하세요");
			return;
		}
		if (sb.lastIndexOf(columnName) != -1) {
			JOptionPane.showMessageDialog(wqv, "이미 같은 이름의 컬럼명이 있습니다.");
			return;
		}

		if (dataSize < 1) {
			JOptionPane.showMessageDialog(wqv, "데이터 크기는 1이상의 정수만 입력 가능합니다");
			return;
		}
		if (constructName.equals("")) {
			JOptionPane.showMessageDialog(wqv, "제약사항명을 입력하세요");
			return;
		}
		if (sb.lastIndexOf(constructName) != -1) {
			JOptionPane.showMessageDialog(wqv, "이미 같은 이름의 제약사항명이 있습니다.");
			return;
		}////////////예외처리 //////////////////////////////////////////////////////////////

		
		
		// 최초 실행 varchar2, char, number, date 가 1개도 없을 때
		if (sb.lastIndexOf("varchar2") == -1 && sb.lastIndexOf("char") == -1 && sb.lastIndexOf("number") == -1
				&& sb.lastIndexOf("date") == -1) {
			sb.delete(sb.lastIndexOf(")"), sb.length());// 맨 뒷 괄호만 지우고 append 시킨다.
		} else {// 최초실행이 아닐 때
			sb.delete(sb.lastIndexOf(")") - 1, sb.length());// 맨 뒷괄호와 줄바꿈을 지우고
			sb.append(",\n");// 컴마와 줄바꿈을 붙인 뒤 append 시킨다.
		}

		
		if (selectConstraint.equals("null") || selectConstraint.equals("not null")) {//제약사항이 null 또는 not null일 때 (제약사항 명이 필요 없음 
			if (selectDataType.equals("date")) {// date로 컬럼을 만들 때 (테이블 생성시 크기에 상관없이 date를 만들어야 하는 것 같음 ;; 
				sb.append("  ")
				.append(columnName).append(" ")
				.append("date default (sysdate) ")
				.append(selectConstraint);
			} else {// date로 컬럼을 안만들때
				sb.append("  ")
				.append(columnName).append(" ")
				.append(selectDataType).append("(").append(dataSize).append(") ")
				.append(selectConstraint);
			}
		} else {
			if (selectDataType.equals("date")) {// date로 컬럼을 만들 때(테이블 생성시 크기에 상관없이 date를 만들어야 하는 것 같음 ;; 
				sb.append("  ")
				.append(columnName).append(" ")
				.append("date default (sysdate) ")
				.append("constraint ").append(constructName).append(" ").append(selectConstraint);
			} else {
				sb.append("  ")
				.append(columnName).append(" ")
				.append(selectDataType).append("(").append(dataSize).append(") ")
				.append("constraint ").append(constructName).append(" ").append(selectConstraint);
			}
		}
		sb.append("\n);");
		

		flag = true;// 쿼리를 최소 1번 실행한걸 확인하는 인스턴스 변수
		jta.setText(sb.toString());// jta에 적용

	}

	// 테이블 생성 누를 시 작동하는 메서드 (예외처리 추가할 게 많음
	public void createTableToQuery() {
		try {
			WriteQueryDAO.getInstance().createTable(wqv.getJtaQueryView().getText());
			JOptionPane.showMessageDialog(wqv, "테이블이 생성되었습니다.");
		} catch (SQLException se) {
			String errMsg = "";

			switch (se.getErrorCode()) {
			case 910:
				errMsg = "데이터형에 지정된 길이가 너무 깁니다.";
				break;
			case 955:
				errMsg = "같은 이름의 테이블이 존재합니다.";
				break;
			case 1727:
				errMsg = "수치의 정도 범위(38 자리 이내)를 초과했습니다.";
				break;
			case 2260:
				errMsg = "테이블에는 하나의 기본 키만 가질 수 있습니다.";
				break;
			case 2264:
				errMsg = "기존의 제약에 사용된 이름입니다.";
				break;
			default:
				errMsg = "예기치 못한 오류가 발생했습니다.\n오류코드 : " + se.getErrorCode();
			}

			JOptionPane.showMessageDialog(wqv, errMsg);
			se.printStackTrace();
		}
	}

	// 초기화 누를 시 작동하는 메서드
	public void resetAll() {
		wqv.getJtaQueryView().getText();
		wqv.getJtaQueryView().setText("");
		wqv.getjtfTableName().getText();
		wqv.getjtfTableName().setText("");
		wqv.getjtfColumnName().getText();
		wqv.getjtfColumnName().setText("");
		wqv.getjtfDataSize().getText();
		wqv.getjtfDataSize().setText("");
		wqv.getjtfConstraintName().getText();
		wqv.getjtfConstraintName().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == wqv.getJcbDataTypeSelect()) {
			selectDataType = selectName(wqv.getJcbDataTypeSelect());
			System.out.println("데이터형 선택 : " + selectDataType);
		} // 완료

		if (ae.getSource() == wqv.getJcbConstraintSelect()) {
			selectConstraint = selectName(wqv.getJcbConstraintSelect());
			System.out.println("제약사항 선택 : " + selectConstraint);
		} // 완료

		if (ae.getSource() == wqv.getJbtTableAdd()) {
			addQueryToCreateTable();
		} // 완료

		if (ae.getSource() == wqv.getJbtColumnAdd()) {
			try {
				addQueryToColumn();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(wqv, "데이터 크기는 1이상의 정수만 입력 가능합니다");
			}
		} // 완료

		if (ae.getSource() == wqv.getJbtTableCreate()) {
			if (flag) {
				createTableToQuery();
			} else {
				JOptionPane.showMessageDialog(wqv, "쿼리 추가 버튼을 최소 1회 실행한 뒤 테이블 생성을 해야합니다.");
			}
		}

		if (ae.getSource() == wqv.getJbtReset()) {
			resetAll();
		} // 완료

	}

	@Override
	public void windowClosing(WindowEvent e) {
		wqv.dispose();
	}

}
