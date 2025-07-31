package javabasic_02.test.loop_array;

public class JavaBasic6 {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            sb.append(makeLine(i)).append("\n");
        }
        System.out.print(sb);
    }

    private static String makeLine(int num) {
        return " ".repeat(num) + "*".repeat(6-num);
    }
}
