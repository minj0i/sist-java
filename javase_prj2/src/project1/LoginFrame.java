package project1;

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

import project1.LoginFrameEvt;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{

	public JTextField idTf;
	public JPasswordField pwTf;
	private JButton enterBtn, inforBtn, exitBtn;
	private ImageIcon enterIi/*, inforIi, exitIi*/;
	private JLabel idLbl, pwLbl;
	BufferedImage img = null;

	public LoginFrame() {
		super("Login");
		
		enterIi=new ImageIcon("c:/dev/temp/testImg2.jpg");
		enterBtn=new JButton("로그인", enterIi);
		
		inforBtn=new JButton("정보", enterIi);
		exitBtn=new JButton("종료", enterIi);
		
		idTf=new JTextField();
		pwTf=new JPasswordField();
		idLbl=new JLabel("ID");
		pwLbl=new JLabel("P/W");
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(320, 569);
		layeredPane.setLayout(null);
		
		add(idTf);
		add(pwTf);
		add(enterBtn);
		add(inforBtn);
		add(exitBtn);
		add(idLbl);
		add(pwLbl);
		
		enterBtn.setBounds(110,270,90,30);
		inforBtn.setBounds(140, 480, 80, 30);
		exitBtn.setBounds(230, 480, 80, 30);
		idTf.setBounds(105,180,120,30);
		pwTf.setBounds(105,220,120,30);
		idLbl.setBounds(75, 170, 50, 50);
		pwLbl.setBounds(70, 210, 50, 50);
		
		
		try {
			img=ImageIO.read(new File("C:/Users/owner/Desktop/oracle/01.group_prj1/src/testImg3.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		
		backPanel panel=new backPanel();
		panel.setSize(320, 569);
		layeredPane.add(panel);
		
		setLayout(null);
		
		add(layeredPane);
		
		
		LoginFrameEvt lfe=new LoginFrameEvt(this);
		idTf.addActionListener(lfe);
		pwTf.addActionListener(lfe);
		enterBtn.addActionListener(lfe);
		exitBtn.addActionListener(lfe);
		inforBtn.addActionListener(lfe);
		
		setBounds(720, 220, 320, 569);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class backPanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,  0, 0, null);
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

}
