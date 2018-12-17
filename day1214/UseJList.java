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
 * MVC pattern을 기반으로 한 Component의 사용
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener, MouseListener/* , ListSelectionListener */ {

	private JList<String> jl; // View에 해당
	private DefaultListModel<String> dlm; // Model에 해당

	private JLabel jlOutput;
	private JButton jb;

	public UseJList() {
		super("JList사용");
		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScriptE");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);

		// ScrollBar가 없는 JList에 ScrollBar 설정
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("출력");
		jlOutput.setBorder(new TitledBorder("선택아이템"));

		jb = new JButton("입력");

		add("North", jb);
		add("Center", jsp);// 컴포넌트를 가진 스크롤바 객체를 배치(jl->jsp)
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
		String lang = JOptionPane.showInputDialog("컴퓨터 개발관련 언어를 입력");
		System.out.println("---" + lang);
		// 입력데이터이므로 Model객체를 사용한다.
		if (lang != null && !lang.equals("")) {// null을 앞에 써야 함.
			// null이 들어가면 값이 들어가지 않아서 equals("")에 비교할 값을 넣어줄 수 없어서 에러가 뜸
			dlm.addElement(lang);
		}
	}// actionPerformed

//	private boolean flag;
//
//	@Override
//	public void valueChanged(ListSelectionEvent lse) { //한번 누를때마다 이벤트가 두번씩 발생
//		// 선택된 아이템(JList)의 값(DefaultTableModel)을 얻어와서
////		i++; //instance변수로 설정하고 i++를 넣어야 s.y.o에서 한번 찍힘. i가 21억번 넘으면 처리를 못함
//
//		if (flag) {//안에 들어가면 기본값으로 true를 갖기 때문에 ==안써줘도 됨
//			int idx = jl.getSelectedIndex(); //idx로 주면 list에 접근을 한번밖에 안하고 아래에서도 쓸 수 있음=접근횟수가 준다=코드의 효율성 향상
//			String value = dlm.get(idx);
//			// JLabel에 추가
//			jlOutput.setText(value);
//			// 선택된 값을 삭제
////			System.out.println("---"+idx+" / "+dlm.size());
//			System.out.println(dlm.remove(idx));
//		} // end if
//		flag = !flag;
//	}// valueChanged

	@Override
	public void mouseClicked(MouseEvent e) {
		int idx = jl.getSelectedIndex(); //idx로 주면 list에 접근을 한번밖에 안하고 아래에서도 쓸 수 있음=접근횟수가 준다=코드의 효율성 향상
		String value = dlm.get(idx);
		// JLabel에 추가
		jlOutput.setText(value);
		// 선택된 값을 삭제
		dlm.remove(idx);
		System.out.println("삭제!!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) { //특정영역에 들어갔을 때
	}

	@Override
	public void mouseExited(MouseEvent e) { //마우스 포인터가 영역밖으로 나갔을 때
	}

	public static void main(String[] args) {
		new UseJList();
	}// main

}// class
