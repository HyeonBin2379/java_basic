package javabasic_02.day11.inheritance.calculator;

public class Calculation {

    public void addition(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("두 수의 합: " + result);
    }

    public void subtraction(int num1, int num2) {
        int result = num1 - num2;
        System.out.println("두 수의 뺄셈: " + result);
    }
}
