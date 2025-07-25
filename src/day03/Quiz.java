package day03;

import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        int price = 5000;
        System.out.printf("상품의 가격: %d원\n", price);
        System.out.printf("상품의 가격: %7d원\n", price);
        System.out.printf("상품의 가격: %07d원\n", price);

        Scanner sc = new Scanner(System.in);
        System.out.print("반지름을 입력하세요. ");
        int r = sc.nextInt();
        System.out.printf("반지름이 %d인 원의 넓이: %.1f\n", r, r*r*Math.PI);
    }
}
