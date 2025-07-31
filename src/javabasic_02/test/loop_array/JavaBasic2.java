package javabasic_02.test.loop_array;

import java.util.stream.IntStream;

public class JavaBasic2 {

    public static void main(String[] args) {
        int total = getThreeMultipleSum();
        System.out.println(total);
    }

    private static int getThreeMultipleSum() {
        return IntStream.rangeClosed(1, 100)
                .filter(num -> num % 3 == 0)
                .sum();
    }
}
