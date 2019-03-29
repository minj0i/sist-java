package xml0326;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class UseJDOMParser {

	public UseJDOMParser() throws JDOMException, IOException {
		//1. Parser생성
		SAXBuilder builder=new SAXBuilder();
		
		//2. XML문서를 객체 저장
		//local
		//Document doc = builder.build(new File("C:/dev/workspace/jsp_prj/WebContent/xml0326/names.xml"));
		//web server
		Document doc = builder.build(new URL("http://localhost:8080/jsp_prj/xml0326/names.xml"));
		//3. 문서 객체에서 최상위 부모노드 얻기
		Element rootNode = doc.getRootElement();
		//4. 부모노드의 자식 노드 얻기
		Iterator<Element> namesNode=rootNode.getChildren().iterator();
		//자식노드 순환
		Element nameNode=null;
		while(namesNode.hasNext()) {
			//자식노드 얻기
			nameNode=namesNode.next();
			System.out.println("노드명 :"+nameNode.getName());
			System.out.println("노드값 :"+nameNode.getText());
		}//end while
	}//UseJDOMParser
	
	public static void main(String[] args) {
		try {
			new UseJDOMParser();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//UseJDOMParser
