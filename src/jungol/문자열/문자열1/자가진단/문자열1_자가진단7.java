package jungol.문자열.문자열1.자가진단;

import java.util.Scanner;

public class 문자열1_자가진단7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
