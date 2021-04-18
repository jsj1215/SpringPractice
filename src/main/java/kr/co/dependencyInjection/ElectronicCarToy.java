package kr.co.dependencyInjection;

public class ElectronicCarToy {

	// 배터리 일체형 : 배터리 교체 못함
	private Battery battery;
	
	// 생성자에서 객체 주입
	public ElectronicCarToy() {
		battery = new NormalBattery();
	}
}
