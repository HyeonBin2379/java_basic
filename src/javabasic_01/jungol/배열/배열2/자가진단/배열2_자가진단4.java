package javabasic_01.jungol.배열.배열2.자가진단;

public class 배열2_자가진단4 {

    public static void main(String[] args) {
        int[][] array = {{5, 8, 10, 6, 4}, {11, 20, 1, 13, 2}, {7, 9, 14, 22, 3}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%2d   ", array[i][j]);
            }
            System.out.println();
        }
    }
}
