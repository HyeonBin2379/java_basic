package jungol.문자열.문자열1.형성평가;

import java.util.Scanner;

public class 문자열1_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char ch = sc.next().charAt(0);
        int index = input.indexOf(ch);

        if (index == -1) {
            System.out.println("No");
        } else {
            System.out.println(index);
        }
    }
}
