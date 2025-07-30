package javabasic_01.jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_자가진단3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("number? ");
            int num = Integer.parseInt(sc.nextLine());

            if (num < 0) {
                System.out.println("negative number.");
            } else if (num > 0) {
                System.out.println("positive integer.");
            } else {
                break;
            }
        }
    }
}
