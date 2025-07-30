package javabasic_01.jungol.연산자.자가진단;

import java.util.Scanner;

public class 연산자_자가진단7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean isATrue = a != 0;
        boolean isBTrue = b != 0;

        System.out.println((isATrue && isBTrue) + " " + (isATrue || isBTrue));
    }
}
