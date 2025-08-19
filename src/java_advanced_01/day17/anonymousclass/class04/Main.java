package java_advanced_01.day17.anonymousclass.class04;

public class Main {

    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 20;

        // 계산기 객체를 생성할 수 있도록 피연산자를 생성자에게 전달
        Calculator calculator = new Calculator(number1, number2);
        int result1 = calculator.calculate(new Operate() {
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        });
        System.out.println(result1);

        int result2 = calculator.calculate(new Operate() {
            @Override
            public int operate(int a, int b) {
                return a-b;
            }
        });
        System.out.println(result2);
    }
}
