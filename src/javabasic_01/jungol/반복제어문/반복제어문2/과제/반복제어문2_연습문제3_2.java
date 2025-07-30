package javabasic_01.jungol.반복제어문.반복제어문2.과제;

import java.util.stream.IntStream;

public class 반복제어문2_연습문제3_2 {

    public static void main(String[] args) {
        IntStream.iterate(1, num -> num <= 20, num -> num+2)
                .forEach(num -> System.out.print(num + " "));
    }
}
