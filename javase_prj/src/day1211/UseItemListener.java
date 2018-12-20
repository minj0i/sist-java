package day1211;


import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ItemEvent를 처리하는 ItemListener의 사용.
 * @author owner
 */

//1.Frame 상속, 이벤트를 처리할 수 있는 itemListener구현.
@SuppressWarnings("serial")
public class UseItemListener extends Frame implements ItemListener{
	private List list;
	private Label lblResult;

	public UseItemListener() {
		list = new List();
		list.add("정택성/26");
		list.add("이재현/26");
		list.add("김정운/27");
		list.add("김정윤/30");
		list.add("이재찬/27");
		list.add("김개똥이/120");

		lblResult = new Label("이름 :                     나이 : ");

		add("Center", list);
		add("South", lblResult);
		
		//이벤트 등록
		list.addItemListener(this);
		

		setBounds(200, 200, 400, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});//addWindowListener
	}//UseItemListener

	public static void main(String[] args) {
		new UseItemListener();
	}//main

	@Override
	public void itemStateChanged(ItemEvent e) {
		//리스트의 아이템이 선택되면 선택한 아이템을 가져와서 Label에 값을 변경.
		
		String[] readItem=list.getSelectedItem().split("/");//<Tokenizer도 괜찮
//		readItem.split("/");
		String name = readItem[0];
		String age = readItem[1];
		
		
		StringBuilder viewData = new StringBuilder();
		viewData.append("이름 : ").append(name).append("    나이 : ")
										.append(age);
//		lblResult.setText("이름 : "+name+"        나이 : "+age);
		lblResult.setText(viewData.toString());
		//<형이 안맞기때문에 string로 변환.주소가 아니라 문자열이 잘나온다.
		//<긴문자열이기 때문에 StringBuilder인게 좋음.
	}//itemStateChanged
}//class
