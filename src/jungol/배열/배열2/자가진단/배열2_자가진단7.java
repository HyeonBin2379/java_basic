package jungol.배열.배열2.자가진단;

public class 배열2_자가진단7 {

    public static void main(String[] args) {
        int[][] array = new int[5][5];
        for (int i = 0; i < 5; i++) {
            array[i][0] = 1;
            array[0][i] = 1;
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                array[i][j] = array[i-1][j]+array[i][j-1];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
