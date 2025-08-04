package javabasic_02.day09.methods;

import java.util.Scanner;

public class Calculator01 {
    static final String MENU = """
            ===========================================
                            사칙연산 계산기
            ===========================================
            1.덧셈  2.뺄셈  3.곱셉  4.나눗셈  5.프로그램 종료
            
            두 수를 차례로 입력하고 수행할 사칙연산의 메뉴 숫자를 입력해 주세요.
            
            """;

    static Scanner sc = new Scanner(System.in);
    static boolean isRunning = true;

    public static void main(String[] args) {
        System.out.println(MENU);

        while (isRunning) {
            String[] data = sc.nextLine().split(" ");
            menu(data);
        }
    }

    //사용자가 입력한 아이디와 비밀번호를 idPwPrint()를 이용하여 출력하세요.
    public static void calculator(String[] data) {
        int num1 = Integer.parseInt(data[0]);
        int num2 = Integer.parseInt(data[1]);
        int menuNum = Integer.parseInt(data[2]);

        int result = 0;
        switch (menuNum) {
            case 1: result = num1 + num2; break;
            case 2: result = num1 - num2; break;
            case 3: result = num1 * num2; break;
            case 4: result = num1 / num2; break;
            case 5: isRunning = false;
            default:
                System.out.println("숫자만 입력해주세요.");
        }
        menu2(num1,num2,menuNum,result);
    }

    public static void menu(String[] data) {
        System.out.println("======================================================");
        System.out.println("                     사칙 연산 계산기                    ");
        System.out.println("======================================================");
        System.out.println("1. 덧셈   2. 뺄셈    3. 곱셈    4. 나눗셈   5. 프로그램 종료");

        calculator(data);

    }

    public static void menu2(int num1, int num2, int menuNum,int result) {
        switch (menuNum) {
            case 1: System.out.printf("%d + %d = %d \n",num1, num2,result); break;
            case 2: System.out.printf("%d - %d = %d \n",num1, num2,result); break;
            case 3: System.out.printf("%d * %d = %d \n",num1, num2,result); break;
            case 4: System.out.printf("%d / %d = %.1f \n",num1, num2,(double)result); break;
            case 5: isRunning = false;

        }
    }
}
