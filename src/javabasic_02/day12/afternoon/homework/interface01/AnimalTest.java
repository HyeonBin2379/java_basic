package javabasic_02.day12.afternoon.homework.interface01;

public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);

		// Cheatable은 fly를 호출할 수 있으나, run이 없기 때문에
		// cheatableChicken은 Chicken 객체를 참조
		Chicken cheatableChicken = new Chicken(5);

		if (cheatableChicken instanceof Cheatable) {
			cheatableChicken.fly();
		}

		// instanceof 연산자는 참조변수의 객체가 지정한 클래스/인터페이스 타입의 하위 클래스인 경우에도 참
		// Chicken 객체는 Cheatable 인터페이스를 구현한 클래스이므로 조건식은 참
//		if (cheatableChicken instanceof Chicken) {
//			cheatableChicken.fly();
//		}

        for (int i = 1; i <= 3; i++) {
			dog.run(1);
			chicken.run(1);
			cheatableChicken.run(1);

			System.out.println(i + "시간 후");
			System.out.printf("개의 이동거리=%.1f\n", dog.getDistance());
			System.out.printf("닭의 이동거리=%.1f\n", chicken.getDistance());
			System.out.printf("날으는 닭의 이동거리=%.1f\n", cheatableChicken.getDistance());
		}
	}
}












