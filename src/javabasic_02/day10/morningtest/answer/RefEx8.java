package javabasic_02.day10.morningtest.answer;

public class RefEx8 {

    public static void main(String[] args) {
        int[][] array = {{95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}};

        int totalSum = 0;
        int totalCount = 0;

        for (int[] row : array) {
            totalCount += row.length;

            for (int j = 0; j < row.length; j++) {
                totalSum += row[j];
            }
        }
        double avg = (double)totalSum/totalCount;

        System.out.println("totalSum : " + totalSum);
        System.out.println("avg : " + avg);
    }
}
