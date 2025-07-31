package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] capitals = {"Seoul", "Washington", "Tokyo", "Beijing"};

        while (true) {
            System.out.println("1. Korea");
            System.out.println("2. USA");
            System.out.println("3. Japan");
            System.out.println("4. China");
            System.out.print("number? ");
            int num = sc.nextInt();
            if (num-1 < 0 || num-1 >= 4) {
                System.out.println("\nnone");
                break;
            }

            System.out.printf("\n%s\n\n", capitals[num-1]);
        }
    }
}
