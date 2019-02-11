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
		//상품 목록을 초기화한다.
		setProduct();
	}//PMProductController

	/**
	 * JTable에 DB에서 조회한 도시락 정보를 보여준다.
	 */
	public void setProduct() {
		DefaultTableModel dtmPrd = pmpv.getDtmPrd();
		dtmPrd.setRowCount(0); // View창에 있는 걸 지워주고

		try {
			// DB에서 상품 정보를 조회
			List<PMProductVO> listproduct = pmp_dao.selectPrd();
			// JTable에 조회한 정보를 출력

			PMProductVO pmp_vo = null;
//			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listproduct.size(); i++) {
				pmp_vo = listproduct.get(i);
				// DTM에 넣을 때는 1차원배열 혹은 벡터로 넣어야 함
				// DTM에 데이터를 추가하기 위한 1차원배열(Vector)을 생성하고 데이터를 추가
				rowData = new Object[6];
				rowData[0] = pmp_vo.getMenuCode();
				rowData[1] = pmp_vo.getMenuName();
//				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[2] = new Integer(i+1);//이미지 넣을 곳
				rowData[3] = new Integer(pmp_vo.getPrice());
				rowData[4] = new Integer(pmp_vo.getQuan());
				rowData[5] = new Integer(pmp_vo.getTotal());

				// DTM에 추가
				dtmPrd.addRow(rowData);
			} // end for

			if (listproduct.isEmpty()) {// 입력된 도시락이 없을 때
				JOptionPane.showMessageDialog(pmpv, "입력된 제품이 없습니다.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(pmpv, "DB에서 데이터를 받아오는 중 문제 발생");
			e.printStackTrace();
		} // end catch
	}// setLunch
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
