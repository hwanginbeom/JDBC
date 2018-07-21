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
				// parsing�� url ����(API Ű �����ؼ�)
				code = str[i];																					// getPassengerArrivalsDS
				url = "http://openapi.airport.kr/openapi/service/StatusOfPassengerFlightsDS/getPassengerArrivalsDS?ServiceKey=uYuuw6N9VO4j%2BAlprhmKJrWJ6%2Fb0lMMLwpTmg3oqfrH4E6LXJdiae8OKfrfKixBgYt%2FVWBbbm30yTjdE9WNltA%3D%3D&airport_code="
						+ code;
				//code �κп� string 0������ 4������ ��  �� �迭�� �޾Ҵ��� 
				URL obj = new URL(url);  //URLŸ���� ��ü����  //��Ʈ���� url ��ü�� ����°� 
				HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //���ͳ� �����ϱ����ѹ���
				//URLŸ���� �������� �ٿ�ĳ�������� �����ְ�  HttpURLConnection�� con���� �����.
				
				con.setRequestProperty("Accept", "application/xml"); //xmlŸ������ �޾ƿ°� 
				//�̰� ������ ����� 
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance(); //db�� �����ϴ� �κ�
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(con.getInputStream());
				//�̺κ� ���� �ǹ����� ����� 
				
				// root tag
				doc.getDocumentElement().normalize();
				// System.out.println("Root element :" +
				// doc.getDocumentElement().getNodeName());

				//�̺κ� ���� �ǹ����� ����� 
				
//				DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(con.getInputStream()).getDocumentElement().normalize();

				
				// �Ľ��� tag     //xml�� �ѵ���� ����Ʈ�� ���� ���ִ� ��� 
				NodeList nList = doc.getElementsByTagName("item"); //tag �̸� 
				// System.out.println("�Ľ��� ����Ʈ �� : "+ nList.getLength());
				//tag�� nodeLIst Ÿ�Կ� nList�� �ִµ� item �κ��� ���� ����� 
				

				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp); // ���� ����Ʈ���� �ϳ��� ��ü�� ����°� 

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						         //��� �޾ƿԴ��� Ȯ�� �ϴ� �κ�
						Element eElement = (Element) nNode;
//��ü�� ���� ������ �־��ְ� 
						data = new FlightDTO(getTagValue("airline", eElement), getTagValue("flightId", eElement),
								getTagValue("scheduleDateTime", eElement), getTagValue("estimatedDateTime", eElement),
								getTagValue("airport", eElement), Integer.parseInt(getTagValue("gatenumber", eElement)),
								Integer.parseInt(getTagValue("carousel", eElement)), StartView.number1++);

						xmllist.add(data);
						//��ü�� ���� 

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