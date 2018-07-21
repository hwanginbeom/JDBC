package model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

// 네이버 기계번역 (Papago SMT) API 예제
public class movieDAO2 {

	public static void main(String[] args) {
        String clientId = "BVP9FIue0EprW0VzDAOo";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "BVP9FIue0EprW0VzDAOo";//애플리케이션 클라이언트 시크릿값";
		String name [] = {"로미오와 줄리엣","아수라","독전"}; //이런식으로 값 넣고
		for (int j = 0; j < name.length; j++) {

        try {
            String text = URLEncoder.encode("", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}