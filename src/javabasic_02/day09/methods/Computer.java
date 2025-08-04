package javabasic_02.day09.methods;

public class Computer {

    int[] numbers;

    // 가변 길이 매개변수: 메소드 호출 시 매개변수의 개수에 맞는 매개값 제공 필수
    // 메서드가 가변길이 매개변수를 가지면 매개변수 개수에 관계없이 매개값 제공 가능
//    public int totalSum(int ... values) {
//        int total = 0;
//        for (int value : values) {
//            total += value;
//        }
//        return total;
//    }

    public int totalSum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public int[] initialize(int len) {
        numbers = new int[len];
        for (int i = 1; i <= len; i++) {
            numbers[i-1] = i;
        }
        return numbers;
    }
}
