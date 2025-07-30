package javabasic_01.jungol.반복제어문.반복제어문2.자가진단;

public class 반복제어문2_자가진단8 {

    public static void main(String[] args) {
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%d * %d = %2d   ", i, j, i*j);
            }
            System.out.println();
        }
    }
}
