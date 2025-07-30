package javabasic_01.jungol.연산자.과제;

public class 연산자_연습문제8 {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 2;

        boolean isATrue = a != 0;
        boolean isBTrue = b != 0;
        boolean isCTrue = c != 0;

        System.out.print((isATrue || isBTrue ? 1 : 0) + " ");
        System.out.print((isBTrue && isCTrue ? 1 : 0) + " ");
        System.out.print((isATrue && isCTrue ? 1 : 0) + " ");
        System.out.print((!isATrue ? 1 : 0) + " ");
    }
}
