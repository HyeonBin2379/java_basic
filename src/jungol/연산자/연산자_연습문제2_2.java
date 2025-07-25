package jungol.연산자;

import java.util.Scanner;

public class 연산자_연습문제2_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("5개의 수를 입력하시오. ");
        int num1 = sc.nextInt();
        num1 = num1 + 3;
        System.out.print(num1 + " ");

        int num2 = sc.nextInt();
        num2 = num2-3;
        System.out.print(num2 + " ");

        int num3 = sc.nextInt();
        num3 = num3*3;
        System.out.print(num3 + " ");

        int num4 = sc.nextInt();
        num4 = num4/3;
        System.out.print(num4 + " ");

        int num5 = sc.nextInt();
        num5 = num5 % 3;
        System.out.print(num5);
    }
}
