package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class movieDAO4 {
	public static StringBuilder sb;//

	public static void main(String[] args) {
		String clientId = "BVP9FIue0EprW0VzDAOo";
		String clientSecret = "j2p4VxyxNb";
		int display = 100; // 검색 결과수
//		String country ="KR";
		String name [] = {"로미오와 줄리엣"}; //이런식으로 값 넣고
		for (int j = 0; j < name.length; j++) {
			try {

				String text = URLEncoder.encode(name[j], "utf-8"); // 검색 하는 값

				String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text + "&display=" + display;
//						+ "&country="+country;

				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", clientId);
				con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				int responseCode = con.getResponseCode();
				BufferedReader br;
				if (responseCode == 200) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				sb = new StringBuilder();
				String line;

				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}

				br.close();
				con.disconnect();
				System.out.println(sb);
				String data = sb.toString();
				 String[] array;
		            array = data.split("\"");
		            String[] lastBuildDate = new String[display];
		            String[] total = new String[display];
		            String[] start = new String[display];
		            String[] display1= new String[display];
		            String[] items = new String[display];
		            String[] title = new String[display];
		            String[] link = new String[display];
		            String[] image = new String[display];
		            String[] subtitle = new String[display];
		            String[] pubDate = new String[display];
		            String[] director = new String[display];
		            String[] actor = new String[display];
		            String[] userRating = new String[display];

		            int k = 0;
		            for (int i = 0; i < array.length; i++) {
		                if (array[i].equals("title"))
		                	lastBuildDate[k] = array[i + 2];
		                if (array[i].equals("link"))
		                	total[k] = array[i + 2];
		                if (array[i].equals("category"))
		                	start[k] = array[i + 2];
		                if (array[i].equals("description"))
		                	display1[k] = array[i + 2];
		                if (array[i].equals("telephone"))
		                	items[k] = array[i + 2];
		                if (array[i].equals("address"))
		                	title[k] = array[i + 2];
		                if (array[i].equals("mapx"))
		                	link[k] = array[i + 2];
		                if (array[i].equals("mapy")) 
		                	image[k] = array[i + 2];
		                if (array[i].equals("mapy")) 
		                	subtitle[k] = array[i + 2];
		                if (array[i].equals("mapy")) 
		                	pubDate[k] = array[i + 2];
		                if (array[i].equals("mapy")) 
		                	director[k] = array[i + 2];
		                if (array[i].equals("mapy")) 
		                	actor[k] = array[i + 2];
		                if (array[i].equals("mapy")) { 
		                	userRating[k] = array[i + 2];
		                    k++;
		                }
		            }
		            System.out.println(sb);
		            for(int a=0 ; a<title.length ; a++) {
		            System.out.println(a+"번째 타이틀 : " + title[a]);
		            }

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
