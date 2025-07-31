package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char yesOrNo = 0;

        do {
            System.out.print("Base = ");
            int base = Integer.parseInt(sc.next());
            System.out.print("Height = ");
            int height = Integer.parseInt(sc.next());

            double triangleWidth = base*height/2.0;
            System.out.printf("Triangle width = %.1f\n", triangleWidth);

            System.out.print("Continue? ");
            yesOrNo = sc.next().charAt(0);
        } while (yesOrNo == 'y' || yesOrNo == 'Y');
    }
}
