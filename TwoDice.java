package com.fastcampus.ch2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TwoDice {
	@RequestMapping(value = "/rollDice", method = RequestMethod.GET)
	public void main(HttpServletResponse response) throws Exception {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int idx1 = (int)(Math.random() * 6) + 1;
		int idx2 = (int)(Math.random() * 6) + 1;
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> ������ �ֻ��� ��� </h3>");
		out.println("<img src='resources/img/dice1.jpg'>");
		out.println("<img src='resources/img/dice2.jpg'>");
		out.println("<hr/>");
		
		// (http://localhost:8120/ch2/rollDice)�� ������ ������ �������� �ֻ����� ��µǰ� �غ���
		out.println("<h3> ���� �ֻ��� ��� </h3>");
		out.println("<img src='resources/img/dice" + idx1 + ".jpg'>");
		out.println("<img src='resources/img/dice" + idx2 + ".jpg'>");
		
		out.println("</body>");
		out.println("</html>");
	}
}