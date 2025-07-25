package day03;

public class OperatorEx01 {

    public static void main(String[] args) {
        // 부호 연산자: 변수의 부호를 유지하거나 제거
        byte b = 100;
        System.out.println(b);

        // 정수 타입(byte, short, int)의 연산결과는 int타입
        int a = -b;
        System.out.println(a);

        int c = -a;
        System.out.println(c);

        // 증감 연산자: 변수의 값을 1 증가시키거나 1 감소시킬 때 사용하는 연산자
        // ++i, --i, i++, i--
        // ++i, --i prefix: 연산 시작 전 증감 연산을 우선적으로 수행
        // i++, i-- postfix: 연산 종료 이후 증감 연산을 수행

        // ++i, i++ => i = i + 1;
        // --i, i-- => i = i - 1;

        int x = 1;
        int y = 1;

        int result1 = ++x + 10; // (x = x+1)+10 = 12
        System.out.println(result1);

        int result2 = y++ + 10; // y+10 수행 후 y의 값 증가, y는 2로 증가 -> result2 = 11
        System.out.println(result2);
        System.out.println(y++ + 10);   // y+10 수행 후 출력 -> 이후 y값은 3으로 증가

        int x1 = 10;
        int y1 = 10;
        int z;

        x1++;   // x1 = x1 + 1
        ++x1;   // x1 = x1 + 1
        System.out.println(x1);     // x1 = 12

        System.out.println("---------------------");

        y1--;
        --y1;
        System.out.println("y1 : " + y1);   // y1 = 8

        System.out.println("---------------------");

        z = x1++;   // x1의 값을 z에 할당한 다음 x1의 값을 1 증가시킴
        System.out.println("z : " + z + " x1 : " + x1);

        System.out.println("---------------------");
        z = ++x1 + y1++;    // x1이 14로 증가 -> x1+y1 = 22를 z에 대입 -> y1이 9로 증가
        System.out.println("z : " + z + " y1 : " + y1);
        System.out.println();
    }
}
