package javabasic_01.day04;

import java.util.Scanner;

public class ForEx01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 번 반복할까요?");
        int number = sc.nextInt();

        int i = 1;
        for (i = 1; i <= number; i++) {
            System.out.println(i + "번째");
        }
        System.out.println(i);
    }
}
