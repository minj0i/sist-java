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
	private boolean flag;// ������ �ּ� 1�� �����Ѱ� Ȯ���ϴ� �ν��Ͻ� ����

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

	// ������ ������ �̸� �����ϴ� ��
	public String selectName(JComboBox<String> jcb) {
		String selectedName = "";
		selectedName = jcb.getSelectedItem().toString();

		return selectedName;
	}

	// ���̺� �߰� ���� �� �۵��ϴ� �޼���
	public void addQueryToCreateTable() {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = wqv.getJtaQueryView();
		String tableName = wqv.getjtfTableName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") != -1) {
			JOptionPane.showMessageDialog(wqv, "�̹� create ������ �ֽ��ϴ�.");
			return;
		}

		if (tableName.equals("")) {
			JOptionPane.showMessageDialog(wqv, "���̺���� �Է��ϼ���");
			return;
		}

		sb.append("create table ").append(tableName).append("(\n").append(");");

		jta.setText(sb.toString());// jta�� ����
	}

	// �÷� �߰� ���� �� �۵��ϴ� �޼���
	public void addQueryToColumn() throws NumberFormatException {
		StringBuilder sb = new StringBuilder();
		JTextArea jta = wqv.getJtaQueryView();
		String columnName = wqv.getjtfColumnName().getText();
		int dataSize = Integer.parseInt(wqv.getjtfDataSize().getText());
		String constructName = wqv.getjtfConstraintName().getText();
		sb.append(jta.getText());

		if (sb.lastIndexOf("create") == -1) {
			JOptionPane.showMessageDialog(wqv, "���̺�� �߰� ��ư�� ���� ��������.");
			return;
		}
		if (columnName.equals("")) {
			JOptionPane.showMessageDialog(wqv, "�÷����� �Է��ϼ���");
			return;
		}
		if (sb.lastIndexOf(columnName) != -1) {
			JOptionPane.showMessageDialog(wqv, "�̹� ���� �̸��� �÷����� �ֽ��ϴ�.");
			return;
		}

		if (dataSize < 1) {
			JOptionPane.showMessageDialog(wqv, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
			return;
		}
		if (constructName.equals("")) {
			JOptionPane.showMessageDialog(wqv, "������׸��� �Է��ϼ���");
			return;
		}
		if (sb.lastIndexOf(constructName) != -1) {
			JOptionPane.showMessageDialog(wqv, "�̹� ���� �̸��� ������׸��� �ֽ��ϴ�.");
			return;
		}////////////����ó�� //////////////////////////////////////////////////////////////

		
		
		// ���� ���� varchar2, char, number, date �� 1���� ���� ��
		if (sb.lastIndexOf("varchar2") == -1 && sb.lastIndexOf("char") == -1 && sb.lastIndexOf("number") == -1
				&& sb.lastIndexOf("date") == -1) {
			sb.delete(sb.lastIndexOf(")"), sb.length());// �� �� ��ȣ�� ����� append ��Ų��.
		} else {// ���ʽ����� �ƴ� ��
			sb.delete(sb.lastIndexOf(")") - 1, sb.length());// �� �ް�ȣ�� �ٹٲ��� �����
			sb.append(",\n");// �ĸ��� �ٹٲ��� ���� �� append ��Ų��.
		}

		
		if (selectConstraint.equals("null") || selectConstraint.equals("not null")) {//��������� null �Ǵ� not null�� �� (������� ���� �ʿ� ���� 
			if (selectDataType.equals("date")) {// date�� �÷��� ���� �� (���̺� ������ ũ�⿡ ������� date�� ������ �ϴ� �� ���� ;; 
				sb.append("  ")
				.append(columnName).append(" ")
				.append("date default (sysdate) ")
				.append(selectConstraint);
			} else {// date�� �÷��� �ȸ��鶧
				sb.append("  ")
				.append(columnName).append(" ")
				.append(selectDataType).append("(").append(dataSize).append(") ")
				.append(selectConstraint);
			}
		} else {
			if (selectDataType.equals("date")) {// date�� �÷��� ���� ��(���̺� ������ ũ�⿡ ������� date�� ������ �ϴ� �� ���� ;; 
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
		

		flag = true;// ������ �ּ� 1�� �����Ѱ� Ȯ���ϴ� �ν��Ͻ� ����
		jta.setText(sb.toString());// jta�� ����

	}

	// ���̺� ���� ���� �� �۵��ϴ� �޼��� (����ó�� �߰��� �� ����
	public void createTableToQuery() {
		try {
			WriteQueryDAO.getInstance().createTable(wqv.getJtaQueryView().getText());
			JOptionPane.showMessageDialog(wqv, "���̺��� �����Ǿ����ϴ�.");
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

			JOptionPane.showMessageDialog(wqv, errMsg);
			se.printStackTrace();
		}
	}

	// �ʱ�ȭ ���� �� �۵��ϴ� �޼���
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
			System.out.println("�������� ���� : " + selectDataType);
		} // �Ϸ�

		if (ae.getSource() == wqv.getJcbConstraintSelect()) {
			selectConstraint = selectName(wqv.getJcbConstraintSelect());
			System.out.println("������� ���� : " + selectConstraint);
		} // �Ϸ�

		if (ae.getSource() == wqv.getJbtTableAdd()) {
			addQueryToCreateTable();
		} // �Ϸ�

		if (ae.getSource() == wqv.getJbtColumnAdd()) {
			try {
				addQueryToColumn();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(wqv, "������ ũ��� 1�̻��� ������ �Է� �����մϴ�");
			}
		} // �Ϸ�

		if (ae.getSource() == wqv.getJbtTableCreate()) {
			if (flag) {
				createTableToQuery();
			} else {
				JOptionPane.showMessageDialog(wqv, "���� �߰� ��ư�� �ּ� 1ȸ ������ �� ���̺� ������ �ؾ��մϴ�.");
			}
		}

		if (ae.getSource() == wqv.getJbtReset()) {
			resetAll();
		} // �Ϸ�

	}

	@Override
	public void windowClosing(WindowEvent e) {
		wqv.dispose();
	}

}
