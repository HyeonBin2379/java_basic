package javabasic_01.day02;

public class TempEx02 {

    // 스왑 알고리즘
    public static void main(String[] args) {
        // 1. 변수 x, y를 선언한 후 각각을 3, 5로 초기화
        int x = 3;
        int y = 5;
        int temp = 0;

        System.out.printf("x = %d, y = %d, temp = %d\n", x, y, temp);

        // 2. 변수 x의 값을 새로 선언한 변수 temp에 저장
        temp = x;

        // 3. 변수 y의 값을 변수 x에 저장
        x = y;

        // 4. 변수 temp의 값을 변수 y에 저장
        y = temp;

        System.out.printf("x = %d, y = %d, temp = %d\n", x, y, temp);
    }
}
