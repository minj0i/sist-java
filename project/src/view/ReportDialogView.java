package view;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import evt.MainControlEvt;
import evt.ReportDialogEvt;

@SuppressWarnings("serial")
public class ReportDialogView extends Dialog {
	private JLabel jlNum1, jlNum2, jlNum3, jlNum4,jlNum5, jlNum6;
	private JTextArea report1, report2, report3, report4, report5, report6;
	private MainControlEvt mce;
		
	public ReportDialogView(MainControlEvt mce) {
		super(mce.getMcv(), "�α׺м�-���â", true);
		this.mce = mce;
		String issue6Lange = String.valueOf(mce.getStartLine()) + " ~ " + String.valueOf(mce.getEndLine());
		
		jlNum1 = new JLabel("1.	�ִٻ�� Ű�� �̸��� Ƚ��");
		jlNum2 = new JLabel("2.	�������� ����Ƚ��, ����");
		jlNum3 = new JLabel("3. ���񽺸� ���������� ������ Ƚ���� ����(404) Ƚ��");
		jlNum4 = new JLabel("4. ��û�� ���� ���� �ð�");
		jlNum5 = new JLabel("5. ���������� ��û(403)�� �߻��� Ƚ��, ���� ���ϱ�");
		jlNum6 = new JLabel("<html>6. �Էµ� ���� ("+ issue6Lange +") �� �ش��ϴ� �������<br>�ִٻ�� Ű�� �̸��� Ƚ�� ");
		report1 = new JTextArea("");
		report2 = new JTextArea("");
		JScrollPane jsp2 = new JScrollPane(report2);
		report3 = new JTextArea("");
		report4 = new JTextArea("");
		report5 = new JTextArea("");
		report6 = new JTextArea("");
		JButton jbtnClose = new JButton("�ݱ�");
		
		JPanel dialogView = new JPanel();
		
		dialogView.setLayout(null);
		
		
		dialogView.add(jlNum1);
		dialogView.add(jlNum2);
		dialogView.add(jlNum3);
		dialogView.add(jlNum4);
		dialogView.add(jlNum5);
		dialogView.add(jlNum6);
		dialogView.add(report1);
		dialogView.add(jsp2);
		dialogView.add(report3);
		dialogView.add(report4);
		dialogView.add(report5);
		dialogView.add(report6);
		add("Center",dialogView);
		add("South", jbtnClose);
		
		jlNum1.setBounds(20,20,380,30);
		jlNum2.setBounds(20,100,380,30);
		jlNum3.setBounds(20,220,380,30);
		jlNum4.setBounds(20,300,380,30);
		jlNum5.setBounds(20,380,380,30);
		jlNum6.setBounds(20,460,380,40);
		
		report1.setBounds(20,50,300,40);
		jsp2.setBounds(20,130,300,80);
		report3.setBounds(20,250,300,40);
		report4.setBounds(20,330,300,40);
		report5.setBounds(20,410,300,40);
		report6.setBounds(20,510,300,40);
	
		//�̺�Ʈ ���
		ReportDialogEvt rde = new ReportDialogEvt(this);
		
		addWindowListener(rde);
		jbtnClose.addActionListener(rde);
		
		setBounds(mce.getMcv().getX()+150, mce.getMcv().getY()+80, 400, 630);
		setResizable(false);
		report1.setEditable(false);
		report2.setEditable(false);
		report3.setEditable(false);
		report4.setEditable(false);
		report5.setEditable(false);
		report6.setEditable(false);
		setVisible(true);
	}//LogAnalysisView

	public MainControlEvt getMce() {
		return mce;
	}

	public JTextArea getReport1() {
		return report1;
	}

	public JTextArea getReport2() {
		return report2;
	}

	public JTextArea getReport3() {
		return report3;
	}

	public JTextArea getReport4() {
		return report4;
	}

	public JTextArea getReport5() {
		return report5;
	}

	public JTextArea getReport6() {
		return report6;
	}

	
	
}//LogAnalysisView
