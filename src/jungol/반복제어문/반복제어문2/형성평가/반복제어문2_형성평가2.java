package jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            System.out.print(i + " ");
        }
    }
}
