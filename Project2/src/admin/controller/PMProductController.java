package admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.pcbang.manager.product.add.PMProductAddView;

public class PMProductController extends MouseAdapter implements ActionListener {

	public static List<String> PrdImgList;
	private PMProductView pmpv;
	private PMProductDAO pmpdao;

	public PMProductController(PMProductView pmpv) {
		PrdImgList=new ArrayList<String>();
		//������ �����ϴ� �̹��� �Է�
		
		//�̹����� �ٵ� FileServer�� ������ �ϴµ� ��� ������????
		File file = new File("C:/Users/owner/git/pcbang/PCbang/src/kr/co/sist/pcbang/manager/product/img");
		for(String tempName:file.list()) {
			PrdImgList.add(tempName);
		}//end for
		
		this.pmpv = pmpv;
		pmpdao = PMProductDAO.getInstance();
		// ��ǰ ����� �ʱ�ȭ�Ѵ�.
		setPrd();
	}// PMProductController

	/**
	 * JTable�� DB���� ��ȸ�� ��ǰ ������ �����ش�.
	 */
	public void setPrd() {
		DefaultTableModel dtmPrd = pmpv.getDtmPrd();
		dtmPrd.setRowCount(0); // Viewâ�� �ִ� �� �����ְ�

		try {
			// DB���� ��ǰ ������ ��ȸ
			List<PMProductVO> listproduct = pmpdao.selectPrd();

			// JTable�� ��ȸ�� ������ ���
			PMProductVO pmpvo = null;
			String imgPath = "C:/Users/owner/git/pcbang/PCbang/src/kr/co/sist/pcbang/manager/product/img";

			Object[] rowData = null;
			for (int i = 0; i < listproduct.size(); i++) {
				pmpvo = listproduct.get(i);
				// DTM�� ���� ���� 1�����迭 Ȥ�� ���ͷ� �־�� ��
				// DTM�� �����͸� �߰��ϱ� ���� 1�����迭(Vector)�� �����ϰ� �����͸� �߰�
				rowData = new Object[6];
				rowData[0] = pmpvo.getMenuCode();
				rowData[1] = pmpvo.getMenuName();
				rowData[2] = new ImageIcon(imgPath + pmpvo.getImg());
				rowData[3] = new Integer(pmpvo.getPrice());
				rowData[4] = new Integer(pmpvo.getQuan());
				rowData[5] = new Integer(pmpvo.getTotal());

				// DTM�� �߰�
				dtmPrd.addRow(rowData);
			} // end for

			if (listproduct.isEmpty()) {// �Էµ� ��ǰ�� ���� ��

				rowData = new Object[6];
				rowData[0] = "";
				rowData[1] = "�Էµ�";
				rowData[2] = "��ǰ��";
				rowData[3] = "�����ϴ�";
				rowData[4] = "";
				rowData[5] = "";

				// DTM�� �߰�
				dtmPrd.addRow(rowData);
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(pmpv, "DB���� �����͸� �޾ƿ��� �� ���� �߻�");
			e.printStackTrace();
		} // end catch
	}// setProduct

	/**
	 * ī�װ����� ��ǰ������ ã��
	 */
	public void searchPrd() {
		DefaultTableModel dtmSearch = pmpv.getDtmPrd();
		dtmSearch.setRowCount(0);

		String category = pmpv.getJcbPrdCategory().getSelectedItem().toString();
		String menuName = pmpv.getJtfPrdName().getText();
		try {
			List<PMSchProductVO> list_pmspvo = pmpdao.searchPrd(category.toString(), menuName);
			Object[] rowData = null;
			PMSchProductVO pmspvo = null;
			for (int i = 0; i < list_pmspvo.size(); i++) {
				pmspvo = list_pmspvo.get(i);
				rowData = new Object[6];
				rowData[0] = (pmspvo.getMenuCode());
				rowData[1] = (pmspvo.getMenuName());
				rowData[2] = (pmspvo.getImg());
				rowData[3] = (pmspvo.getPrice());
				rowData[4] = (pmspvo.getQuan());
				rowData[5] = (pmspvo.getPrice() * pmspvo.getQuan());

				// DTM�� �߰�
				dtmSearch.addRow(rowData);
			} // end for
		} catch (SQLException e1) {
			e1.printStackTrace();
		} // end catch
	}// searchPrd

	/////////////// �ʱ�ȭ �����߰� �ʿ�
	public void reset() {
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == pmpv.getJbtAddPrd()) { // ���ö� �߰� ��ư
			new PMProductAddView(pmpv, this);
		} // end if

		if (ae.getSource() == pmpv.getJbtSchPrd()) {// ��ȸ ��ư
			searchPrd();
		}
		if (ae.getSource() == pmpv.getJbtRstPrd()) {// �ʱ�ȭ ��ư
			reset();
		}
	}// actionPerformed

//////////////////////////////////////////////////////////////////
// mouseCliecked�� ��	
	@Override
	public void mouseClicked(MouseEvent me) {
//		if (me.getSource() == lmv.getJtb()) {
//			if (lmv.getJtb().getSelectedIndex() == 1) {// �ι�° ��(�ֹ�)���� �̺�Ʈ �߻�
//				// �ֹ���Ȳ�� ��� ��ȸ�Ͽ� �ǽð����� �ǽð����� DB�� ��ȸ�Ͽ� ����
//				if (threadOrdering == null) { // �̰ɾ��������� ����ؼ� ��ü�� �������
//					threadOrdering = new Thread(this);
//					threadOrdering.start();
//				} // end if
//					// ��������� �ֹ������� ��ȸ (������� ������ ��)
//				searchOrder();
//			} // end if
//		} // end if
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}// class