package admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import admin.model.PMProductDAO;
import admin.view.PMProductView;
import admin.vo.PMProductVO;

public class PMProductController extends MouseAdapter implements ActionListener{

	private PMProductView pmpv;
	private PMProductDAO pmp_dao;
	
	
	public PMProductController(PMProductView pmpv) {
		this.pmpv=pmpv;
		pmp_dao = PMProductDAO.getInstance();
		//��ǰ ����� �ʱ�ȭ�Ѵ�.
		setProduct();
	}//PMProductController

	/**
	 * JTable�� DB���� ��ȸ�� ���ö� ������ �����ش�.
	 */
	public void setProduct() {
		DefaultTableModel dtmPrd = pmpv.getDtmPrd();
		dtmPrd.setRowCount(0); // Viewâ�� �ִ� �� �����ְ�

		try {
			// DB���� ��ǰ ������ ��ȸ
			List<PMProductVO> listproduct = pmp_dao.selectPrd();
			// JTable�� ��ȸ�� ������ ���

			PMProductVO pmp_vo = null;
//			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listproduct.size(); i++) {
				pmp_vo = listproduct.get(i);
				// DTM�� ���� ���� 1�����迭 Ȥ�� ���ͷ� �־�� ��
				// DTM�� �����͸� �߰��ϱ� ���� 1�����迭(Vector)�� �����ϰ� �����͸� �߰�
				rowData = new Object[6];
				rowData[0] = pmp_vo.getMenuCode();
				rowData[1] = pmp_vo.getMenuName();
//				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[2] = new Integer(i+1);//�̹��� ���� ��
				rowData[3] = new Integer(pmp_vo.getPrice());
				rowData[4] = new Integer(pmp_vo.getQuan());
				rowData[5] = new Integer(pmp_vo.getTotal());

				// DTM�� �߰�
				dtmPrd.addRow(rowData);
			} // end for

			if (listproduct.isEmpty()) {// �Էµ� ���ö��� ���� ��
				JOptionPane.showMessageDialog(pmpv, "�Էµ� ��ǰ�� �����ϴ�.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(pmpv, "DB���� �����͸� �޾ƿ��� �� ���� �߻�");
			e.printStackTrace();
		} // end catch
	}// setLunch
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
