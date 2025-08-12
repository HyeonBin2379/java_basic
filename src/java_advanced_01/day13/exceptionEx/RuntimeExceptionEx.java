package java_advanced_01.day13.exceptionEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RuntimeExceptionEx {

    public static void main(String[] args) {
        try {
            int[] array = {10, 20, 30}; // 0, 1, 2번 인덱스

            // ArrayIndexOutOfBoundException: 주어진 인덱스 범위를 초과 - 컴파일 시점에서는 검출 X, 실행 시 예외 발생
//        System.out.println(array[3]);
            // ArithmeticException: 0으로 나누기
//        System.out.println(12/0);

            // NullPointerException: 참조변수가 참조할 객체가 없는 상태에서 메서드 호출
//        String str = null;
//        System.out.println(str.length());

            // NumberFormatException: 숫자로 변환 불가능한 문자열을 숫자 타입으로 변환할 때 예외 발생
            String stringNumber = "3.1415928268";
            double number = Double.parseDouble(stringNumber);
            System.out.println(number);

            // ClassCastException: 상위 클래스와 하위 클래스 간 상속, 인터페이스 캐스팅이 아닐 때 예외 발생
//        Integer num = 30;
//        Object x = num;
//        System.out.println((String)x);

            // InputMismatchException: 의도치 않은 입력오류가 발생했을 때의 예외
            Scanner in = new Scanner(System.in);
            System.out.println("정수 3개를 입력하세요.");
            int num1 = in.nextInt();
            in.close();
        } catch (NumberFormatException e) {
            e.getMessage();
        } catch (InputMismatchException e1) {
            e1.getMessage();
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.getMessage();
        } catch (ClassCastException e3) {
            e3.getMessage();
        } catch (ArithmeticException e4) {
            e4.getMessage();
        } catch (RuntimeException e5) {
            e5.getMessage();
        } catch (Exception e6) {
            e6.getMessage();
        } catch (Throwable t) {
            t.getMessage();
        }

    }
}
