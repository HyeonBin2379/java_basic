package javabasic_02.test.loop_array;

public class JavaBasic1 {

    public static void main(String[] args) {
        String grade = "B";
        int score1 = switch (grade) {
            case "A" -> 100;
            case "B" -> 80;
            default -> 60;
        };
        System.out.println(score1);
    }
}
