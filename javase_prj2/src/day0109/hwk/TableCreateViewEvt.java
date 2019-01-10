package day0109.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import day0108.ZipcodeVO;

public class TableCreateViewEvt extends WindowAdapter implements ActionListener {
	private TableCreateView tcv;
	private String selectDataType;
	private String selectConstraint;
	private boolean flag;

	public TableCreateViewEvt(TableCreateView tcv) {
		this.tcv = tcv;
		flag = false;

		tcv.getJcDatatype().addItem("varchar2");
		tcv.getJcDatatype().addItem("char");
		tcv.getJcDatatype().addItem("number");
		tcv.getJcDatatype().addItem("date");

		tcv.getJcConstraint().addItem("null");
		tcv.getJcConstraint().addItem("primary key");
		tcv.getJcConstraint().addItem("unique");
		tcv.getJcConstraint().addItem("not null");

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
		JTextArea jta = tcv.getQueryView();
		String tableName = tcv.getJtTableName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") != -1) {
			JOptionPane.showMessageDialog(tcv, "이미 create 쿼리가 있습니다.");
			return;
		}

		if (tableName.equals("")) {
			JOptionPane.showMessageDialog(tcv, "테이블명을 입력하세요");
			return;
		}

		sb.append("create table ").append(tableName).append("(\n").append(");");

		jta.setText(sb.toString());// jta에 적용
	}//

	// 컬럼 추가 누를 시 작동하는 메서드
	public void addQueryToColumn() throws NumberFormatException {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv.getQueryView();
		String columnName = tcv.getJtColumnName().getText();
		int dataSize = Integer.parseInt(tcv.getJtDataLength().getText());
		String constraintName = tcv.getJtConstraintName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") == -1) {
			JOptionPane.showMessageDialog(tcv, "테이블명 추가 버튼을 먼저 누르세요.");
			return;
		}
		if (columnName.equals("")) {
			JOptionPane.showMessageDialog(tcv, "컬럼명을 입력하세요");
			return;
		}
		if (sb.lastIndexOf(columnName) != -1) {
			JOptionPane.showMessageDialog(tcv, "이미 같은 이름의 컬럼명이 있습니다.");
			return;
		}

		if (dataSize < 1) {
			JOptionPane.showMessageDialog(tcv, "데이터 크기는 1이상의 정수만 입력 가능합니다");
			return;
		}

		if (constraintName.equals("")) {
			JOptionPane.showMessageDialog(tcv, "제약사항명을 입력하세요");
			return;
		}
		if (sb.lastIndexOf(constraintName) != -1) {
			JOptionPane.showMessageDialog(tcv, "이미 같은 이름의 제약사항명이 있습니다.");
			return;
		}

		//////////// 예외처리 //////////////////////////////////////////////////////////////

		// 최초 실행 varchar2, char, number, date 가 1개도 없을 때
		if (sb.lastIndexOf("varchar2") == -1 && sb.lastIndexOf("char") == -1 && sb.lastIndexOf("number") == -1
				&& sb.lastIndexOf("date") == -1) {
			sb.delete(sb.lastIndexOf(")"), sb.length());// 맨 뒷 괄호만 지우고 append 시킨다.
		} else {// 최초실행이 아닐 때
			sb.delete(sb.lastIndexOf(")") - 1, sb.length());// 맨 뒷괄호와 줄바꿈을 지우고
			sb.append(",\n");// 컴마와 줄바꿈을 붙인 뒤 append 시킨다.
		}

		if (selectConstraint.equals("null") || selectConstraint.equals("not null")) {// 제약사항이 null 또는 not null일 때
																						// (제약사항명이 필요 없음
			if (selectDataType.equals("date")) {// date로 컬럼을 만들 때 (테이블 생성시 크기에 상관없이 date를 만들어야 하는 것 같음 ;;
				sb.append("  ").append(columnName).append(" ").append("date default (sysdate) ")
						.append(selectConstraint);
			} else {// date로 컬럼을 안만들때
				sb.append("  ").append(columnName).append(" ").append(selectDataType).append("(").append(dataSize)
						.append(") ").append(selectConstraint);
			}
		} else {
			if (selectDataType.equals("date")) {// date로 컬럼을 만들 때(테이블 생성시 크기에 상관없이 date를 만들어야 하는 것 같음 ;;
				sb.append("  ").append(columnName).append(" ").append("date default (sysdate) ").append("constraint ")
						.append(constraintName).append(" ").append(selectConstraint);
			} else {
				sb.append("  ").append(columnName).append(" ").append(selectDataType).append("(").append(dataSize)
						.append(") ").append("constraint ").append(constraintName).append(" ").append(selectConstraint);
			}
		}
		sb.append("\n);");

		flag = true;// 쿼리를 최소 1번 실행한걸 확인하는 인스턴스 변수
		jta.setText(sb.toString());// jta에 적용
	}

	// 테이블 생성 누를 시 작동하는 메서드 (예외처리 추가할 게 많음
	public void createTableToQuery() {
		try {
			WriteQueryDAO.getInstance().createTable(tcv.getQueryView().getText());
			JOptionPane.showMessageDialog(tcv, "테이블이 생성되었습니다.");
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

			JOptionPane.showMessageDialog(tcv, errMsg);
			se.printStackTrace();
		}
	}

	// 초기화 누를 시 작동하는 메서드
	public void resetAll() {
		tcv.getQueryView().getText();
		tcv.getQueryView().setText("");
		tcv.getJtTableName().getText();
		tcv.getJtTableName().setText("");
		tcv.getJtColumnName().getText();
		tcv.getJtColumnName().setText("");
		tcv.getJtDataLength().getText();
		tcv.getJtDataLength().setText("");
		tcv.getJtConstraintName().getText();
		tcv.getJtConstraintName().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == tcv.getJcDatatype()) {
			selectDataType = selectName(tcv.getJcDatatype());
			System.out.println("데이터형 선택 : " + selectDataType);
		} // 데이터타입 콤보박스 선택 이름 전달

		if (ae.getSource() == tcv.getJcConstraint()) {
			selectConstraint = selectName(tcv.getJcConstraint());
			System.out.println("제약사항 선택 : " + selectConstraint);
		} // 제약사항 콤보박스 선택 이름 전달

		if (ae.getSource() == tcv.getJbTableAdd()) {
			addQueryToCreateTable();
		} // 테이블 추가

		if (ae.getSource() == tcv.getJbConstraintAdd()) {
			try {
				addQueryToColumn();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(tcv, "데이터 크기는 1이상의 정수만 입력 가능합니다");
			} // end catch
		} // 데이터크기 정수

		if (ae.getSource() == tcv.getJbTableCreate()) {
			if (flag) {
				createTableToQuery();
			} else {
				JOptionPane.showMessageDialog(tcv, "쿼리 추가 버튼을 최소 1회 실행한 뒤 테이블 생성을 해야합니다.");
			} // end else
		} // 테이블 생성

		if (ae.getSource() == tcv.getJbClear()) {
			resetAll();
		} // 초기화
	}

	@Override
	public void windowClosing(WindowEvent e) {
		tcv.dispose();
	}// windowClosing
}// class
