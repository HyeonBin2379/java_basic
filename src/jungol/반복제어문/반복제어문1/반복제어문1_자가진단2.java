package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_자가진단2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i = 1;
        int sum = 0;

        while (i <= num) {
            sum += i;
            i++;
        }

        System.out.println(sum);
    }
}
