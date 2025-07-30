package javabasic_01.jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 배열2_형성평가2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] result = new int[11];
        for (int i = 0; i < 100; i++) {
            int score = sc.nextInt();

            if (score == 0) {
                break;
            }

            int index = score/10;
            result[index]++;
        }

        for (int i = 10; i >= 1; i--) {
            if (result[i] > 0) {
                int scoreRange = 10*i;
                System.out.printf("%d : %d person\n", scoreRange, result[i]);
            }
        }
    }
}
