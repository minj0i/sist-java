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
 * MainControlView ���� �Ϸ� 18.12.25 - �߰� ������ �κ� ����, �ٵ� �ʹ� ���ѵ�.. �� �߰��Ұ� (�׸�������) ���� �ľ��� �� 
 * 
 * @author ������
 */
@SuppressWarnings("serial")
public class MainControlView extends JFrame {
	private JButton jbtnView, jbtnReport;
	private BufferedImage img = null;
	
	public MainControlView() {
		super("�α׺м�-����â");
		jbtnView = new JButton("View");
		jbtnReport = new JButton("Report");

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 200);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(new File("C:/dev/workspace/javase_teamprj1/src/view/mainimg.jpg"));
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

		// �̺�Ʈ ó��
		MainControlEvt mce = new MainControlEvt(this);
		jbtnView.addActionListener(mce);
		jbtnReport.addActionListener(mce);

		setBounds(100, 100, 500, 210);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * ��濡 �̹����� �ִ� �ż���
	 * @author ������
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
