package javabasic_01.jungol.반복제어문.반복제어문2.자가진단;

import java.util.Scanner;

public class 반복제어문2_자가진단4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int sum = 0;

        for (int i = start; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
