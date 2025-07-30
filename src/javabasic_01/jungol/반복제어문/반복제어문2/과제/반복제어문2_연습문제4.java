package javabasic_01.jungol.반복제어문.반복제어문2.과제;

import java.util.Scanner;

public class 반복제어문2_연습문제4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
