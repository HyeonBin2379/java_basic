package javabasic_02.day11.homework.constructor.q2;

import java.util.Scanner;

public class TestRectangle {
	public static void main(String s[]){
		Scanner keyboard = new Scanner(System.in);
		
		Rectangle rec1 = new Rectangle();
		System.out.println("첫번째 직사각형의 색깔: ");
		rec1.setColor(keyboard.next());
		System.out.println("첫번째 직사각형의 가로: ");
		rec1.setWidth(keyboard.nextInt());
		System.out.println("첫번째 직사각형의 세로: ");
		rec1.setLength(keyboard.nextInt());
		
		Rectangle rec2 = new Rectangle();
		System.out.println("두번째 직사각형의 색깔: ");
		rec2.setColor(keyboard.next());
		System.out.println("두번째 직사각형의 가로: ");
		rec2.setWidth(keyboard.nextInt());
		System.out.println("두번째 직사각형의 세로: ");
		rec2.setLength(keyboard.nextInt());
		
		System.out.println(rec1.getColor() + " 직사각형의 넓이는 " + rec1.area() + "이고 둘레는 " + rec1.perimeter() + "입니다.");
		System.out.println(rec2.getColor() + " 직사각형의 넓이는 " + rec2.area() + "이고 둘레는 " + rec2.perimeter() + "입니다.");
		
		// TODO 1) 두 직사각형의 넓이를 비교하십시오.
		compareArea(rec1, rec2);

		// TODO 2) 두 직사각형의 둘레를 비교하십시오.
		comparePerimeter(rec1, rec2);
	}

	public static void compareArea(Rectangle rec1, Rectangle rec2) {
		int area1 = rec1.area();
		int area2 = rec2.area();

		if (area1 > area2) {
			System.out.printf("넓이는 %s 직사각형이 더 큽니다.\n", rec1.getColor());
		} else if (area1 < area2) {
			System.out.printf("넓이는 %s 직사각형이 더 큽니다.\n", rec2.getColor());
		} else {
			System.out.println("넓이는 같습니다.");
		}
	}

	public static void comparePerimeter(Rectangle rec1, Rectangle rec2) {
		int perimeter1 = rec1.perimeter();
		int perimeter2 = rec2.perimeter();

		if (perimeter1 > perimeter2) {
			System.out.printf("둘레는 %s 직사각형이 더 큽니다.\n", rec1.getColor());
		} else if (perimeter1 < perimeter2) {
			System.out.printf("둘레는 %s 직사각형이 더 큽니다.\n", rec2.getColor());
		} else {
			System.out.println("둘레는 같습니다.");
		}
	}
}

