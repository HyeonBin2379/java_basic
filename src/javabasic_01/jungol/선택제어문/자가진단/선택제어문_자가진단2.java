package javabasic_01.jungol.선택제어문.자가진단;

import java.util.Scanner;

public class 선택제어문_자가진단2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();

        int result = weight+100-height;

        System.out.println(result);
        if (result > 0) {
            System.out.println("Obesity");
        }
    }
}
