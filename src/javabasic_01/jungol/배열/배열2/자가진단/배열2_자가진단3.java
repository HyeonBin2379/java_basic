package javabasic_01.jungol.배열.배열2.자가진단;

import java.util.Scanner;

public class 배열2_자가진단3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = {100, n};

        int count = 1;
        Loop:
        while (true) {
            switch (count++) {
                case 1:
                    System.out.print(array[0] + " ");
                    break;
                case 2:
                    System.out.print(array[1] + " ");
                    break;
                default:
                    int temp = array[0]-array[1];
                    System.out.print(temp + " ");
                    if (temp < 0) {
                        break Loop;
                    }
                    array[0] = array[1];
                    array[1] = temp;
            }
        }
    }
}
