package javabasic_01.jungol.배열.배열2.자가진단;

import java.util.Scanner;

public class 배열2_자가진단2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[10];

        while (true) {
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }
            int digit = num/10;
            count[digit]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.printf("%d : %d\n", i, count[i]);
            }
        }
    }
}
