package javabasic_01.jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 배열2_형성평가10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] array = new char[3][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.next().charAt(0);
            }
        }

        for (char[] chars : array) {
            for (char ch : chars) {
                char newChar = (char) (ch + 32);

                System.out.print(newChar + " ");
            }
            System.out.println();
        }
    }
}
