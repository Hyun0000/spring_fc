package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @Controller annotation�� �޾���� ���� ȣ�� ������ ���α׷����� ����� �� �ִ�.
public class Hello {
	int iv = 10;		// �ν��Ͻ� ����, iv�� ��ü ���� �Ŀ� ȣ�� ����
	static int cv = 20;	// static ����
	
	// @RequestMapping���� ���� ���������ڰ� private���� ȣ���� �� �ִ�.(���� ���ο����� private �״�� ����ȴ�. �ܺ� ȣ�⸸ ����)
	// Reflection API ���п� ����(Reflection API : class ������ ��� �ٷ� �� �ִ� ��� ����)(java.lang.reflect package)
	@RequestMapping(value = "/hello", method = RequestMethod.GET)	// URL�� method ����
	
	private void run() {				// �ν��Ͻ� �޼ҵ� --> iv�� cv ��� ��밡��
										// Hello class�� ��ü(instance)�� ���� �Ŀ��� run method�� ����� �� �ֱ⿡
										// ��ü(instance)�� ���� �Ķ�� iv�� cv ���� ���� ��� ����� �� �ִ�.
		
		System.out.println("Hello!");
		System.out.println(iv);			// ��밡��
		System.out.println(cv);			// ��밡��
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public static void run2() {			// static �޼ҵ� --> cv�� ��밡��
										// static method�� ȣ�� ���� �� ��ü�� ������ �ִٴ� ������ �����Ƿ�(���� ���� ���� ���� �����ϱ�)
										// static method���� iv�� ��� �Ұ�(�ν��Ͻ� ��� ��� �Ұ�)
										// ������ ������ static method������ instance mehtod�� ����� �� ����.
		
		// System.out.println(iv);		// Error, ���Ұ�
		System.out.println(cv);			// ��밡��
	}
}
/*
 * ���� run method�� static�� ���� �ʾҴµ� ��� ȣ���� �� ������?
 * - ���� run method�� instance mehtod�̴�.
 * - ��, Hello class�� ��ü(instance)�� ������ �Ŀ��� run method�� ȣ���� �� �ִٴ� ���̴�.
  
 * - �ٵ� ���� Hello class�� ��ü(instance)�� �������� �ʾ������� run method�� ȣ���� �� �ִٴ� ����
 * �߰����� �������� Hello class�� ��ü(instance)�� �������شٴ� ���̴�.
 * - �̰� '��Ĺ'�� ���ش�.
 * - ����ڰ� �ּ�â�� �Է��� URL ������ @Controller�� Ư�� method�� ȣ��Ǹ� ��Ĺ�� �ش� method�� �ִ�
 * class�� ��ü(instance)�� �����Ѵٴ� ���̴�. �� �Ŀ� method�� ȣ��ȴ�. 
 * - �׷��⿡ instance mehtod �ӿ��� ȣ���� �� �ִ� ���̴�.
 
 * - �׷��� �� instance mehtod�� �ұ�?
 * - static method�� iv�� ����� �� ���⿡ �����ϸ� ��� ������ ����� �� �ִ� instance mehtod�� ����.
 * cf) static method�� ȣ���ص� ��Ĺ�� �����ϰ� ��ü ���� �� �ش� static method�� ȣ���Ѵ�.
 */