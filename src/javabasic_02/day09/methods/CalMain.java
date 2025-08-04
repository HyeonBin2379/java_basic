package javabasic_02.day09.methods;

public class CalMain {

    public static void main(String[] args) {
        MyCalculator1 myCalculator1 = new MyCalculator1();
        myCalculator1.numbers[0] = 10;
        System.out.println(myCalculator1.numbers[0]);

        myCalculator1.numbers[1] = 20;
        System.out.println(myCalculator1.numbers[1]);
        myCalculator1.adder(myCalculator1.numbers);
    }
}
