package view;

import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import evt.MainControlEvt;
import evt.ReportDialogEvt;

/**
 * 
 * (레이아웃 크기 수정 및  passIssues메서드 추가 18.12.27 - 이재찬)
 * @author 김민정 
 */
@SuppressWarnings("serial")
public class ReportDialogView extends Dialog {
	private JLabel jlNum1, jlNum2, jlNum3, jlNum4,jlNum5, jlNum6;
	private JTextArea report1, report2, report3, report4, report5, report6;
	private MainControlEvt mce;
	private BufferedImage img = null;
	
	public ReportDialogView(MainControlEvt mce) {
		super(mce.getMcv(), "로그분석-결과창", true);
		this.mce = mce;
		String issue6Lange = String.valueOf(mce.getStartLine()) + " ~ " + String.valueOf(mce.getEndLine());
		String[] tempIssue = new String[6]; //MainControlEvt에서 파일출력을 위해 문제를 넘겨주기 위한 임시변수 생성
		
		jlNum1 = new JLabel("1.	최다사용 키의 이름과 횟수");
		jlNum2 = new JLabel("2.	브라우저별 접속횟수, 비율");
		jlNum3 = new JLabel("3. 서비스를 성공적으로 수행한 횟수와 실패(404) 횟수");
		jlNum4 = new JLabel("4. 요청이 가장 많은 시간");
		jlNum5 = new JLabel("5. 비정상적인 요청(403)이 발생한 횟수, 비율 구하기");
		jlNum6 = new JLabel("<html>6. 입력된 라인 ("+ issue6Lange +")에 해당하는 정보 중,<br>최다사용 키의 이름과 횟수");
		report1 = new JTextArea("");
		report2 = new JTextArea("");
		JScrollPane jsp2 = new JScrollPane(report2);
		report3 = new JTextArea("");
		report4 = new JTextArea("");
		report5 = new JTextArea("");
		report6 = new JTextArea("");
		JButton jbtnClose = new JButton("닫기");
				
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(360, 630);
		layeredPane.setLayout(null);
		
		try {
			img = ImageIO.read(new File("C:/dev/workspace/javase_teamprj1/src/view/resultimg.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "can not load login image");
			System.exit(0);
		}
		
		backPanel panel = new backPanel();
		panel.setSize(360, 630);
		layeredPane.add(panel);
		
		setLayout(null);
		
		add(jlNum1);
		add(jlNum2);
		add(jlNum3);
		add(jlNum4);
		add(jlNum5);
		add(jlNum6);
		add(report1);
		add(jsp2);
		add(report3);
		add(report4);
		add(report5);
		add(report6);
		add(layeredPane);
		add(jbtnClose);
		
		jlNum1.setBounds(20,20,380,30);
		jlNum2.setBounds(20,100,380,30);
		jlNum3.setBounds(20,220,380,30);
		jlNum4.setBounds(20,300,380,30);
		jlNum5.setBounds(20,380,380,30);
		jlNum6.setBounds(20,460,380,40);
		
		report1.setBounds(20,50,300,40);
		jsp2.setBounds(20,130,300,80);
		report3.setBounds(20,250,300,40);
		report4.setBounds(20,330,300,40);
		report5.setBounds(20,410,300,40);
		report6.setBounds(20,510,300,40);
		
		jbtnClose.setBounds(10,590,330,30);
	
		//이벤트 등록
		ReportDialogEvt rde = new ReportDialogEvt(this);
		
		addWindowListener(rde);
		jbtnClose.addActionListener(rde);
		
		setBounds(mce.getMcv().getX()+150, mce.getMcv().getY()+80, 360, 630);
		report1.setEditable(false);
		report2.setEditable(false);
		report3.setEditable(false);
		report4.setEditable(false);
		report5.setEditable(false);
		report6.setEditable(false);
		setResizable(false);
		setVisible(true);
		
		tempIssue = passIssues();
		tempIssue[5] = "6. 입력된 라인 ("+ issue6Lange +")에 해당하는 정보 중, 최다사용 키의 이름과 횟수";
		mce.setTempProblem(tempIssue);//문제를 mainControlEvt에 넘겨준다
	}//LogAnalysisView

	
	/**
	 * 문제를  mainControlEvt에 넘겨주기위한 메서드
	 * @return
	 */
	private String[] passIssues() {
		String[] tempIssue = new String[6];

		tempIssue[0] = jlNum1.getText();
		tempIssue[1] = jlNum2.getText();
		tempIssue[2] = jlNum3.getText();
		tempIssue[3] = jlNum4.getText();
		tempIssue[4] = jlNum5.getText();
	
		return tempIssue;
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
	
	public MainControlEvt getMce() {
		return mce;
	}

	public JTextArea getReport1() {
		return report1;
	}

	public JTextArea getReport2() {
		return report2;
	}

	public JTextArea getReport3() {
		return report3;
	}

	public JTextArea getReport4() {
		return report4;
	}

	public JTextArea getReport5() {
		return report5;
	}

	public JTextArea getReport6() {
		return report6;
	}

	
	
}//LogAnalysisView
