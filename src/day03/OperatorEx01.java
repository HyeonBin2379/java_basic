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


        // 산술 연산자: 더하기, 빼기, 곱하기, 나누기, 나머지의 5가지
        byte v1 = 10;
        byte v2 = 4;
        int v3 = 5;
        long v4 = 10L;

        // 피연산자의 모든 정수 타입 연산의 표준은 int 타입
        // -> 모든 피연산자는 int 타입으로 자동변환 후 연산됨
        int result4 = v1 + v2;
        System.out.println(result4);

        // 모든 피연산자들은 가장 크기가 큰 long 타입으로 promotion 연산
        long result5 = v1+v2+-v4;
        System.out.println(result5);

        // 정수 간 연산 결과에서 소수점 이하 자릿수를 유지해야 할 경우, double 타입으로 강제변환 후 연산
        double result6 = (double)v1/v2;
        System.out.println(result6);

        int result7 = v1 % v2;
        System.out.println(result7);

        if (v1 % v2 == 0) {
            System.out.println("짝수 입니다.");
        } else {
            System.out.println("홀수 입니다.");
        }

        int apple = 1;
        int totalPieces = apple*10;
        int number = 7;

        int result = totalPieces - number;
        System.out.println("10조각에서 남은 조각 : " + result);
        System.out.println("사과 1개에서 남은 양 : " + result/10.0);


        // 정수 타입 피연산자끼리 나눗셈 수행 시, 몫에 해당하는 값만 출력
        int k = 5;
        int result8 = k/2;
        System.out.println(result8);
    }
}
