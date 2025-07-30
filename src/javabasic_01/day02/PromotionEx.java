package javabasic_01.day02;

public class PromotionEx {

    public static void main(String[] args) {

        // byte < short, char < int < long < float < double
        byte byteValue = 10;
        int intValue = byteValue;   // 자동타입변환 수행

        long longValue = 500000000L;
        float floatValue = longValue;
        double doubleValue = longValue;

        System.out.println(floatValue);
        System.out.println(doubleValue);

        double d1 = 5e2;     // 5.0 * 10 * 10
        double d2 = 0.12E-2; // 0.12 * 0.01 = 0.0012
        double d3 = 3.14;
        double d4 = 314E-2;

        System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);

        float f1 = 3.14f;   // float 리터럴 값은 마지막에 f, F를 붙인다.
        float f2 = 3E6F;    // 3 * 10^6
        System.out.println(f1 + " " + f2);
    }
}
