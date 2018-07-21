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
		System.out.println("***�α���***");

		try {

			System.out.println("1. ID�� �Է����ּ��� : ");
			input = in.readLine();
			System.out.println("2. PW�� �Է����ּ��� : ");
			input2 = in.readLine();
			// �α��� ����
			if (LoginDAO.login(input, input2)) {
				// System.out.println("�α��� �����Ͽ����ϴ�.");
			} else {
				System.out.println("�α��� �����Ͽ����ϴ�.");
				return;
			}

			System.out.print("�ε��� �Դϴ�...");
			//FlightDAO.xmlparsing();// ó�� �ѹ� xml���� �ҷ�����
			//DepartureDAO.xmlparsing1();
			System.out.println("�ε� ����!");
			System.out.println("ȯ���մϴ� ^^ ��õ���� ��/�ⱹ �����ý��� �Դϴ�.");
			if (LoginDAO.user.getAdmin() == 0) {
				while (!input.equals("0")) {
					// user����
					System.out.println("\n<�Ա������� �ⱹ���� �� ���Ͻô� ������ �������ּ���>");
					System.out.println("1. �Ա����� 2. �ⱹ���� 3. �� �������� ���� 0. ���α׷� ����");
					input = in.readLine();
					switch (input) {
					case "1":// �Ա�����
						System.out.println("<������� �������ּ���>");
						System.out.println("1. ���� 2. ����¡  3.�ϳ���  4.ȫ��  5.�����ī  0.�����޴�");
						input = in.readLine();

						switch (input) {
						case "1":
							System.out.println("<���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716>");
							input2 = in.readLine();
							System.out.println("<�װ��縦 �Է����ּ���>");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ�  3.�����  4.�̽�Ÿ�װ�  5.�����װ�  6.������  7.Ƽ�����װ�  0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									flightDTOs = FlightDAO.getSchedule("����", input2, "�����װ�");
									if (EndView.printAll(flightDTOs)) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}

								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����", input2, "�ƽþƳ��װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����", input2, "�����"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����", input2, "�̽�Ÿ�װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;

							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {

									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����", input2, "������"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����", input2, "Ƽ�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
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
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "�ƽþƳ��װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "�����"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "�̽�Ÿ�װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "������"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("����¡", input2, "Ƽ�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
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
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "�ƽþƳ��װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "�����"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "�̽�Ÿ�װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "������"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�ϳ���", input2, "Ƽ�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
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
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "�ƽþƳ��װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "�����"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "�̽�Ÿ�װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "������"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("ȫ��", input2, "Ƽ�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
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
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "�ƽþƳ��װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "�����"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "�̽�Ÿ�װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "������"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									if (EndView.printAll(FlightDAO.getSchedule("�����ī", input2, "Ƽ�����װ�"))) {
										System.out.println("<���ã�⿡ �߰��� �װ��� number�� �Է����ּ���>");
										number = in.readLine();
										if (LoginDAO.addBookmark1(number)) {
											System.out.println("���ã�� ��� ����!");
										} else {
											System.out.println("���� ������ �����ϴ�.");
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
							// �����޴�
							break;
						}
						break;

					case "2":// �ⱹ����
						System.out.println("<�������� �������ּ���>");
						System.out.println("1. ���� 2. ����¡  3.�ϳ���  4.ȫ��  5.�����ī  0.�����޴�");
						input = in.readLine();

						switch (input) {
						case "1":
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "�ƽþƳ��װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "�����"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "�̽�Ÿ�װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;

							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "�����װ�"));
								} catch (Exception e) {

									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "������"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����", input2, "Ƽ�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}

						case "2":
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "�ƽþƳ��װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "�����"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "�̽�Ÿ�װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "������"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("����¡", input2, "Ƽ�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;

						case "3":
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "�ƽþƳ��װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "�����"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "�̽�Ÿ�װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "������"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�ϳ���", input2, "Ƽ�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;
						case "4":
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "�ƽþƳ��װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "�����"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "�̽�Ÿ�װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "������"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("ȫ��", input2, "Ƽ�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;

							}
							break;

						case "5":
							System.out.println("���ϴ� ��¥�� �Է����ּ��� (�Է¿���)20180716");
							input2 = in.readLine();
							System.out.println("�װ��縦 �Է����ּ���");
							System.out.println("1.�����װ�    2.�ƽþƳ��װ� 3.����� 4.�̽�Ÿ�װ� 5.�����װ� 6.������ 7.Ƽ�����װ� 0.�����޴�");
							input3 = in.readLine();
							switch (input3) {
							case "1":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "2":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "�ƽþƳ��װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "3":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "�����"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "4":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "�̽�Ÿ�װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "5":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "6":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "������"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "7":
								try {
									EndView.printAll1(DepartureDAO.getSchedule("�����ī", input2, "Ƽ�����װ�"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case "0":
								break;
							}
							break;
						case "0":
							// �����޴�
							break;
						}
						break;
					case "3": // �� ��������
						LoginDAO.printBookMark1();
						break;
					case "0":
						return;

					}
				}
			} else {

				// ������ ����

				while (!input.equals("0")) {
					System.out.println("\n<�����ڷ� �α��� �ϼ̽��ϴ�. ���Ͻô� �۾��� �������ּ���>");
					System.out.println("1. ������ �������� �߰�  2. ������ �������� ����  3. ������ �������� ����");
					System.out.println("4. ����� �������� �߰�  5. ����� �������� ����  6. ����� �������� ���� 0. ���α׷�����");
					input = in.readLine();
					switch (input) {
					case "1":
						System.out.println("<�߰��� ������ ���������� �Է����ּ���(�Է¿���) �����װ�,KE008,201807171722,201807171722,����,33,3>");
						input = in.readLine();
						String[] str = input.split(",");
						FlightDTO dto = new FlightDTO(str[0], str[1], str[2], str[3], str[4], Integer.parseInt(str[5]),
								Integer.parseInt(str[6]), number1++);
						if (FlightDAO.insert(dto)) {
							System.out.println("�߰� ����");
						} else {
							System.out.println("�߰� ����");
						}
						break;
					case "2":
						System.out.println("<������ ���������� �������� �Է����ּ���>");
						input = in.readLine();
						System.out.println("<��¥�� �ð��� �Է����ּ��� (�Է¿���)201807161500>");
						input2 = in.readLine();
						// DTO����� �����Դ�
						System.out.println("1. ���������ð�  2. �ⱸ��ȣ  3. ��ȭ�������̳ʹ�ȣ");
						input3 = in.readLine();
						System.out.println("<������ ���� �Է����ּ���>");
						input4 = in.readLine();
						if (FlightDAO.update(input, input2, input3, input4)) {
							System.out.println("���� ����");
						} else {
							System.out.println("���� ����");
						}

						break;
					case "3":
						System.out.println("<������ ���������� �������� �Է����ּ���>");
						input = in.readLine();
						System.out.println("<��¥�� �ð��� �Է����ּ��� (�Է¿���)201807161500>");
						input2 = in.readLine();
						if (FlightDAO.delete(input, input2)) {
							System.out.println("���� ����");
						} else {
							System.out.println("���� ����");
						}break;
					case "4":
						System.out
								.println("<�߰��� ����� ���������� �Է����ּ���(�Է¿���) �����װ�,KE008,201807171722,201807171722,c,����,33,3>");
						input = in.readLine();
						String[] str1 = input.split(",");
						DepartureDTO dto1 = new DepartureDTO(str1[0], str1[1], str1[2], str1[3], str1[4], str1[5],
								Integer.parseInt(str1[6]), Integer.parseInt(str1[7]), number1++);
						if (DepartureDAO.insert(dto1)) {
							System.out.println("�߰� ����");
						} else {
							System.out.println("�߰� ����");
						}
						break;
					case "5":
						System.out.println("<������ ����� ���������� �������� �Է����ּ���>");
						input = in.readLine();
						System.out.println("<��¥�� �ð��� �Է����ּ��� (�Է¿���)201807161500>");
						input2 = in.readLine();
						// DTO����� �����Դ�
						System.out.println("1. ���������ð�  2. �ⱸ��ȣ  3. ��ȭ�������̳ʹ�ȣ");
						input3 = in.readLine();
						System.out.println("<������ ���� �Է����ּ���>");
						input4 = in.readLine();
						if (DepartureDAO.update(input, input2, input3, input4)) {
							System.out.println("���� ����");
						} else {
							System.out.println("���� ����");
						}

						break;
					case "6":
						System.out.println("<������ ����� ���������� �������� �Է����ּ���>");
						input = in.readLine();
						System.out.println("<��¥�� �ð��� �Է����ּ��� (�Է¿���)201807161500>");
						input2 = in.readLine();
						if (DepartureDAO.delete(input, input2)) {
							System.out.println("���� ����");
						} else {
							System.out.println("���� ����");
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
