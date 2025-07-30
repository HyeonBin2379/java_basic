package javabasic_01.jungol.반복제어문.반복제어문2.과제;

public class 반복제어문2_연습문제2 {

    public static void main(String[] args) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch);
        }
        System.out.println();

        for (int i = 0; i < 26; i++) {
            char ch = (char)('A'+i);
            System.out.print(ch);
        }
        System.out.println();

        for (int i = 0; i < 26; i++) {
            int ch = 65;
            System.out.printf("%c", ch+i);
        }
        System.out.println();

        int total = 0;
        for (int i = 1; i <= 50; i++) {
            int sum = i + (101-i);
            total += sum;
        }
        System.out.printf("1~100의 총합: %d\n", total);
    }
}
