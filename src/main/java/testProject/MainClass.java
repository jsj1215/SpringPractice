package testProject;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// ## 기존(Java방식)
		//TransPortationWalk transPortationWalk = new TransPortationWalk();
		//transPortationWalk.move();
		
		// ## 스프링 컨테이너(applicationContext.xml)에 접근
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 스프링 컨테이너에서 빈(Id와 Class명의)을 가져와 TransPortationWalk타입에 담는다.
		TransportationWalk transportationWalk= ctx.getBean("tWalk",TransportationWalk.class);
		// 가져온 객체를 통해 사용한다.
		transportationWalk.move();
		
		// 사용 후에는 반환을 해준다.
		ctx.close();
		
	}

}
