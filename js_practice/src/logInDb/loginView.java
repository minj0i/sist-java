package logInDb;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class loginView extends JFrame{
	private JTextField jfId, jfPass;
	private JButton jbtLogin;
	
	public loginView() {
		super("�α���");
		jfId = new JTextField(10); 
		jfPass = new JTextField(10);
		jbtLogin = new JButton("�α���");
		
		JPanel jpl = new JPanel();
		jpl.setLayout(new GridLayout(2,2));
		
		jpl.add(new JLabel("���̵�"));
		jpl.add(jfId);
		jpl.add(new JLabel("��й�ȣ"));
		jpl.add(jfPass);
		
		add("Center", jpl);
		add("South", jbtLogin);
		loginEvt le = new loginEvt(this);
		
		jbtLogin.addActionListener(le);
		jfId.addActionListener(le);
		jfPass.addActionListener(le);
		addWindowListener(le);
		
		setBounds(100, 100, 200, 200);
		setVisible(true);
	}
	
	
	public JTextField getJfId() {
		return jfId;
	}


	public JTextField getJfPass() {
		return jfPass;
	}


	public JButton getJbtLogin() {
		return jbtLogin;
	}


	public static void main(String[] args) {
		new loginView();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 5f87042d2a977fec754c70f1526bc603ee3c4584
