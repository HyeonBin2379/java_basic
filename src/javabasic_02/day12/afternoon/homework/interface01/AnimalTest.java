package javabasic_02.day12.afternoon.homework.interface01;

public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);
		Chicken cheatableChicken = new Chicken(5);

		if (cheatableChicken instanceof Cheatable) {
			cheatableChicken.fly();
		}

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












