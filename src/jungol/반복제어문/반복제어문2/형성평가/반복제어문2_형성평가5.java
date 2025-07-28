package jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();

            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("even : " + evenCount);
        System.out.println("odd : " + oddCount);
    }
}
