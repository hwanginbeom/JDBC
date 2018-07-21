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

import model.domain.DepartureDTO;
import view.StartView;

public class XMLParsing1 {

   public static ArrayList<DepartureDTO> xmllist = new ArrayList<DepartureDTO>();
   public static DepartureDTO data = null;
   public static String str[] = { "JFK", "PEK", "HAN", "HKG", "FUK" };
   public static int number=0;

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

   public static void xmlparsing1() {

      String code = "";
      String url;
      for (int i = 0; i < 5; i++) {
         try {
            // parsing할 url 지정(API 키 포함해서)
            code = str[i];																						//getPassengerDeparturesDS
            url = "http://openapi.airport.kr/openapi/service/StatusOfPassengerFlightsDS/getPassengerDeparturesDS?ServiceKey=uYuuw6N9VO4j%2BAlprhmKJrWJ6%2Fb0lMMLwpTmg3oqfrH4E6LXJdiae8OKfrfKixBgYt%2FVWBbbm30yTjdE9WNltA%3D%3D&airport_code="
                  + code;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestProperty("Accept", "application/xml");

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(con.getInputStream());

            // root tag
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("item");
            // System.out.println("파싱할 리스트 수 : "+ nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);

               if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                  Element eElement = (Element) nNode;

                  data = new DepartureDTO(getTagValue("airline", eElement), getTagValue("flightId", eElement),
                        getTagValue("scheduleDateTime", eElement), getTagValue("estimatedDateTime", eElement),
                        getTagValue("airport", eElement), getTagValue("chkinrange", eElement), Integer.parseInt(getTagValue("gatenumber", eElement)),
                        Integer.parseInt(getTagValue("carousel", eElement)),StartView.number1++);

                  xmllist.add(data);

               } // for end
            } // if end

         } catch (Exception e) {
            e.printStackTrace();
         } // try~catch end
      }
   } // main end

   // public static void main(String[] afr) {
   //
   // xmlparsing();
   // for (int i = 0; i < xmllist.size(); i++) {
   // System.out.println(xmllist.get(i));
   // }
   // }

} // class end