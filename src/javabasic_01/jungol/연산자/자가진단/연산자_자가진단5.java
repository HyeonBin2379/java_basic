package javabasic_01.jungol.연산자.자가진단;

import java.util.Scanner;

public class 연산자_자가진단5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a == b ? 1 : 0);
        System.out.println(a != b ? 1 : 0);
    }
}
