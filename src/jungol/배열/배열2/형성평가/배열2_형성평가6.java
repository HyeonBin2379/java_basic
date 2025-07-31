package jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 배열2_형성평가6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[7][7];
        array[1][1] = 1;
        array[1][3] = 1;
        array[1][5] = 1;

        for (int i = 2; i < array.length; i++) {
            for (int j = 1; j < array[i].length-1; j++) {
                array[i][j] = array[i-1][j-1]+array[i-1][j+1];
            }
        }

        for (int i = 1; i < array.length-1; i++) {
            for (int j = 1; j < array.length-1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
