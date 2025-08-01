package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch < 'a' || ch > 'z') && (ch < '0' || ch > '9')) {
                continue;
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
