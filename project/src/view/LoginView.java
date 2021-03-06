package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import evt.LoginEvt;

/**
 * @author 백인재
 */
@SuppressWarnings("serial")
public class LoginView extends JFrame {

	public JTextField idTf;
	public JPasswordField pwTf;
	private JButton enterBtn, inforBtn, exitBtn;
	private JLabel idLbl, pwLbl;
	BufferedImage img = null;

	public LoginView() {
		super("Login");

		enterBtn = new JButton("로그인");
		inforBtn = new JButton("정보");
		exitBtn = new JButton("종료");

		idTf = new JTextField();
		pwTf = new JPasswordField();
		idLbl = new JLabel("ID");
		pwLbl = new JLabel("P/W");

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(320, 569);
		layeredPane.setLayout(null);

		add(idTf);
		add(pwTf);
		add(enterBtn);
		add(exitBtn);
		add(idLbl);
		add(pwLbl);

		enterBtn.setBounds(200, 300, 80, 70);
		inforBtn.setBounds(80, 450, 80, 30);
		exitBtn.setBounds(125, 400, 80, 30);
		idTf.setBounds(65, 300, 120, 30);
		pwTf.setBounds(65, 340, 120, 30);
		idLbl.setBounds(35, 290, 50, 50);
		pwLbl.setBounds(30, 330, 50, 50);
		
		try {
			img = ImageIO.read(getClass().getResource("loginimg.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "can not load login image");
			System.exit(0);
		}

		backPanel panel = new backPanel();
		panel.setSize(320, 569);
		layeredPane.add(panel);

		setLayout(null);

		add(layeredPane);

		LoginEvt lfe = new LoginEvt(this);
		idTf.addActionListener(lfe);
		pwTf.addActionListener(lfe);
		enterBtn.addActionListener(lfe);
		exitBtn.addActionListener(lfe);
		inforBtn.addActionListener(lfe);
		addWindowListener(lfe);

		setBounds(50, 50, 320, 569);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}

	/**
	 * 배경에 이미지를 넣는 클래스
	 * @author 백인재
	 */
	class backPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, this);
		}
	}

	public JButton getEnterBtn() {
		return enterBtn;
	}

	public JButton getInforBtn() {
		return inforBtn;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public JTextField getIdTf() {
		return idTf;
	}

	public JPasswordField getPwTf() {
		return pwTf;
	}

} // class
