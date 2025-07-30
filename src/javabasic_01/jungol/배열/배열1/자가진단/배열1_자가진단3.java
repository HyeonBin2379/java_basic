package javabasic_01.jungol.배열.배열1.자가진단;

import java.util.Scanner;

public class 배열1_자가진단3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[10];
        for (int i = 1; i <= 10; i++) {
            arr[i-1] = sc.next().charAt(0);
        }
        System.out.printf("%c %c %c\n", arr[0], arr[3], arr[6]);
    }
}
