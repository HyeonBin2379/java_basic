package javabasic_01.jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 윷놀이 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] trials = new int[3][4];
        String[] result = {"D", "C", "B", "A", "E"};

        for (int i = 1; i <= 3; i++) {
            int baeTotal = 0;
            for (int j = 0; j < 4; j++) {
                trials[i-1][j] = sc.nextInt();
                baeTotal += trials[i-1][j];
            }
            System.out.println(result[baeTotal]);
        }
    }
}
