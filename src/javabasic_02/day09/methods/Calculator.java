package javabasic_02.day09.methods;

import java.util.Scanner;

public class Calculator {

    static final String MENU = """
            ===========================================
                            사칙연산 계산기
            ===========================================
            1.덧셈  2.뺄셈  3.곱셉  4.나눗셈  5.프로그램 종료
            
            두 수를 차례로 입력하고 수행할 사칙연산의 메뉴 숫자를 입력해 주세요.
            
            """;

    static Scanner sc = new Scanner(System.in);
    static boolean isRunning = true;

    public void run() {
        while (isRunning) {
            int[] data = inputData();
            calculate(data);
        }
    }

    public int[] inputData() {
        System.out.print(MENU);
        try {
            String[] splitData = sc.nextLine().split(" ");
            int data1 = Integer.parseInt(splitData[0]);
            int data2 = Integer.parseInt(splitData[1]);
            int data3 = Integer.parseInt(splitData[2]);

            if (data2 == 0 && data3 == 4) {
                throw new ArithmeticException("0으로 나눌 수 없습니다. 다시 입력해주세요.");
            }
            return new int[]{data1, data2, data3};
        } catch (NumberFormatException e) {
            System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
            return inputData();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return inputData();
        }
    }

    public void calculate(int[] data) {
        switch (data[2]) {
            case 1 -> adder(data);
            case 2 -> minus(data);
            case 3 -> multi(data);
            case 4 -> div(data);
            case 5 -> exitMenu();
            default -> System.out.println("1~5 사이의 숫자만 입력 가능합니다.");
        }
        System.out.println();
    }

    public int adder(int[] data) {
        int result = data[0]+data[1];
        System.out.printf("\n결과는\n\n%d + %d = %d\n", data[0], data[1], result);
        return result;
    }

    public int minus(int[] data) {
        int result = data[0]-data[1];
        System.out.printf("\n결과는\n\n%d - %d = %d\n", data[0], data[1], result);
        return result;
    }

    public int multi(int[] data) {
        int result = data[0]*data[1];
        System.out.printf("\n결과는\n\n%d * %d = %d\n", data[0], data[1], result);
        return result;
    }

    public double div(int[] data) {
        double result = (double)data[0]/data[1];
        System.out.printf("\n결과는\n\n%d / %d = %.1f\n", data[0], data[1], result);
        return result;
    }

    public void exitMenu() {
        isRunning = false;
        System.out.println("계산기를 종료합니다.");
    }
}
