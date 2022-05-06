package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// ������� �Է��ϸ� �ش� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {

	// public static void main(String[] args) {
	@RequestMapping(value = "/getYoil", method = RequestMethod.GET)
	public void main(HttpServletRequest requests, HttpServletResponse response) throws Exception {
		/*
		 * parameter �ڸ��� HttpServletRequest, HttpServletResponse �� �ʿ��� ���� ���⸸ �ϸ�
		 * ��Ĺ�� �˾Ƽ� �ش� ��ü�� ������ش�.
		 */
		
		// 1.�Է�(����� �Է°� ���� : http://localhost:8120/ch2/getYoil?year=2022&month=05&day=02)
		String year = requests.getParameter("year");
		String month = requests.getParameter("month");
		String day = requests.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. �۾�
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// DAY_OF_WEEK = ����(1 = �Ͽ���, 2 = ������...)
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		// 3. ���
		System.out.println(year + "�� " + month + "�� " + day + "���� ");		System.out.println(year + "�� " + month + "�� " + day + "���� ");
		System.out.println(yoil + "�����Դϴ�.");
		System.out.println(yoil + "�����Դϴ�.");
		
		/*
		 * ������ �������� ����غ���
		 * �������� ����ϱ� ���� (HttpServletResponse response)�� main method�� parameter�� �߰�
		 */
		response.setContentType("text/html");	// ����� ������ Ÿ�� ����(�������� server�� ������ ������ �ؽ�Ʈ���� ���̳ʸ����� �𸣹Ƿ� ������ ������Ѵ�.)
		response.setCharacterEncoding("utf-8");	// ����� ������ ���ڵ� ����(�ؽ�Ʈ�� ���ڵ� Ÿ�Ե� �𸣹Ƿ� ������ ������Ѵ�.)
		
		// setContentType, setCharacterEncoding ������ �� ������ PrintWriter Ÿ�� ���������� �����ؾ� �ѱ��� ������ �ʰ� ��µȴ�.
		// [PrintWriter out = response.getWriter()] ���� ������ ������ setContentType, setCharacterEncoding ������ �ϸ� �ѱ��� ����ä ��µȴ�.
		// why? �Ʒ��� out ������ response�κ��� �����ǹǷ� response�� ���� ������ ���� ���־�� out�� ������ ������ ������.
		PrintWriter out = response.getWriter(); // setContentType, setCharacterEncoding ������ �� response ��ü�κ��� ���������� ��� ��Ʈ���� ��´�.
		out.println(year + "�� " + month + "�� " + day + "���� ");
		out.println(yoil + "�����Դϴ�.");
	}
}