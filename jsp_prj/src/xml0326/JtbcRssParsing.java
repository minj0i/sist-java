package xml0326;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JtbcRssParsing {
	
	private static JtbcRssParsing jrp;
	
	private JtbcRssParsing() {
		
	}//JtbcRssParsing

	public static JtbcRssParsing getInstance() {
		if(jrp==null) {
			jrp=new JtbcRssParsing();
		}//end if
		return jrp;
	}//getInstance
	
	public List<RssVO> getNews(String rssName) throws IOException, JDOMException{
		List<RssVO> list= new ArrayList<>();
		
		//1. Builder 생성
		SAXBuilder builder=new SAXBuilder();
		
		//2. URL로 외부 서버에서 제공하는 RSS 문서 객체 얻기
		Document doc = builder.build(new URL("http://fs.jtbc.joins.com/RSS/"+rssName+".xml"));
		
		//3. 최상위 부모 노드 얻기
		Element rootNode = doc.getRootElement();//rss
		
		//4. 자식 노드(channel) 얻기
		Element channelNode=rootNode.getChild("channel");
		
		//5. channel node의 자식 노드들 얻기
		Iterator<Element> someNodes=channelNode.getChildren().iterator();
		Element someNode=null;
		Iterator<Element> itemSubNodes=null;
		Element itemSubNode=null;
		
		RssVO rv = null;
		while(someNodes.hasNext()) {//채널 노드의 자식 노드들을 순환
			someNode=someNodes.next();//
			if("item".equals(someNode.getName())){
				//item노드의 모든 자식들 얻기
				itemSubNodes=someNode.getChildren().iterator();
				rv=new RssVO();
				while(itemSubNodes.hasNext()) {
					itemSubNode=itemSubNodes.next();
					if("title".equals(itemSubNode.getName())) {
						rv.setTitle(itemSubNode.getText());
					}//end if
					if("link".equals(itemSubNode.getName())) {
						rv.setLink(itemSubNode.getText());
					}//end if
					if("description".equals(itemSubNode.getName())) {
						rv.setDescription(itemSubNode.getText());
					}//end if
					if("pubDate".equals(itemSubNode.getName())) {
						rv.setPubDate(itemSubNode.getText());
					}//end if
					//System.out.println(itemSubNode);
				}//end while
				list.add(rv);
			}//end if
		}//end while
		
		
		return list;
	}//getNews
	
	public static void main(String[] args) {
		JtbcRssParsing jrp=JtbcRssParsing.getInstance();
		try {
			System.out.println(jrp.getNews("newsflash"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}//main
	
}//JtbcRssParsing