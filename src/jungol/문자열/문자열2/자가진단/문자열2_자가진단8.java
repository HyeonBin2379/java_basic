package jungol.문자열.문자열2.자가진단;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열2_자가진단8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = new String[3];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.next();
        }
        Arrays.sort(strings);
        System.out.println(strings[0]);
    }
}
