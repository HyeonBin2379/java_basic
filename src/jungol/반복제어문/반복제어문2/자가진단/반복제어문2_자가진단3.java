package jungol.반복제어문.반복제어문2.자가진단;

import java.util.Scanner;

public class 반복제어문2_자가진단3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
