package javabasic_02.day07;

public class ArrayExam {

    public static void main(String[] args) {
        char[] apple = {'A', 'P', 'P', 'L', 'E'};
        for (char c : apple) {
            // System.out.print(String.valueOf(c).toLowerCase());
            System.out.print(Character.toLowerCase(c));
        }
    }
}
