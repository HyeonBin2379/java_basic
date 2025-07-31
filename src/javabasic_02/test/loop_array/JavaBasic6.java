package javabasic_02.test.loop_array;

public class JavaBasic6 {

    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            System.out.print(" ".repeat(i));
            System.out.print("*".repeat(6-i));
            System.out.println();
        }
    }
}
