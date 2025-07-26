package jungol.연산자.자가진단;

import java.util.Scanner;

public class 연산자_자가진단2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        a += 100;
        b %= 10;

        System.out.print(a + " " + b);
    }
}
