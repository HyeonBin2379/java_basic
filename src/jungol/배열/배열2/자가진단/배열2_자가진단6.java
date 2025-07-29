package jungol.배열.배열2.자가진단;

import java.util.Scanner;

public class 배열2_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] students = new int[5][4];
        int[] totalByStudent = new int[5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                students[i][j] = sc.nextInt();
                totalByStudent[i] += students[i][j];
            }
        }

        int successful = 0;
        for (int i = 0; i < 5; i++) {
            if (totalByStudent[i] >= 320) {
                System.out.println("pass");
                successful++;
            } else {
                System.out.println("fail");
            }
        }
        System.out.println("Successful : " + successful);
    }
}
