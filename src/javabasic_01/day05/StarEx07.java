package javabasic_01.day05;

public class StarEx07 {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            int value = Math.abs(5-i);

            for (int j = 1; j <= value; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 9-2*value; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
