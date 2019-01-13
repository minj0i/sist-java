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
		super("로그인");
		jfId = new JTextField(10); 
		jfPass = new JTextField(10);
		jbtLogin = new JButton("로그인");
		
		JPanel jpl = new JPanel();
		jpl.setLayout(new GridLayout(2,2));
		
		jpl.add(new JLabel("아이디"));
		jpl.add(jfId);
		jpl.add(new JLabel("비밀번호"));
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
