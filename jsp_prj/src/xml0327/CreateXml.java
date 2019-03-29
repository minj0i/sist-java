package xml0327;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateXml {

	public List<String> data(){
		List<String> list = new ArrayList<String>();
		list.add("월래 먹는 날");
		list.add("화끈하게 먹는 날");
		list.add("수도 없이 먹는 날");
		list.add("목이 터지게 먹는 날");
		list.add("금새먹고 또 먹는 날");
		list.add("토하면서 먹는 날");
		list.add("일일이 찾아다니며 먹는 날");	
		return list;
	}//data
	
	public String createXml(List<String> weekMsg) {
		StringBuilder xml=new StringBuilder();
		xml.append("<?xml version='1.0' encoding='UTF-8'?>\n");
		xml.append("<week>\n");
		
		for(int i=0; i<weekMsg.size(); i++) {
			xml.append("\t<msg>").append(weekMsg.get(i)).append("</msg>\n");
		}//end for
		
		xml.append("</week>");
		return xml.toString();
	}//createXml
	
	public void createXmlFile(String xml) throws IOException{
		BufferedWriter bw = null;
		try {
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0327/msg.xml"),"UTF-8"));
			bw.write(xml);
			bw.flush();
		}finally {
			if(bw!=null) {bw.close();}//end if
		}//end finally
	}//createXmlFile
	
	
	public static void main(String[] args) {
		CreateXml c = new CreateXml();
		try {
			c.createXmlFile(c.createXml(c.data()));
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
