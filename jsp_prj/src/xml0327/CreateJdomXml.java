package xml0327;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateJdomXml {

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
	
	public Document createXml(List<String> weekMsg) {
		//1. xml문서객체 생성
		Document doc = new Document();
		//2. 최상위 부모노드 생성
		Element rootNode = new Element("week");
		Element msgNode = null;
		for(String data : weekMsg) {
			//3. 자식 노드 생성
			msgNode = new Element("msg");
			//4. 자식 노드에 값을 설정
			msgNode.setText(data);
			//5. 값을 가진 자식 노드를 부모노드에 할당
			rootNode.addContent(msgNode);
		}//end for
			//6. 자식 노드를 가진 부모노드를 xml 문서객체에 추가
			doc.addContent(rootNode);
			
		return doc;
	}//createXml
	
	public void createXmlFile(Document doc) throws IOException{
		//7. 출력 객체 생성 : compact, raw format은 한 줄로 출력한다
//		XMLOutputter x_out = new XMLOutputter( Format.getRawFormat());
		XMLOutputter x_out = new XMLOutputter( Format.getPrettyFormat());
		
		//8. xml문서 객체와 출력스트림 사용하여 출력
		x_out.output(doc, System.out);//Console 출력
		x_out.output(doc, new FileOutputStream
				("C:/dev/workspace/jsp_prj/WebContent/xml0327/jdom_msg.xml"));
	}//createXmlFile
	
	
	public static void main(String[] args) {
		CreateJdomXml c = new CreateJdomXml();
		try {
			c.createXmlFile(c.createXml(c.data()));
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
