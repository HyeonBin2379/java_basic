package javabasic_01.jungol.연산자.과제;

import java.util.Scanner;

public class 연산자_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int q = a / b;
        int r = a % b;

        System.out.printf("%d / %d = %d ... %d\n", a, b, q, r);
    }
}
