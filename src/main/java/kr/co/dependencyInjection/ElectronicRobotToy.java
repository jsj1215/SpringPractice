package kr.co.dependencyInjection;

public class ElectronicRobotToy {
	
	// 배터리 교체형 : 배터리 제공 X, 사용자가 필요에 의해 배터리 구매해서 넣음
	private Battery battery;
	
	// 생성자에서 주입X
	public ElectronicRobotToy() {
		
	}
	// Setter통해 주입
	public void SetBattery(Battery battery) {
		this.battery = battery;
	}

}
