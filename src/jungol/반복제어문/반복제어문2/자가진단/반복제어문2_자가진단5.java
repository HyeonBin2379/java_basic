package jungol.반복제어문.반복제어문2.자가진단;

import java.util.Scanner;

public class 반복제어문2_자가진단5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int multipleThree = 0;
        int multipleFive = 0;
        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();

            if (num % 3 == 0) {
                multipleThree++;
            }
            if (num % 5 == 0) {
                multipleFive++;
            }
        }
        System.out.println("Multiples of 3 : " + multipleThree);
        System.out.println("Multiples of 5 : " + multipleFive);
    }
}
