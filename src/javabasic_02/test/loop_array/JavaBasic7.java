package javabasic_02.test.loop_array;

public class JavaBasic7 {

    public static void main(String[] args) {
        System.out.print(makeDiamond(5));
    }

    public static String makeDiamond(int oddNumber) {
        StringBuilder sb = new StringBuilder();
        int half = oddNumber/2;     // 홀수를 2로 나눈 몫

        for (int i = 0; i < oddNumber; i++) {
            int spaceCount = Math.abs(i - half);    // 공백 문자의 개수
            int charCount = 2*(half-spaceCount)+1;  // 문자 @의 개수

            sb.append(" ".repeat(spaceCount))
                    .append("@".repeat(charCount)).append("\n");
        }
        return sb.toString();
    }
}
