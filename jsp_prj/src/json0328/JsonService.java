package json0328;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JsonService {
	public JSONObject searchEmpData(int deptno) {
		JSONObject json_obj=new JSONObject();
		
		JsonEmpSearchDAO jes_dao=JsonEmpSearchDAO.getInstance();
		
		try {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			json_obj.put("pubData", sdf.format(new Date()));
			List<EmpVO> list = jes_dao.selectEmpList(deptno);

			json_obj.put("result", !list.isEmpty());//조회가 수행되면 true
			
			JSONArray json_arr = new JSONArray();
			JSONObject temp_obj=null;
			EmpVO ev=null;
			for(int i=0; i<list.size(); i++) {
				ev=list.get(i);
				temp_obj=new JSONObject();
				temp_obj.put("empno",ev.getEmpno());
				temp_obj.put("sal",ev.getSal());
				temp_obj.put("ename",ev.getEname());
				temp_obj.put("job",ev.getJob());
				temp_obj.put("hiredate",ev.getHiredate());
				//JSONArray에 생성되어 값을 가진 JSONObject 추가
				json_arr.add(temp_obj);
			}//end for
			//조회된 결과를 가진 JSONArray를 JSONObject 추가
			json_obj.put("resultData", json_arr);
			
		} catch (SQLException e) {
			json_obj.put("result", false);
			e.printStackTrace();
		}
		
		return json_obj;
	}//searchEmpData
	
	
}//class
