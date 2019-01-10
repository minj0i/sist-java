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

	// ������ ������ �̸� �����ϴ� ��
	public String selectName(JComboBox<String> jcb) {
		String selectedName = "";
		selectedName = jcb.getSelectedItem().toString();

		return selectedName;
	}

	// ���̺� �߰� ���� �� �۵��ϴ� �޼���
	public void addQueryToCreateTable() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String tableName = tcv2.getJtTableName().getText();
		sb.append(jta.getText());

		// ���̺� ù��° ��������
		if (sb.lastIndexOf("create") != -1) {
			JOptionPane.showMessageDialog(tcv2, "�̹� create ������ �ֽ��ϴ�.");
			return;
		}

		// ���̺� �߰�
		if (tableName.equals("")) {
			JOptionPane.showMessageDialog(tcv2, "���̺���� �Է��ϼ���");
			return;
		}
		sb.append("create table ").append(tableName).append("(\n").append(");");
		jta.setText(sb.toString());// jta�� ����
	}

	// �÷� �߰� ���� �� �۵��ϴ� �޼���
	public void addQueryToColumn() throws NumberFormatException {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String columnName = tcv2.getJtColumnName().getText();
		int dataSize = Integer.parseInt(tcv2.getJtDataLength().getText());
		String constraintName = tcv2.getJtConstraintName().getText();
		sb.append(jta.getText());
		selectDataType = selectName(tcv2.getJcDatatype());
		selectConstraint = selectName(tcv2.getJcConstraint());

		// ���̺��� ������ ����
		if (sb.lastIndexOf("create") == -1) {
			JOptionPane.showMessageDialog(tcv2, "���̺�� �߰� ��ư�� ���� ��������.");
			return;
		}

		// �÷��� �Է�
		if (columnName.equals("")) {
			JOptionPane.showMessageDialog(tcv2, "�÷����� �Է��ϼ���");
			return;
		}
		// �÷��� �ߺ� ����
		if (sb.lastIndexOf(columnName) != -1) {
			JOptionPane.showMessageDialog(tcv2, "�̹� ���� �̸��� �÷����� �ֽ��ϴ�.");
			return;
		}

		// ó�� �÷����� �Է��ϴ� ���
		if (sb.lastIndexOf("varchar2") == -1 && sb.lastIndexOf("char") == -1 && sb.lastIndexOf("number") == -1
				&& sb.lastIndexOf("date") == -1) {
			// �� �� Date�� ���
			if (selectDataType.equals("Date")) {
				insertDate();
			} else {// Date�� �ƴ� ���
				inputException();
				insertNotDate();
			}
			sb.delete(sb.lastIndexOf(")"), sb.length());// end if
		} else {
			// ó�� �÷��� �Է��� �ƴ� ���
			sb.delete(sb.lastIndexOf(")") - 1, sb.length());// �� �ް�ȣ�� �ٹٲ��� �����
			// �� �� Date�� ���
			if (selectDataType.equals("Date")) {
				insertDate();
				return;
			} else {// Date�� �ƴ� ���
				inputException();
				insertNotDate();
			}
			sb.append(",\n");// �ĸ��� �ٹٲ��� ���� �� append ��Ų��.
		}//end if
		
		sb.append("\n);");
		flag = true;// ������ �ּ� 1�� �����Ѱ� Ȯ���ϴ� �ν��Ͻ� ����
		jta.setText(sb.toString());// jta�� ����
	}//addQueryToColumn	

	// Date���� �߰�
	public void insertDate() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String columnName = tcv2.getJtColumnName().getText();
		String constraintName = tcv2.getJtConstraintName().getText();
		sb.append(jta.getText());
		selectDataType = selectName(tcv2.getJcDatatype());
		selectConstraint = selectName(tcv2.getJcConstraint());

		// ��������� �ִ� ���
		if (!selectConstraint.equals("null") || !selectConstraint.equals("not null")) {
			sb.append("  ").append(columnName).append(" ").append("date default (sysdate) ").append(selectConstraint)
					.append(constraintName);
		} else {// ��������� ���� ���
			sb.append("  ").append(columnName);
		} // end if
	}// insertDate

	// Date���� �ƴ� �� �߰�
	public void insertNotDate() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = tcv2.getQueryView();
		String columnName = tcv2.getJtColumnName().getText();
		String constraintName = tcv2.getJtConstraintName().getText();
		sb.append(jta.getText());
		int dataSize = Integer.parseInt(tcv2.getJtDataLength().getText());
		selectDataType = selectName(tcv2.getJcDatatype());
		selectConstraint = selectName(tcv2.getJcConstraint());

		// ��������� �ִ� ���
		if (!selectConstraint.equals("null") || !selectConstraint.equals("not null")) {
			sb.append("  ").append(columnName).append(" ").append("(").append(dataSize).append(") ").append("  ")
					.append(selectConstraint).append("  ").append(constraintName);
		} else {// ��������� ���� ���
			sb.append("  ").append(columnName).append(" ").append("(").append(dataSize).append(") ");
		} // end if
	}// insertDate

	// ������� ��� ����ó�� �޼ҵ�
	public void inputException() {
		StringBuilder sb = new StringBuilder();
		String constraintName = tcv2.getJtConstraintName().getText();
		int dataSize = Integer.parseInt(tcv2.getJtDataLength().getText());

		if (dataSize < 1) {
			JOptionPane.showMessageDialog(tcv2, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
			return;
		}

		if (constraintName.equals("")) {
			JOptionPane.showMessageDialog(tcv2, "������׸��� �Է��ϼ���");
			return;
		}
		if (sb.lastIndexOf(constraintName) != -1) {
			JOptionPane.showMessageDialog(tcv2, "�̹� ���� �̸��� ������׸��� �ֽ��ϴ�.");
			return;
		}
	}

	// ���̺� ���� ���� �� �۵��ϴ� �޼��� (����ó�� �߰��� �� ����
	public void createTableToQuery() {
		try {
			WriteQueryDAO.getInstance().createTable(tcv2.getQueryView().getText());
			JOptionPane.showMessageDialog(tcv2, "���̺��� �����Ǿ����ϴ�.");
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

			JOptionPane.showMessageDialog(tcv2, errMsg);
			se.printStackTrace();
		}
	}

	// �ʱ�ȭ ���� �� �۵��ϴ� �޼���
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
			System.out.println("�������� ���� : " + selectDataType);
		} // ������Ÿ�� �޺��ڽ� ���� �̸� ����

		if (ae.getSource() == tcv2.getJcConstraint()) {
			selectConstraint = selectName(tcv2.getJcConstraint());
			System.out.println("������� ���� : " + selectConstraint);
		} // ������� �޺��ڽ� ���� �̸� ����

		if (ae.getSource() == tcv2.getJbTableAdd()) {
			addQueryToCreateTable();
		} // ���̺� �߰�

		if (ae.getSource() == tcv2.getJbConstraintAdd()) {
			try {
				addQueryToColumn();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(tcv2, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
			} // end catch
		} // ���̺� �߰�
		
		if (ae.getSource() == tcv2.getJbTableCreate()) {
			if (flag) {
				try {
					addQueryToColumn();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(tcv2, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
				} // end catch
			} else {
				JOptionPane.showMessageDialog(tcv2, "���� �߰� ��ư�� �ּ� 1ȸ ������ �� ���̺� ������ �ؾ��մϴ�.");
			} // end else
		} // ���̺� ����
		
		if (ae.getSource() == tcv2.getJbClear()) {
			resetAll();
		} // �ʱ�ȭ
	}

	@Override
	public void windowClosing(WindowEvent e) {
		tcv2.dispose();
	}// windowClosing
}// class
