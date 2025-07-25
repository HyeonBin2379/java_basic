package day03;

public class OperatorEx02 {

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 10;

        // n1과 n2의 값이 같은가? 결과를 result1에 저장하여 출력
        boolean result1 = (n1 == n2);
        System.out.println(result1);    // true

        boolean result2 = (n1 != n2);
        System.out.println(result2);    // false

        boolean result3 = (n1 > n2);
        System.out.println(result3);    // false

        int n3 = 1;
        double n4 = 1.0;
        boolean result4 = (n3 == n4);
        System.out.println(result4);    // true
    }
}
