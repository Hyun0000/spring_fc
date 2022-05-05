package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {	// ���� ó�� �ʿ�
		// Hello hello = new Hello();
		// hello.run();
		// ���� run method�� ���������ڰ� private �̱⿡ ȣ�� �Ұ�
// ==============================================================================================================================
		/*
		 * Reflection API�� �̿��� ��ü�� �����ϰ� run method�� ȣ���غ���
		 */
		// 1. Hello class�� 'Class ��ü'�� ���´�.(Class ��ü = Hello Ŭ������ ������ ����ִ� ��ü)
		// �� Ŭ���� ����(Class ��ü)�� �̿��ؼ� Hello class�� ��ü�� ����� �ִ�.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");	// forName() ���� ��Ű������ ������ class ���� �ִ´�.

		// 2. Class ��ü�� �̿��� Hello class�� instance(��ü) �����
		Hello hello2 = (Hello)helloClass.newInstance();	// Class ��ü�� ���� ������ ��ü ����
		
		/*
		 * ���� private�� Hello class�� run method�� �ۿ����� ȣ���� �� �ְ� �غ���
		 */
		// 3. run method�� ���� ������ ������ �� �ܺο����� ȣ�� �����ϰ� �����غ���
		Method run = helloClass.getDeclaredMethod("run");
		run.setAccessible(true); // private�� run�� ȣ�� �����ϰ� �Ѵ�.
		run.invoke(hello2);		 // hello2.run(); �� ������ ������ �ڵ�
	}
}