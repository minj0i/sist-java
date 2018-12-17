package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MVC pattern�� ������� �� Component�� ���
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener, MouseListener/* , ListSelectionListener */ {

	private JList<String> jl; // View�� �ش�
	private DefaultListModel<String> dlm; // Model�� �ش�

	private JLabel jlOutput;
	private JButton jb;

	public UseJList() {
		super("JList���");
		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScriptE");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);

		// ScrollBar�� ���� JList�� ScrollBar ����
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("���");
		jlOutput.setBorder(new TitledBorder("���þ�����"));

		jb = new JButton("�Է�");

		add("North", jb);
		add("Center", jsp);// ������Ʈ�� ���� ��ũ�ѹ� ��ü�� ��ġ(jl->jsp)
		add("South", jlOutput);

		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseJList

	@Override
	public void actionPerformed(ActionEvent ae) {
		String lang = JOptionPane.showInputDialog("��ǻ�� ���߰��� �� �Է�");
		System.out.println("---" + lang);
		// �Էµ������̹Ƿ� Model��ü�� ����Ѵ�.
		if (lang != null && !lang.equals("")) {// null�� �տ� ��� ��.
			// null�� ���� ���� ���� �ʾƼ� equals("")�� ���� ���� �־��� �� ��� ������ ��
			dlm.addElement(lang);
		}
	}// actionPerformed

//	private boolean flag;
//
//	@Override
//	public void valueChanged(ListSelectionEvent lse) { //�ѹ� ���������� �̺�Ʈ�� �ι��� �߻�
//		// ���õ� ������(JList)�� ��(DefaultTableModel)�� ���ͼ�
////		i++; //instance������ �����ϰ� i++�� �־�� s.y.o���� �ѹ� ����. i�� 21��� ������ ó���� ����
//
//		if (flag) {//�ȿ� ���� �⺻������ true�� ���� ������ ==�Ƚ��൵ ��
//			int idx = jl.getSelectedIndex(); //idx�� �ָ� list�� ������ �ѹ��ۿ� ���ϰ� �Ʒ������� �� �� ����=����Ƚ���� �ش�=�ڵ��� ȿ���� ���
//			String value = dlm.get(idx);
//			// JLabel�� �߰�
//			jlOutput.setText(value);
//			// ���õ� ���� ����
////			System.out.println("---"+idx+" / "+dlm.size());
//			System.out.println(dlm.remove(idx));
//		} // end if
//		flag = !flag;
//	}// valueChanged

	@Override
	public void mouseClicked(MouseEvent e) {
		int idx = jl.getSelectedIndex(); //idx�� �ָ� list�� ������ �ѹ��ۿ� ���ϰ� �Ʒ������� �� �� ����=����Ƚ���� �ش�=�ڵ��� ȿ���� ���
		String value = dlm.get(idx);
		// JLabel�� �߰�
		jlOutput.setText(value);
		// ���õ� ���� ����
		dlm.remove(idx);
		System.out.println("����!!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) { //Ư�������� ���� ��
	}

	@Override
	public void mouseExited(MouseEvent e) { //���콺 �����Ͱ� ���������� ������ ��
	}

	public static void main(String[] args) {
		new UseJList();
	}// main

}// class
