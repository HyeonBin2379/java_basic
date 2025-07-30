package javabasic_01.jungol.반복제어문.반복제어문2.자가진단;

import java.util.Scanner;

public class 반복제어문2_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int score = sc.nextInt();
            sum += score;
        }
        double avg = (double)sum/n;
        System.out.printf("avg : %.1f\n", avg);
        if (avg >= 80.0) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }
}
