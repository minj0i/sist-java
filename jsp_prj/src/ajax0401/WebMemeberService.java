package ajax0401;

import java.sql.SQLException;

import org.json.simple.JSONObject;

/**
 * Service������ ���������� ó���Ѵ�
 * @author owner
 */
public class WebMemeberService {
	public JSONObject searchId(String id) {
		JSONObject json=new JSONObject();
		
		WebMemberDAO wm_dao=WebMemberDAO.getInstance();
		
		boolean flag=false;
		try {
			flag=wm_dao.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		//DB��ȸ ����� JSONObject �߰�
		json.put("idResult", flag);
		
		return json;
	}
}//class

