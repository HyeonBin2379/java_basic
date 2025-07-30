package javabasic_01.jungol.반복제어문.반복제어문3.과제;

public class 반복제어문3_연습문제3 {

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= Math.min(i, 7-i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
