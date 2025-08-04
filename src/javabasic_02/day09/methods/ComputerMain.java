package javabasic_02.day09.methods;

public class ComputerMain {

    public static void main(String[] args) {
        Computer computer = new Computer();
//        int result = computer.totalSum(1, 2, 3, 4, 5);
        int[] data = computer.initialize(5);
        int result = computer.totalSum(data);
        System.out.printf("1부터 5까지의 누적합은 %d입니다.\n", result);
    }
}
