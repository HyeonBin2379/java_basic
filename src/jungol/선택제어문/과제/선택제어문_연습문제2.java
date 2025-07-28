package jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_연습문제2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            System.out.printf("입력받은 수 중 큰 수는 %d이고 작은 수는 %d입니다.\n", a, b);
        }
        if (a < b) {
            System.out.printf("입력받은 수 중 큰 수는 %d이고 작은 수는 %d입니다.\n", b, a);
        }
    }
}
