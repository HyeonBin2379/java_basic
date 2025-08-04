package jungol.문자열.문자열1.자가진단;

import java.util.Scanner;

public class 문자열1_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            char ch = sc.nextLine().charAt(0);

            if (!Character.isAlphabetic(ch)
                    && !Character.isDigit(ch)) {
                break;
            }
            if (Character.isDigit(ch)) {
                System.out.printf("%d\n", (int)ch);
            } else {
                System.out.printf("%c\n", ch);
            }
        }
    }
}
