package jungol.선택제어문.자가진단;

import java.util.Scanner;

public class 선택제어문_자가진단9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
