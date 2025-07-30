package javabasic_01.jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_형성평가1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = new char[10];
        for (int i = 0; i < 10; i++) {
            chars[i] = sc.next().charAt(0);
        }

        for (int i = 9; i >= 0; i--) {
            System.out.print(chars[i] + " ");
        }
    }
}
