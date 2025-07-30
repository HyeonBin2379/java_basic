package javabasic_01.jungol.연산자.자가진단;

import java.util.Scanner;

public class 연산자_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean result1 = a > b;
        boolean result2 = a < b;

        System.out.printf("%d > %d --- %d\n", a, b, result1 ? 1 : 0);
        System.out.printf("%d < %d --- %d\n", a, b, result2 ? 1 : 0);
        System.out.printf("%d >= %d --- %d\n", a, b, !result2 ? 1 : 0);
        System.out.printf("%d <= %d --- %d\n", a, b, !result1 ? 1 : 0);
    }
}
