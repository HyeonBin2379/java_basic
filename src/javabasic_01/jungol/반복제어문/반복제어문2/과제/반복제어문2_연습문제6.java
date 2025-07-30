package javabasic_01.jungol.반복제어문.반복제어문2.과제;

import java.util.Scanner;

public class 반복제어문2_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int count = 5;

        for (int i = 1; i <= count; i++) {
            int score = sc.nextInt();
            sum += score;
        }

        double avg = (double)sum/count;
        System.out.printf("총점 : %d\n", sum);
        System.out.printf("평균 : %.1f\n", avg);
    }
}
