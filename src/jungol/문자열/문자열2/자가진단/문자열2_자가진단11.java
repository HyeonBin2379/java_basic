package jungol.문자열.문자열2.자가진단;

import java.util.Scanner;

public class 문자열2_자가진단11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            sb.append(num);
        }

        for (int i = 0; i < sb.length(); i += 3) {
            String newStr = sb.substring(i, Math.min(i+3, sb.length()));
            System.out.println(newStr);
        }
    }
}
