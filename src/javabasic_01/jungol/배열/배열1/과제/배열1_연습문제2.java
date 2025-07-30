package javabasic_01.jungol.배열.배열1.과제;

public class 배열1_연습문제2 {

    public static void main(String[] args) {
        char[] alphabet = new char[26];
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int index = ch-'A';

            alphabet[index] = ch;
        }

        for (int i = 26; i >= 1; i--) {
            System.out.print(alphabet[i-1] + " ");
        }
    }
}
