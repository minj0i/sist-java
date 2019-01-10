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

	// ������ ������ �̸� �����ϴ� ��
	public String selectName(JComboBox<String> jcb) {
		String selectedName = "";
		selectedName = jcb.getSelectedItem().toString();

		return selectedName;
	}

	// ���̺� �߰� ���� �� �۵��ϴ� �޼���
	public void addQueryToCreateTable() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv.getQueryView();
		String tableName = tcv.getJtTableName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") != -1) {
			JOptionPane.showMessageDialog(tcv, "�̹� create ������ �ֽ��ϴ�.");
			return;
		}

		if (tableName.equals("")) {
			JOptionPane.showMessageDialog(tcv, "���̺���� �Է��ϼ���");
			return;
		}

		sb.append("create table ").append(tableName).append("(\n").append(");");

		jta.setText(sb.toString());// jta�� ����
	}//

	// �÷� �߰� ���� �� �۵��ϴ� �޼���
	public void addQueryToColumn() throws NumberFormatException {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv.getQueryView();
		String columnName = tcv.getJtColumnName().getText();
		int dataSize = Integer.parseInt(tcv.getJtDataLength().getText());
		String constraintName = tcv.getJtConstraintName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") == -1) {
			JOptionPane.showMessageDialog(tcv, "���̺�� �߰� ��ư�� ���� ��������.");
			return;
		}
		if (columnName.equals("")) {
			JOptionPane.showMessageDialog(tcv, "�÷����� �Է��ϼ���");
			return;
		}
		if (sb.lastIndexOf(columnName) != -1) {
			JOptionPane.showMessageDialog(tcv, "�̹� ���� �̸��� �÷����� �ֽ��ϴ�.");
			return;
		}

		if (dataSize < 1) {
			JOptionPane.showMessageDialog(tcv, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
			return;
		}

		if (constraintName.equals("")) {
			JOptionPane.showMessageDialog(tcv, "������׸��� �Է��ϼ���");
			return;
		}
		if (sb.lastIndexOf(constraintName) != -1) {
			JOptionPane.showMessageDialog(tcv, "�̹� ���� �̸��� ������׸��� �ֽ��ϴ�.");
			return;
		}

		//////////// ����ó�� //////////////////////////////////////////////////////////////

		// ���� ���� varchar2, char, number, date �� 1���� ���� ��
		if (sb.lastIndexOf("varchar2") == -1 && sb.lastIndexOf("char") == -1 && sb.lastIndexOf("number") == -1
				&& sb.lastIndexOf("date") == -1) {
			sb.delete(sb.lastIndexOf(")"), sb.length());// �� �� ��ȣ�� ����� append ��Ų��.
		} else {// ���ʽ����� �ƴ� ��
			sb.delete(sb.lastIndexOf(")") - 1, sb.length());// �� �ް�ȣ�� �ٹٲ��� �����
			sb.append(",\n");// �ĸ��� �ٹٲ��� ���� �� append ��Ų��.
		}

		if (selectConstraint.equals("null") || selectConstraint.equals("not null")) {// ��������� null �Ǵ� not null�� ��
																						// (������׸��� �ʿ� ����
			if (selectDataType.equals("date")) {// date�� �÷��� ���� �� (���̺� ������ ũ�⿡ ������� date�� ������ �ϴ� �� ���� ;;
				sb.append("  ").append(columnName).append(" ").append("date default (sysdate) ")
						.append(selectConstraint);
			} else {// date�� �÷��� �ȸ��鶧
				sb.append("  ").append(columnName).append(" ").append(selectDataType).append("(").append(dataSize)
						.append(") ").append(selectConstraint);
			}
		} else {
			if (selectDataType.equals("date")) {// date�� �÷��� ���� ��(���̺� ������ ũ�⿡ ������� date�� ������ �ϴ� �� ���� ;;
				sb.append("  ").append(columnName).append(" ").append("date default (sysdate) ").append("constraint ")
						.append(constraintName).append(" ").append(selectConstraint);
			} else {
				sb.append("  ").append(columnName).append(" ").append(selectDataType).append("(").append(dataSize)
						.append(") ").append("constraint ").append(constraintName).append(" ").append(selectConstraint);
			}
		}
		sb.append("\n);");

		flag = true;// ������ �ּ� 1�� �����Ѱ� Ȯ���ϴ� �ν��Ͻ� ����
		jta.setText(sb.toString());// jta�� ����
	}

	// ���̺� ���� ���� �� �۵��ϴ� �޼��� (����ó�� �߰��� �� ����
	public void createTableToQuery() {
		try {
			WriteQueryDAO.getInstance().createTable(tcv.getQueryView().getText());
			JOptionPane.showMessageDialog(tcv, "���̺��� �����Ǿ����ϴ�.");
		} catch (SQLException se) {
			String errMsg = "";

			switch (se.getErrorCode()) {
			case 910:
				errMsg = "���������� ������ ���̰� �ʹ� ��ϴ�.";
				break;
			case 955:
				errMsg = "���� �̸��� ���̺��� �����մϴ�.";
				break;
			case 1727:
				errMsg = "��ġ�� ���� ����(38 �ڸ� �̳�)�� �ʰ��߽��ϴ�.";
				break;
			case 2260:
				errMsg = "���̺��� �ϳ��� �⺻ Ű�� ���� �� �ֽ��ϴ�.";
				break;
			case 2264:
				errMsg = "������ ���࿡ ���� �̸��Դϴ�.";
				break;
			default:
				errMsg = "����ġ ���� ������ �߻��߽��ϴ�.\n�����ڵ� : " + se.getErrorCode();
			}

			JOptionPane.showMessageDialog(tcv, errMsg);
			se.printStackTrace();
		}
	}

	// �ʱ�ȭ ���� �� �۵��ϴ� �޼���
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
			System.out.println("�������� ���� : " + selectDataType);
		} // ������Ÿ�� �޺��ڽ� ���� �̸� ����

		if (ae.getSource() == tcv.getJcConstraint()) {
			selectConstraint = selectName(tcv.getJcConstraint());
			System.out.println("������� ���� : " + selectConstraint);
		} // ������� �޺��ڽ� ���� �̸� ����

		if (ae.getSource() == tcv.getJbTableAdd()) {
			addQueryToCreateTable();
		} // ���̺� �߰�

		if (ae.getSource() == tcv.getJbConstraintAdd()) {
			try {
				addQueryToColumn();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(tcv, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
			} // end catch
		} // ������ũ�� ����

		if (ae.getSource() == tcv.getJbTableCreate()) {
			if (flag) {
				createTableToQuery();
			} else {
				JOptionPane.showMessageDialog(tcv, "���� �߰� ��ư�� �ּ� 1ȸ ������ �� ���̺� ������ �ؾ��մϴ�.");
			} // end else
		} // ���̺� ����

		if (ae.getSource() == tcv.getJbClear()) {
			resetAll();
		} // �ʱ�ȭ
	}

	@Override
	public void windowClosing(WindowEvent e) {
		tcv.dispose();
	}// windowClosing
}// class
