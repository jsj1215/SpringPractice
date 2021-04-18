package kr.co.dependencyInjection;

public class ElectronicRadioToy {

	// 배터리 교체형 : 배터리 최초제공, 배터리 추후에 교체 가능
	private Battery battery;
	
	// 생성자에서도 주입
	public ElectronicRadioToy(Battery battery) {
		this.battery = battery;
	}
	// Setter에서도 주입
	public void SetBattery(Battery battery) {
		this.battery = battery;
	}
	
}
