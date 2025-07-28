package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int odd = 0;
        int even = 0;

        while (true) {
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }
            if (num % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }
        System.out.println("odd: " + odd);
        System.out.println("even: " + even);
    }
}
