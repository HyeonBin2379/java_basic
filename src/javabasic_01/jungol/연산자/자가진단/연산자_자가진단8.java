package javabasic_01.jungol.연산자.자가진단;

import java.util.Scanner;

public class 연산자_자가진단8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result1 = (a > b && b >= c) || (a > c && c >= b) ? 1 : 0;
        int result2 = (a == b && b == c) ? 1 : 0;

        System.out.println(result1 + " " + result2);
    }
}
