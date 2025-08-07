package javabasic_02.day11.sec05.exam02;

public class SportsCar extends Car {
	@Override
	public void speedUp() {
		speed += 10;
		if (speed == 0) {
			super.stop();
		}
	}

}