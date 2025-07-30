package javabasic_01.jungol.배열.배열1.연습문제;

import java.util.Arrays;

public class 배열1_연습문제9 {

    public static void main(String[] args) {
        int[] scores = {95, 75, 85, 100, 50};
        Arrays.sort(scores);

        for (int i = 0; i < 5; i++) {
            System.out.print(scores[i] + " ");
        }
    }
}
