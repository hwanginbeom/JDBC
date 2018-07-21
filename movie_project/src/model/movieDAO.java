package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class movieDAO {
	public static StringBuilder sb;//

	public static void main(String[] args) {
		String clientId = "BVP9FIue0EprW0VzDAOo";
		String clientSecret = "j2p4VxyxNb";
		int display = 1; // 검색 결과수
//		String country ="KR";
		String name [] = {
				"22","픽시","플로이","미션 임파서블: 폴아웃","논스톱: 다마스커스 타겟","후난성 전투","판더믹","원초적 비디오 테이프","극장판 헬로카봇 : 백악기 시대","스페셜 스쿼드","더 스퀘어","호텔 아르테미스","아큐페이션","마일22","주피터스 문","인랑","이별의 아침에 약속의 꽃을 장식하자","삼국전쟁: 전쟁의 서막","당대명포-무림고수 대결전","신비아파트: 금빛 도깨비와 비밀의 동굴","맘마미아!2","물괴","인크레더블 2","맘&대드","독전: 익스텐디드 컷","노맨스랜드","인투 더 샤크스톰","뱅크 잡: 리크루트","극장판 레이디버그: 미라클스톤의 비밀","밤은 짧아 걸어 아가씨야","새벽을 알리는 루의 노래","나미야 잡화점의 기적","뮤즈","극장판 도라에몽: 진구의 보물섬","신과함께-인과 연","몬스터 호텔 3","죽음의 리무진","글래디에이터: 바이킹과의 전쟁","호비와 매직 아일랜드","허리케인 샤크네이도","사이드 이펙트","속닥속닥","리벤지","꼬마영웅 바비","킬링 군터","몬몬몬 몬스터","꼬마 보트 토토: 타요 타요 배 타요","뮤즈 드론즈 월드투어 실황","펠리니를 찾아서","킬링 디어","철마류 2018","용의자: 폭탄 테러를 막아라","서버비콘","당대명포-고수의 부활","오늘 밤, 로맨스 극장에서","스카이스크래퍼","좀비 vs 헌터","미투 숨겨진 진실","할로우 차일드","명탐정 코난:제로의 집행인","블랙회사에 다니고 있는데, 지금 나는 한계에 도달했는지도 모른다","메가로돈","호텔 타지마할","앤트맨과 와스프","빅 스코어","햄스테드","킬링 인 더 무비","드래곤 프린세스","뮤턴트 워","도묘필기: 제국의 서막","당대명포-의문의 주검","둠스데이 2018","카르멘","그것만이 내 세상","탐정: 리턴즈","나와 봄날의 약속","안나 카레니나","블러드 뱀파이어","라이즈 오브 더 풋솔져 3","루킹 글라스","배틀필드: 카르발라 전투","바이킹: 왕좌의 게임","로보트캅: 기계들의 반란","디 아이즈","뱀파이어 클린업 디파트먼트"
				};
		for (int j = 0; j < name.length; j++) {
			try {
				Thread.sleep(250);
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
//				 String[] array;
//		            array = data.split("\"");
//		            String[] lastBuildDate = new String[display];
//		            String[] total = new String[display];
//		            String[] start = new String[display];
//		            String[] display1= new String[display];
//		            String[] items = new String[display];
//		            String[] title = new String[display];
//		            String[] link = new String[display];
//		            String[] image = new String[display];
//		            String[] subtitle = new String[display];
//		            String[] pubDate = new String[display];
//		            String[] director = new String[display];
//		            String[] actor = new String[display];
//		            String[] userRating = new String[display];
//
//		            int k = 0;
//		            for (int i = 0; i < array.length; i++) {
//		                if (array[i].equals("title"))
//		                	lastBuildDate[k] = array[i + 2];
//		                if (array[i].equals("link"))
//		                	total[k] = array[i + 2];
//		                if (array[i].equals("category"))
//		                	start[k] = array[i + 2];
//		                if (array[i].equals("description"))
//		                	display1[k] = array[i + 2];
//		                if (array[i].equals("telephone"))
//		                	items[k] = array[i + 2];
//		                if (array[i].equals("address"))
//		                	title[k] = array[i + 2];
//		                if (array[i].equals("mapx"))
//		                	link[k] = array[i + 2];
//		                if (array[i].equals("mapy")) 
//		                	image[k] = array[i + 2];
//		                if (array[i].equals("mapy")) 
//		                	subtitle[k] = array[i + 2];
//		                if (array[i].equals("mapy")) 
//		                	pubDate[k] = array[i + 2];
//		                if (array[i].equals("mapy")) 
//		                	director[k] = array[i + 2];
//		                if (array[i].equals("mapy")) 
//		                	actor[k] = array[i + 2];
//		                if (array[i].equals("mapy")) { 
//		                	userRating[k] = array[i + 2];
//		                    k++;
//		                }
//		            }
		            System.out.println(sb);
//		            for(int a=0 ; a<title.length ; a++) {
//		            System.out.println(a+"번째 타이틀 : " + title[a]);
//		            }

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
