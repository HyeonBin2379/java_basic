package javabasic_02.day11.sec02;

public class SmartPhone extends Phone {
	//필드 선언
	public boolean wifi;

	//생성자 선언
	// 파라미터가 존재하는 생성자로 오버로딩 시 컴파일러가 기본 생성자를 생성해주지 않으므로,
	// 기본 생성자는 별도로 만들어야 함.
	public SmartPhone() {
	}

	public SmartPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}

	//메소드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}