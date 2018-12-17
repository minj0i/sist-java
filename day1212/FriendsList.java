package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;

/**
 * Has a ����� Event ó��
 * @author owner
 */

@SuppressWarnings("serial")
public class FriendsList extends Frame {
	private List listFriend, listBlockFriend;
	private Button btnAllBlock, btnAllUnBlock;
	
	public FriendsList() {
		super("ģ������");

		Label lbl1 = new Label("ģ�� ���");
		Label lbl2 = new Label("���ܵ� ģ��");
		
		listFriend = new List();
		listBlockFriend = new List();
		listFriend.add("������");
		listFriend.add("������");
		listFriend.add("���ü�");
		
		btnAllBlock = new Button(">>");
		btnAllUnBlock = new Button("<<");
		
		setLayout(null);
		lbl1.setBounds(80, 100, 150, 50);
		lbl2.setBounds(355, 100, 150, 50);
		listFriend.setBounds(30, 150, 150, 200);
		listBlockFriend.setBounds(320, 150, 150, 200);
		btnAllBlock.setBounds(225, 200, 50, 30);
		btnAllUnBlock.setBounds(225, 250, 50, 30);
		
		add(lbl1);
		add(lbl2);
		add(listFriend);
		add(listBlockFriend);
		add(btnAllBlock);
		add(btnAllUnBlock);
		
		//�̺�Ʈ ���
		//������Ŭ������ �̺�Ʈó�� Ŭ������ Has a ����
		FriendsListEvt fle = new FriendsListEvt(this);
		btnAllBlock.addActionListener(fle);
		btnAllUnBlock.addActionListener(fle);
		
		listBlockFriend.addItemListener(fle);
		listFriend.addItemListener(fle);
		addWindowListener(fle);
		
		setBounds(200, 200, 500, 400);
		setResizable(false);
		
		setVisible(true);
		
	}
	
	
	public List getListFriend() {
		return listFriend;
	}
	public List getListBlockFriend() {
		return listBlockFriend;
	}
	public Button getBtnAllBlock() {
		return btnAllBlock;
	}
	public Button getBtnAllUnBlock() {
		return btnAllUnBlock;
	}

	public static void main(String[] args) {
		new FriendsList();
	}//main

}//class
