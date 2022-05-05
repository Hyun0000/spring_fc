package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {	// 예외 처리 필요
		// Hello hello = new Hello();
		// hello.run();
		// 현재 run method의 접근제한자가 private 이기에 호출 불가
// ==============================================================================================================================
		/*
		 * Reflection API를 이용해 객체를 생성하고 run method를 호출해보자
		 */
		// 1. Hello class의 'Class 객체'를 얻어온다.(Class 객체 = Hello 클래스의 정보를 담고있는 객체)
		// 이 클래스 정보(Class 객체)를 이용해서 Hello class의 객체를 만들수 있다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");	// forName() 에는 패키지명을 포함한 class 명을 넣는다.

		// 2. Class 객체를 이용해 Hello class의 instance(객체) 만들기
		Hello hello2 = (Hello)helloClass.newInstance();	// Class 객체가 가진 정보로 객체 생성
		
		/*
		 * 현재 private인 Hello class의 run method를 밖에서도 호출할 수 있게 해보자
		 */
		// 3. run method에 대한 정보를 가져온 후 외부에서도 호출 가능하게 변경해보자
		Method run = helloClass.getDeclaredMethod("run");
		run.setAccessible(true); // private인 run을 호출 가능하게 한다.
		run.invoke(hello2);		 // hello2.run(); 과 동일한 역할의 코드
	}
}