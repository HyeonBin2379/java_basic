package javabasic_01.jungol.배열.배열2.자가진단;

import java.util.Scanner;

public class 배열2_자가진단1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[26];

        for (int i = 1; i <= 100; i++) {
            char ch = sc.next().charAt(0);
            if (ch < 'A' || ch > 'Z') {
                break;
            }
            int index = ch-'A';
            count[index]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                char alphabet = (char)('A'+i);
                System.out.printf("%c : %d\n", alphabet, count[i]);
            }
        }
    }
}
