package java_advanced_01.day17.lambdaEx.lambda01;

import java.util.Scanner;

public class LambdaEx01 {
    // 사용자가 입력한 숫자 2개의 결과를 처리
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Calculable은 Cunsumer 타입과 동일
        action((x, y) -> System.out.println(x+y));
        action((x,y) -> System.out.println(x*y));
    }

    private static void action(Calculable calculable) {
        // 데이터부를 여기에서 처리
        System.out.print("Enter num1 : ");
        int x = sc.nextInt();
        System.out.print("Enter num2 : ");
        int y = sc.nextInt();

        calculable.calculate(x, y);
    }
}
