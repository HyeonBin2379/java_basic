package javabasic_02.day09.methods;

import java.util.Scanner;

public class Example03 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("두 수를 차례로 입력해주시면 나누기 결과를 제공해 드립니다.");
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        int result = division();
        System.out.printf("요청하신 %d / %d의 나누기 결과는 %d\n", n1, n2, result);
        System.out.println(result);
    }

    public static int division() {
        int n1 = 10, n2 = 5, result = 0;
        if (n2 != 0) {
            result = n1/n2;
        } else {
            System.out.println("0으로 나누기 금지");
        }
        return result;
    }
}
