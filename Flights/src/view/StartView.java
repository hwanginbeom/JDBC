package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DepartureDAO;
import model.FlightDAO;
import model.LoginDAO;
import model.domain.DepartureDTO;
import model.domain.FlightDTO;
import util.XMLParsing;
import util.XMLParsing1;

public class StartView {

	public static int number1 = 0;

	public static void main(String[] a) throws SQLException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String input2 = "";
		String input3 = "";
		String input4 = "";
		String number = "";
		ArrayList<FlightDTO> flightDTOs;
		ArrayList<DepartureDTO> departureDTOs;
		System.out.println("***로그인***");

		try {

			System.out.println("1. ID를 입력해주세요 : ");
			input = in.readLine();
			System.out.println("2. PW를 입력해주세요 : ");
			input2 = in.readLine();
			// 로그인 로직
			if (LoginDAO.login(input, input2)) {
				// System.out.println("로그인 성공하였습니다.");
			} else {
				System.out.println("로그인 실패하였습니다.");
				return;
			}

			System.out.print("로딩중 입니다...");
			//FlightDAO.xmlparsing();// 처음 한번 xml문서 불러오기
			//DepartureDAO.xmlparsing1();
			System.out.println("로딩 성공!");
			System.out.println("환영합니다 ^^ 인천공항 입/출국 정보시스템 입니다.");
			if (LoginDAO.user.getAdmin() == 0) {
				while (!input.equals("0")) {
					// user버전
					System.out.println("\n<입국정보와 출국정보 중 원하시는 정보를 선택해주세요>");
					System.out.println("1. 입국정보 2. 출국정보 3. 내 운항정보 보기 0. 프로그램 종료");
					input = in.readLine();
					switch (input) {
					case "1":// 입국정보
						System.out.println("<출발지를 선택해주세요>");
						System.out.println("1. 뉴욕 2. 베이징  3.하노이  4.홍콩  5.후쿠오카  0.이전메뉴");
						input = in.readLine();

						switch (input) {
						case "1":
							System.out.println("<원하는 날짜를 입력해주세요 (입력예시)20180716>");
							input2 = in.readLine();
							System.out.println("<항공사를 입력해주세요>");
							System.out.println("1.대한항공    2.아시아나항공  3.에어서울  4.이스타항공  5.제주항공  6.진에어  7.티웨이항공  0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									flightDTOs = FlightDAO.getSchedule("뉴욕", input2, "대한항공");
									if (EndView.printAll(flightDTOs)) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}

								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("뉴욕", input2, "아시아나항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("뉴욕", input2, "에어서울"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("뉴욕", input2, "이스타항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;

							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("뉴욕", input2, "제주항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {

									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("뉴욕", input2, "진에어"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("뉴욕", input2, "티웨이항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;

						case "2":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "대한항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "아시아나항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "에어서울"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "이스타항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "제주항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "진에어"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("베이징", input2, "티웨이항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;

						case "3":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "대한항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "아시아나항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "에어서울"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "이스타항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "제주항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "진에어"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("하노이", input2, "티웨이항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;
						case "4":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "대한항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "아시아나항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "에어서울"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "이스타항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "제주항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "진에어"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("홍콩", input2, "티웨이항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;

							}
							break;

						case "5":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "대한항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "아시아나항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "에어서울"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "이스타항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "제주항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "진에어"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("후쿠오카", input2, "티웨이항공"))) {
										System.out.println("<즐겨찾기에 추가할 항공편 number를 입력해주세요>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("즐겨찾기 등록 성공!");
										} else {
											System.out.println("남은 공간이 없습니다.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;
						case "0":
							// 이전메뉴
							break;
						}
						break;

					case "2":// 출국정보
						System.out.println("<도착지를 선택해주세요>");
						System.out.println("1. 뉴욕 2. 베이징  3.하노이  4.홍콩  5.후쿠오카  0.이전메뉴");
						input = in.readLine();

						switch (input) {
						case "1":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "대한항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "아시아나항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "에어서울"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "이스타항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;

							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "제주항공"));
								} catch (Exception e) {

									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "진에어"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("뉴욕", input2, "티웨이항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}

						case "2":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "대한항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "아시아나항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "에어서울"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "이스타항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "제주항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "진에어"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("베이징", input2, "티웨이항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;

						case "3":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "대한항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "아시아나항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "에어서울"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "이스타항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "제주항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "진에어"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("하노이", input2, "티웨이항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;
						case "4":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "대한항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "아시아나항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "에어서울"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "이스타항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "제주항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "진에어"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("홍콩", input2, "티웨이항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;

							}
							break;

						case "5":
							System.out.println("원하는 날짜를 입력해주세요 (입력예시)20180716");
							input2 = in.readLine();
							System.out.println("항공사를 입력해주세요");
							System.out.println("1.대한항공    2.아시아나항공 3.에어서울 4.이스타항공 5.제주항공 6.진에어 7.티웨이항공 0.이전메뉴");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "대한항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "아시아나항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "에어서울"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "이스타항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "제주항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "진에어"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("후쿠오카", input2, "티웨이항공"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;
						case "0":
							// 이전메뉴
							break;
						}
						break;
					case "3": // 내 운항정보
						LoginDAO.printBookMark1();
						break;
					case "0":
						return;

					}
				}
			} else {

				// 관리자 버전

				while (!input.equals("0")) {
					System.out.println("\n<관리자로 로그인 하셨습니다. 원하시는 작업을 선택해주세요>");
					System.out.println("1. 도착편 운항정보 추가  2. 도착편 운항정보 수정  3. 도착편 운항정보 삭제");
					System.out.println("4. 출발편 운항정보 추가  5. 출발편 운항정보 수정  6. 출발편 운항정보 삭제 0. 프로그램종료");
					input = in.readLine();
					switch (input) {
					case "1":
						System.out.println("<추가할 도착편 운항정보를 입력해주세요(입력예시) 대한항공,KE008,201807171722,201807171722,뉴욕,33,3>");
						input = in.readLine();
						String[] str = input.split(",");
						FlightDTO dto = new FlightDTO(str[0], str[1], str[2], str[3], str[4], Integer.parseInt(str[5]),
								Integer.parseInt(str[6]), number1++);
						if (FlightDAO.insert(dto)) {
							System.out.println("추가 성공");
						} else {
							System.out.println("추가 실패");
						}
						break;
					case "2":
						System.out.println("<수정할 운항정보의 비행기명을 입력해주세요>");
						input = in.readLine();
						System.out.println("<날짜와 시간을 입력해주세요 (입력예시)201807161500>");
						input2 = in.readLine();
						// DTO결과를 가져왔다
						System.out.println("1. 도착예정시간  2. 출구번호  3. 수화물컨테이너번호");
						input3 = in.readLine();
						System.out.println("<수정할 값을 입력해주세요>");
						input4 = in.readLine();
						if (FlightDAO.update(input, input2, input3, input4)) {
							System.out.println("수정 성공");
						} else {
							System.out.println("수정 실패");
						}

						break;
					case "3":
						System.out.println("<삭제할 운항정보의 비행기명을 입력해주세요>");
						input = in.readLine();
						System.out.println("<날짜와 시간을 입력해주세요 (입력예시)201807161500>");
						input2 = in.readLine();
						if (FlightDAO.delete(input, input2)) {
							System.out.println("삭제 성공");
						} else {
							System.out.println("삭제 실패");
						}break;
					case "4":
						System.out
								.println("<추가할 출발편 운항정보를 입력해주세요(입력예시) 대한항공,KE008,201807171722,201807171722,c,뉴욕,33,3>");
						input = in.readLine();
						String[] str1 = input.split(",");
						DepartureDTO dto1 = new DepartureDTO(str1[0], str1[1], str1[2], str1[3], str1[4], str1[5],
								Integer.parseInt(str1[6]), Integer.parseInt(str1[7]), number1++);
						if (DepartureDAO.insert(dto1)) {
							System.out.println("추가 성공");
						} else {
							System.out.println("추가 실패");
						}
						break;
					case "5":
						System.out.println("<수정할 출발편 운항정보의 비행기명을 입력해주세요>");
						input = in.readLine();
						System.out.println("<날짜와 시간을 입력해주세요 (입력예시)201807161500>");
						input2 = in.readLine();
						// DTO결과를 가져왔다
						System.out.println("1. 도착예정시간  2. 출구번호  3. 수화물컨테이너번호");
						input3 = in.readLine();
						System.out.println("<수정할 값을 입력해주세요>");
						input4 = in.readLine();
						if (DepartureDAO.update(input, input2, input3, input4)) {
							System.out.println("수정 성공");
						} else {
							System.out.println("수정 실패");
						}

						break;
					case "6":
						System.out.println("<삭제할 출발편 운항정보의 비행기명을 입력해주세요>");
						input = in.readLine();
						System.out.println("<날짜와 시간을 입력해주세요 (입력예시)201807161500>");
						input2 = in.readLine();
						if (DepartureDAO.delete(input, input2)) {
							System.out.println("삭제 성공");
						} else {
							System.out.println("삭제 실패");
						}
						break;
					case "0":
						return;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
