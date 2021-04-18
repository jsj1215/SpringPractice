package kr.co.dependencyInjection;

public class Battery {

	// # DI (DependencyInjection)의존주입
	// : 객체에 의존하여 외부에서 주입하는 방법
	
	// 1. 생성자에서 주입 ex) ElctronicCarToy
	// 2. Setter를 이용하여 주입 ex) ElctronicRobotToy
	// 3. 생성자에서도 주입 & Setter를 이용하여도 주입 ex) ElctronicRadioToy -> ★가장 유연한 개발
	
	// # 스프링 DI
	// 스프링컨테이너안에서 객체들끼리 서로 의존하고 있는 경우
	// (ex. 배터리 객체가 토이 안에 주입되어 있는 경우)
	
}
