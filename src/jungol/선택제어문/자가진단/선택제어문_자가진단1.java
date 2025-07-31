package jungol.선택제어문.자가진단;

import java.util.Scanner;

public class 선택제어문_자가진단1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(num);
        if (num < 0) {
            System.out.println("minus");;
        }
    }
}
