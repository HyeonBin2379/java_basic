package javabasic_01.jungol.연산자.과제;

import java.util.Scanner;

public class 연산자_연습문제5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean result1 = a == b;
        boolean result2 = b == c;

        System.out.print((result1 ? 1 : 0) + " ");
        System.out.print((result2 ? 1 : 0) + " ");
        System.out.print((!result1 ? 1 : 0) + " ");
        System.out.print((!result2 ? 1 : 0) + " ");
    }
}
