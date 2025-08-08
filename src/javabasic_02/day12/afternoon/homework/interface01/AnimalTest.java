package javabasic_02.day12.afternoon.homework.interface01;

public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);
		Chicken cheatableChicken = new Chicken(5);

		Animal[] animals = {dog, chicken, cheatableChicken};
		if (animals[2] instanceof Cheatable) {
			((Cheatable) animals[2]).fly();
		}

        for (int i = 1; i <= 3; i++) {
			System.out.println(i + "시간 후");
            for (Animal animal : animals) {
                animal.run(1);
            }

			System.out.printf("개의 이동거리=%.1f\n", animals[0].getDistance());
			System.out.printf("닭의 이동거리=%.1f\n", animals[1].getDistance());
			System.out.printf("날으는 닭의 이동거리=%.1f\n", animals[2].getDistance());
		}
	}
}












