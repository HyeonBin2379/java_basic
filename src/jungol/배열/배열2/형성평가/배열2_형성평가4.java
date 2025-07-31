package jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 배열2_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = {{3, 5, 9}, {2, 11, 5}, {8, 30, 10}, {22, 5, 1}};
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
                total += array[i][j];
            }
            System.out.println();
        }
        System.out.println(total);
    }
}
