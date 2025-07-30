package javabasic_01.jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"dog", "cat", "chick"};

        System.out.print("Number? ");
        int num = sc.nextInt();

        if (num >= 1 && num <= 3) {
            System.out.println(arr[num-1]);
        } else {
            System.out.println("I don't know.");
        }
    }
}
