package jungol.반복제어문.반복제어문3.과제;

public class 반복제어문3_연습문제7 {

    public static void main(String[] args) {
        int num = 0;
        char ch = 'a';

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++ + " ");
            }
            for (int j = 1; j <= 5-i; j++) {
                System.out.print((++num) + " ");
            }
            System.out.println(" ");
        }
    }
}
