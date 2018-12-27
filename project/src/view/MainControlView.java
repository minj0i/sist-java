package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import evt.MainControlEvt;
import view.LoginView.backPanel;

/**
 * MainControlView 구성 완료 18.12.25 - 추가 구현할 부분 없음, 근데 너무 휑한디.. 뭐 추가할거 (그림같은거) 없나 파악할 것 
 * 
 * @author 이재찬
 */
@SuppressWarnings("serial")
public class MainControlView extends JFrame {
	private JButton jbtnView, jbtnReport;
	private BufferedImage img = null;
	
	public MainControlView() {
		super("로그분석-관리창");
		jbtnView = new JButton("View");
		jbtnReport = new JButton("Report");

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 200);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(getClass().getResource("mainimg.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "can not load login image");
			System.exit(0);
		}
		
		backPanel panel = new backPanel();
		panel.setSize(500, 200);
		layeredPane.add(panel);

		jbtnView.setBounds(150, 130, 80, 30);
		jbtnReport.setBounds(270, 130, 80, 30);
		
		setLayout(null);
		
		add(jbtnView);
		add(jbtnReport);
		add(layeredPane);

		// 이벤트 처리
		MainControlEvt mce = new MainControlEvt(this);
		jbtnView.addActionListener(mce);
		jbtnReport.addActionListener(mce);

		setBounds(100, 100, 500, 210);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 배경에 이미지를 넣는 매서드
	 * @author 백인재
	 */
	class backPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
	
	public JButton getJbtnView() {
		return jbtnView;
	}

	public JButton getJbtnReport() {
		return jbtnReport;
	}

}
