package jungol.문자열.문자열2.자가진단;

import java.util.Scanner;

public class 문자열2_자가진단1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = new String[5];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.nextLine();
        }

        for (int i = strings.length-1; i >= 0; i--) {
            System.out.println(strings[i]);
        }
    }
}
