package jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            int res = num*i;

            System.out.print(res + " ");
        }
    }
}
