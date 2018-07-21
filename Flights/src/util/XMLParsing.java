package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.domain.FlightDTO;
import view.StartView;

public class XMLParsing {

	public static ArrayList<FlightDTO> xmllist = new ArrayList<FlightDTO>();
	public static FlightDTO data = null;
	public static String str[] = { "JFK", "PEK", "HAN", "HKG", "FUK" };

	private static String getTagValue(String sTag, Element element) {

		try {

			String result = element.getElementsByTagName(sTag).item(0).getTextContent();
			return result;

		} catch (NullPointerException e) {

			return "0";

		} catch (Exception e) {

			return "0";
		}

	}

	public static void xmlparsing() {

		String code = "";
		String url;
		for (int i = 0; i < 5; i++) {
			try {
				// parsing할 url 지정(API 키 포함해서)
				code = str[i];																					// getPassengerArrivalsDS
				url = "http://openapi.airport.kr/openapi/service/StatusOfPassengerFlightsDS/getPassengerArrivalsDS?ServiceKey=uYuuw6N9VO4j%2BAlprhmKJrWJ6%2Fb0lMMLwpTmg3oqfrH4E6LXJdiae8OKfrfKixBgYt%2FVWBbbm30yTjdE9WNltA%3D%3D&airport_code="
						+ code;
				//code 부분에 string 0번부터 4번까지 들어감  왜 배열로 받았는지 
				URL obj = new URL(url);  //URL타입의 객체생성  //스트링을 url 객체로 만드는거 
				HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //인터넷 접속하기위한문구
				//URL타입이 상위여서 다운캐스팅으로 맞춰주고  HttpURLConnection의 con으로 만든다.
				
				con.setRequestProperty("Accept", "application/xml"); //xml타입으로 받아온거 
				//이걸 쓴이유 물어보기 
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance(); //db에 연결하는 부분
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(con.getInputStream());
				//이부분 무슨 의미인지 물어보기 
				
				// root tag
				doc.getDocumentElement().normalize();
				// System.out.println("Root element :" +
				// doc.getDocumentElement().getNodeName());

				//이부분 무슨 의미인지 물어보기 
				
//				DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(con.getInputStream()).getDocumentElement().normalize();

				
				// 파싱할 tag     //xml을 한덩어리의 리스트를 받을 수있는 방법 
				NodeList nList = doc.getElementsByTagName("item"); //tag 이름 
				// System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				//tag를 nodeLIst 타입에 nList에 넣는데 item 부분은 몬지 물어보기 
				

				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp); // 이제 리스트에서 하나의 객체로 만드는것 

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						         //노드 받아왔는지 확인 하는 부분
						Element eElement = (Element) nNode;
//객체로 만들어서 데이터 넣어주고 
						data = new FlightDTO(getTagValue("airline", eElement), getTagValue("flightId", eElement),
								getTagValue("scheduleDateTime", eElement), getTagValue("estimatedDateTime", eElement),
								getTagValue("airport", eElement), Integer.parseInt(getTagValue("gatenumber", eElement)),
								Integer.parseInt(getTagValue("carousel", eElement)), StartView.number1++);

						xmllist.add(data);
						//객체로 저장 

					} // for end
				} // if end

			} catch (Exception e) {
				e.printStackTrace();
			} // try~catch end
		}
	}

	private static void setRequestProperty(String string, String string2) {
		// TODO Auto-generated method stub
		
	} // main end

	// public static void main(String[] afr) {
	//
	// xmlparsing();
	// for (int i = 0; i < xmllist.size(); i++) {
	// System.out.println(xmllist.get(i));
	// }
	// }

} // class end