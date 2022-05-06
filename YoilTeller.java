package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 년월일을 입력하면 해당 요일을 알려주는 프로그램
@Controller
public class YoilTeller {

	// public static void main(String[] args) {
	@RequestMapping(value = "/getYoil", method = RequestMethod.GET)
	public void main(HttpServletRequest requests, HttpServletResponse response) throws Exception {
		/*
		 * parameter 자리에 HttpServletRequest, HttpServletResponse 등 필요한 것을 적기만 하면
		 * 톰캣이 알아서 해당 객체를 만들어준다.
		 */
		
		// 1.입력(사용자 입력값 예시 : http://localhost:8120/ch2/getYoil?year=2022&month=05&day=02)
		String year = requests.getParameter("year");
		String month = requests.getParameter("month");
		String day = requests.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// DAY_OF_WEEK = 요일(1 = 일요일, 2 = 월요일...)
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		System.out.println(year + "년 " + month + "월 " + day + "일은 ");		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
		System.out.println(yoil + "요일입니다.");
		System.out.println(yoil + "요일입니다.");
		
		/*
		 * 요일을 브라우저에 출력해보자
		 * 브라우저에 출력하기 위해 (HttpServletResponse response)를 main method의 parameter로 추가
		 */
		response.setContentType("text/html");	// 출력할 내용의 타입 설정(브라우저는 server가 보내는 내용이 텍스트인지 바이너리인지 모르므로 설정을 해줘야한다.)
		response.setCharacterEncoding("utf-8");	// 출력할 내용의 인코딩 설정(텍스트의 인코딩 타입도 모르므로 설정을 해줘야한다.)
		
		// setContentType, setCharacterEncoding 설정을 한 다음에 PrintWriter 타입 참조변수를 생성해야 한글이 깨지지 않고 출력된다.
		// [PrintWriter out = response.getWriter()] 먼저 생성한 다음에 setContentType, setCharacterEncoding 설정을 하면 한글이 깨진채 출력된다.
		// why? 아래의 out 변수는 response로부터 생성되므로 response에 대한 설정을 먼저 해주어야 out도 동일한 설정을 가진다.
		PrintWriter out = response.getWriter(); // setContentType, setCharacterEncoding 설정을 한 response 객체로부터 브라우저로의 출력 스트림을 얻는다.
		out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
	}
}