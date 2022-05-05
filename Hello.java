package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @Controller annotation을 달아줘야 원격 호출 가능한 프로그램으로 등록할 수 있다.
public class Hello {
	int iv = 10;		// 인스턴스 변수, iv는 객체 생성 후에 호출 가능
	static int cv = 20;	// static 변수
	
	// @RequestMapping으로 인해 접근제한자가 private여도 호출할 수 있다.(물론 내부에서는 private 그대로 적용된다. 외부 호출만 가능)
	// Reflection API 덕분에 가능(Reflection API : class 정보를 얻고 다룰 수 있는 기능 제공)(java.lang.reflect package)
	@RequestMapping(value = "/hello", method = RequestMethod.GET)	// URL과 method 맵핑
	
	private void run() {				// 인스턴스 메소드 --> iv와 cv 모두 사용가능
										// Hello class의 객체(instance)를 만든 후에야 run method를 사용할 수 있기에
										// 객체(instance)를 만든 후라면 iv와 cv 변수 또한 모두 사용할 수 있다.
		
		System.out.println("Hello!");
		System.out.println(iv);			// 사용가능
		System.out.println(cv);			// 사용가능
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public static void run2() {			// static 메소드 --> cv만 사용가능
										// static method를 호출 했을 때 객체가 무조건 있다는 보장이 없으므로(있을 수도 없을 수도 있으니까)
										// static method에서 iv는 사용 불가(인스턴스 멤버 사용 불가)
										// 동일한 이유로 static method에서는 instance mehtod도 사용할 수 없다.
		
		// System.out.println(iv);		// Error, 사용불가
		System.out.println(cv);			// 사용가능
	}
}
/*
 * 현재 run method에 static이 붙지 않았는데 어떻게 호출할 수 있을까?
 * - 현재 run method는 instance mehtod이다.
 * - 즉, Hello class의 객체(instance)를 생성한 후에야 run method를 호출할 수 있다는 것이다.
  
 * - 근데 현재 Hello class의 객체(instance)를 생성하지 않았음에도 run method를 호출할 수 있다는 것은
 * 중간에서 누군가가 Hello class의 객체(instance)를 생성해준다는 것이다.
 * - 이걸 '톰캣'이 해준다.
 * - 사용자가 주소창에 입력한 URL 값으로 @Controller의 특정 method가 호출되면 톰캣이 해당 method가 있는
 * class의 객체(instance)를 생성한다는 것이다. 그 후에 method가 호출된다. 
 * - 그렇기에 instance mehtod 임에도 호출할 수 있는 것이다.
 
 * - 그러면 왜 instance mehtod로 할까?
 * - static method는 iv를 사용할 수 없기에 가능하면 모든 변수를 사용할 수 있는 instance mehtod가 좋다.
 * cf) static method를 호출해도 톰캣은 동일하게 객체 생성 후 해당 static method를 호출한다.
 */