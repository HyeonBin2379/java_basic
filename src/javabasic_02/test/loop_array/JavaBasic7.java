package javabasic_02.test.loop_array;

public class JavaBasic7 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int value = Math.abs(i-2);
            System.out.print(" ".repeat(value));
            System.out.println("@".repeat(2*Math.abs(2-value)+1));
        }
    }
}
