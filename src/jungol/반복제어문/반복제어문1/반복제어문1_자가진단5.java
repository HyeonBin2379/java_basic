package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_자가진단5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();

            if (num == -1) {
                break;
            }
            if (num % 3 == 0) {
                System.out.println(num/3);
            }
        }
    }
}
