package jungol.문자열.문자열1.자가진단;

import java.util.Scanner;

public class 문자열1_자가진단9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for (int i = 1; i <= str.length(); i++) {
            String newStr = str.substring(str.length()-i) + str.substring(0, str.length()-i);
            System.out.println(newStr);
        }
    }
}
