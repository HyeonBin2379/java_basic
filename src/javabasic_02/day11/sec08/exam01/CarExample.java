package javabasic_02.day11.sec08.exam01;

public class CarExample {
	public static void main(String[] args) {
		//Car 객체 생성
		Car myDreamCar = new Car();

		//Tire 객체 장착
		myDreamCar.tire = new Tire();
		myDreamCar.run();

		//KumhoTire 객체 장착
		myDreamCar.tire = new KumhoTire();
		myDreamCar.run();

		//HankookTire 객체 장착
		myDreamCar.tire = new HankookTire();
		myDreamCar.run();

	}
}