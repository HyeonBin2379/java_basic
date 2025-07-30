package javabasic_01.jungol.선택제어문.자가진단;

import java.util.Scanner;

public class 선택제어문_자가진단3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age >= 20) {
            System.out.println("adult");
        } else {
            System.out.printf("%d years later\n", 20-age);
        }
    }
}
