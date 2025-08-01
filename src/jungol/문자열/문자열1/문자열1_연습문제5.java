package jungol.문자열.문자열1;

public class 문자열1_연습문제5 {

    public static void main(String[] args) {
        String input = "우리나라 대한민국!";
        byte[] bytes = input.getBytes();
        System.out.println(input);
        System.out.printf("위 문자열의 길이는 %d입니다.", bytes.length);
    }
}
