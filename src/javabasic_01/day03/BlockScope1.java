package javabasic_01.day03;

public class BlockScope1 {

    public static void main(String[] args) {
        int var1 = 10;

        if (var1 == 10) {
            int var2 = 20;
            System.out.println(var1 + " " + var2);
        }

        int sum = 0;
        int i = 1;

        // 후치증가: for문 내의 코드를 전부 실행한 다음 반복자 i의 값이 증가
        for (i = 1; i <= 5 ; i++) {
            sum = sum + i;
            System.out.println(i + " " + sum);
        }
        System.out.println(i + " " + sum);
    }
}
