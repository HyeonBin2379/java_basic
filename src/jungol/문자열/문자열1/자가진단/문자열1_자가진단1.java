package jungol.문자열.문자열1.자가진단;

import java.util.Scanner;

public class 문자열1_자가진단1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("ASCII code =? ");
            int num = sc.nextInt();

            if (num < 33 || num > 127) {
                break;
            }
            System.out.println((char)num);
        }
    }
}
