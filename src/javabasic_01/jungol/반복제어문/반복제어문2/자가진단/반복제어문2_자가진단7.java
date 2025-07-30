package javabasic_01.jungol.반복제어문.반복제어문2.자가진단;

public class 반복제어문2_자가진단7 {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = i+1; j <= i+5; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
