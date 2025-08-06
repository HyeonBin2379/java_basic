package javabasic_02.day11.interitance.calculator;

public class Inheritance01 extends Calculation {

    public void multiplication(int num1, int num2) {
        int result = num1 * num2;
        System.out.println("두 수의 곱셈: " + result);
    }
}
