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

public class TableCreateViewEvt2 extends WindowAdapter implements ActionListener {
	private TableCreateView2 tcv2;
	private String selectDataType;
	private String selectConstraint;
	private boolean flag;

	public TableCreateViewEvt2(TableCreateView2 tcv2) {
		this.tcv2 = tcv2;
		flag = false;

		tcv2.getJcDatatype().addItem("varchar2");
		tcv2.getJcDatatype().addItem("char");
		tcv2.getJcDatatype().addItem("number");
		tcv2.getJcDatatype().addItem("date");

		tcv2.getJcConstraint().addItem("null");
		tcv2.getJcConstraint().addItem("primary key");
		tcv2.getJcConstraint().addItem("unique");

		tcv2.getJcConstraint().addItem("not null");

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
		JTextArea jta = tcv2.getQueryView();
		String tableName = tcv2.getJtTableName().getText();
		sb.append(jta.getText());

		// 테이블 첫번째 생성인지
		if (sb.lastIndexOf("create") != -1) {
			JOptionPane.showMessageDialog(tcv2, "이미 create 쿼리가 있습니다.");
			return;
		}

		// 테이블 추가
		if (tableName.equals("")) {
			JOptionPane.showMessageDialog(tcv2, "테이블명을 입력하세요");
			return;
		}
		sb.append("create table ").append(tableName).append("(\n").append(");");
		jta.setText(sb.toString());// jta에 적용
	}

	// 컬럼 추가 누를 시 작동하는 메서드
	public void addQueryToColumn() throws NumberFormatException {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String columnName = tcv2.getJtColumnName().getText();
		int dataSize = Integer.parseInt(tcv2.getJtDataLength().getText());
		String constraintName = tcv2.getJtConstraintName().getText();
		sb.append(jta.getText());
		selectDataType = selectName(tcv2.getJcDatatype());
		selectConstraint = selectName(tcv2.getJcConstraint());

		// 테이블이 생성이 먼저
		if (sb.lastIndexOf("create") == -1) {
			JOptionPane.showMessageDialog(tcv2, "테이블명 추가 버튼을 먼저 누르세요.");
			return;
		}

		// 컬럼명 입력
		if (columnName.equals("")) {
			JOptionPane.showMessageDialog(tcv2, "컬럼명을 입력하세요");
			return;
		}
		// 컬럼명 중복 배제
		if (sb.lastIndexOf(columnName) != -1) {
			JOptionPane.showMessageDialog(tcv2, "이미 같은 이름의 컬럼명이 있습니다.");
			return;
		}

		// 처음 컬럼명을 입력하는 경우
		if (sb.lastIndexOf("varchar2") == -1 && sb.lastIndexOf("char") == -1 && sb.lastIndexOf("number") == -1
				&& sb.lastIndexOf("date") == -1) {
			// 그 중 Date인 경우
			if (selectDataType.equals("Date")) {
				insertDate();
			} else {// Date가 아닌 경우
				inputException();
				insertNotDate();
			}
			sb.delete(sb.lastIndexOf(")"), sb.length());// end if
		} else {
			// 처음 컬럼명 입력이 아닌 경우
			sb.delete(sb.lastIndexOf(")") - 1, sb.length());// 맨 뒷괄호와 줄바꿈을 지우고
			// 그 중 Date인 경우
			if (selectDataType.equals("Date")) {
				insertDate();
				return;
			} else {// Date가 아닌 경우
				inputException();
				insertNotDate();
			}
			sb.append(",\n");// 컴마와 줄바꿈을 붙인 뒤 append 시킨다.
		}//end if
		
		sb.append("\n);");
		flag = true;// 쿼리를 최소 1번 실행한걸 확인하는 인스턴스 변수
		jta.setText(sb.toString());// jta에 적용
	}//addQueryToColumn	

	// Date형식 추가
	public void insertDate() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String columnName = tcv2.getJtColumnName().getText();
		String constraintName = tcv2.getJtConstraintName().getText();
		sb.append(jta.getText());
		selectDataType = selectName(tcv2.getJcDatatype());
		selectConstraint = selectName(tcv2.getJcConstraint());

		// 제약사항이 있는 경우
		if (!selectConstraint.equals("null") || !selectConstraint.equals("not null")) {
			sb.append("  ").append(columnName).append(" ").append("date default (sysdate) ").append(selectConstraint)
					.append(constraintName);
		} else {// 제약사항이 없는 경우
			sb.append("  ").append(columnName);
		} // end if
	}// insertDate

	// Date형식 아닌 것 추가
	public void insertNotDate() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String columnName = tcv2.getJtColumnName().getText();
		String constraintName = tcv2.getJtConstraintName().getText();
		sb.append(jta.getText());
		int dataSize = Integer.parseInt(tcv2.getJtDataLength().getText());
		selectDataType = selectName(tcv2.getJcDatatype());
		selectConstraint = selectName(tcv2.getJcConstraint());

		// 제약사항이 있는 경우
		if (!selectConstraint.equals("null") || !selectConstraint.equals("not null")) {
			sb.append("  ").append(columnName).append(" ").append("(").append(dataSize).append(") ").append("  ")
					.append(selectConstraint).append("  ").append(constraintName);
		} else {// 제약사항이 없는 경우
			sb.append("  ").append(columnName).append(" ").append("(").append(dataSize).append(") ");
		} // end if
	}// insertDate

	// 비어있을 경우 예외처리 메소드
	public void inputException() {
		StringBuilder sb = new StringBuilder();
		String constraintName = tcv2.getJtConstraintName().getText();
		int dataSize = Integer.parseInt(tcv2.getJtDataLength().getText());

		if (dataSize < 1) {
			JOptionPane.showMessageDialog(tcv2, "데이터 크기는 1이상의 정수만 입력 가능합니다");
			return;
		}

		if (constraintName.equals("")) {
			JOptionPane.showMessageDialog(tcv2, "제약사항명을 입력하세요");
			return;
		}
		if (sb.lastIndexOf(constraintName) != -1) {
			JOptionPane.showMessageDialog(tcv2, "이미 같은 이름의 제약사항명이 있습니다.");
			return;
		}
	}

	// 테이블 생성 누를 시 작동하는 메서드 (예외처리 추가할 게 많음
	public void createTableToQuery() {
		try {
			WriteQueryDAO.getInstance().createTable(tcv2.getQueryView().getText());
			JOptionPane.showMessageDialog(tcv2, "테이블이 생성되었습니다.");
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

			JOptionPane.showMessageDialog(tcv2, errMsg);
			se.printStackTrace();
		}
	}

	// 초기화 누를 시 작동하는 메서드
	public void resetAll() {
		tcv2.getQueryView().getText();
		tcv2.getQueryView().setText("");
		tcv2.getJtTableName().getText();
		tcv2.getJtTableName().setText("");
		tcv2.getJtColumnName().getText();
		tcv2.getJtColumnName().setText("");
		tcv2.getJtDataLength().getText();
		tcv2.getJtDataLength().setText("");
		tcv2.getJtConstraintName().getText();
		tcv2.getJtConstraintName().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == tcv2.getJcDatatype()) {
			selectDataType = selectName(tcv2.getJcDatatype());
			System.out.println("데이터형 선택 : " + selectDataType);
		} // 데이터타입 콤보박스 선택 이름 전달

		if (ae.getSource() == tcv2.getJcConstraint()) {
			selectConstraint = selectName(tcv2.getJcConstraint());
			System.out.println("제약사항 선택 : " + selectConstraint);
		} // 제약사항 콤보박스 선택 이름 전달

		if (ae.getSource() == tcv2.getJbTableAdd()) {
			addQueryToCreateTable();
		} // 테이블 추가

		if (ae.getSource() == tcv2.getJbConstraintAdd()) {
			try {
				addQueryToColumn();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(tcv2, "데이터 크기는 1이상의 정수만 입력 가능합니다");
			} // end catch
		} // 테이블 추가
		
		if (ae.getSource() == tcv2.getJbTableCreate()) {
			if (flag) {
				try {
					addQueryToColumn();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(tcv2, "데이터 크기는 1이상의 정수만 입력 가능합니다");
				} // end catch
			} else {
				JOptionPane.showMessageDialog(tcv2, "쿼리 추가 버튼을 최소 1회 실행한 뒤 테이블 생성을 해야합니다.");
			} // end else
		} // 테이블 생성
		
		if (ae.getSource() == tcv2.getJbClear()) {
			resetAll();
		} // 초기화
	}

	@Override
	public void windowClosing(WindowEvent e) {
		tcv2.dispose();
	}// windowClosing
}// class
