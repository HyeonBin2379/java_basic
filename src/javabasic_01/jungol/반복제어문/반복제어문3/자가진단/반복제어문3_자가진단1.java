package javabasic_01.jungol.반복제어문.반복제어문3.자가진단;

import java.util.Scanner;

public class 반복제어문3_자가진단1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        int count = 0;

        for (int i = 1; total < n; i += 2) {
            total += i;
            count++;
        }
        System.out.println(count + " " + total);
    }
}
