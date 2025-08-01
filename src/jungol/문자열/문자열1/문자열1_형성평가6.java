package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_형성평가6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (input.length() > 1) {
            int index = sc.nextInt();

            if (index >= input.length()) {
                input = input.substring(0, input.length()-1);
            } else {
                input = input.substring(0, index-1) + input.substring(index);
            }
            System.out.println(input);
        }
    }
}
