package kr.co.springContainner;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// ## 기존(Java방식)
		//TransPortationWalk transPortationWalk = new TransPortationWalk();
		//transPortationWalk.move();
		
		// ## 스프링 컨테이너(applicationContext.xml)에 접근
		// 1) applictionContext.xml이 하나 일 때,
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 2) xml파일(스프링설정파일)이 여러개 일때 아래와 같이 스프링 설정파일을 배열에 넣어 사용 
		// (혹은 하나의 스프링설정파일에 나머지 설정파일들을 import하여 사용 ex)appCtxImport.xml)
		String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"}; // ★ 스프링 컨테이너가 만들어지는 시점 (스프링컨테이너 생성되면서, Bean객체 생성)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);
		
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtxImport.xml");
		
		// 스프링 컨테이너에서 빈(Id와 Class명의)을 가져와 TransPortationWalk타입에 담는다.
		TransportationWalk transportationWalk= ctx.getBean("tWalk",TransportationWalk.class);
		// 가져온 객체를 통해 사용한다.
		transportationWalk.move();
		
		// 사용 후에는 반환을 해준다.
		ctx.close(); //★ 스프링 컨테이너 소멸되는 시점
		
		
		// Bean객체의 생명주기 = 스프링컨테이너의 생명주기
		
		// Bean객체가 생성될때, 어떤 작업을 할 수 있다.
		// 1. 인터페이스를 통해 구현
		// (1) InitializingBean 의 afterPropertiseSet()
		// (2) DisposableBean 의 destory()
		
		// 2. 스프링 설정 파일에서 bean객체 생성시
		// init-method와 destory-method 사용
		
	}

}
