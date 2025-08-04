package jungol.문자열.문자열2.자가진단;

import java.util.Scanner;

public class 문자열2_자가진단10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((!sb.toString().contains(".") && ch == '.') || Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                break;
            }
        }

        double num = Double.parseDouble(sb.toString());
        System.out.println((int)(2*num));
        System.out.printf("%.2f\n", num);
    }
}
