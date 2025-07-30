package javabasic_01.jungol.연산자.과제;

import java.util.Scanner;

public class 연산자_연습문제4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = ++a + b--;

        System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
    }
}
