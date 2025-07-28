package jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_연습문제1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;

        int i = 0;
        while (true) {
            if (sum > num) {
                break;
            }
            sum += (++i);
        }
        System.out.println(i + " " + sum);
    }
}
