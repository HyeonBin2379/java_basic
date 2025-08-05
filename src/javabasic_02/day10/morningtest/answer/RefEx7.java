package javabasic_02.day10.morningtest.answer;

public class RefEx7 {

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 2};
        int max = 0;

        for (int j : array) {
            if (max < j) {
                max = j;
            }
        }
        System.out.println(max);
    }
}
