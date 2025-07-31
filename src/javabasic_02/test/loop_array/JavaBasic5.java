package javabasic_02.test.loop_array;

public class JavaBasic5 {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            sb.append("*".repeat(i)).append("\n");
        }
        System.out.print(sb);
    }
}
