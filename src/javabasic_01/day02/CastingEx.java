package javabasic_01.day02;

public class CastingEx {

    public static void main(String[] args) {

        // long 타입을 int 타입으로 변환
        long longValue = 300;
        int intValue = (int)longValue;

        System.out.println(intValue);

        // int -> char
        // int 타입은 char 타입으로 자동변환되지 않고, 강제캐스팅만 가능
        // cf) char: 0~65535 사이 값만 원래값 유지
        int intValue2 = 65;
        char charValue = (char)intValue2;
        System.out.println(charValue);

        // 실수 -> 정수: 소수부가 존재할 경우, 소수부의 값은 손실됨
        double doubleValue2 = 3.14;
        int intValue3 = (int)doubleValue2;
        System.out.println(intValue3);

        byte result = 10+20;
        int result1 = intValue2+intValue3;

        // 컴파일 단계에서 float 연산 수행 후 값을 저장하는 단계에서 double 타입으로 변환되어 저장
        double result2 = 1.2f+2.4f;
        double result3 = 1.2f+3.4;

        // 예외사항 정리: 자바에서의 + 연산자는 2가지 기능을 보유 -> 덧셈연산, 연결연산
        int v1 = 3+7;      // int v1 = 10;으로 적용
        System.out.println(v1);

        String str1 = "3"+7;    // str1 = "37";
        System.out.println(str1);
        String str2 = 3+"7";    // str1 = "37";
        System.out.println(str2);

        int v2 = 1+2+3;         // 컴파일 단계에서 연산 수행, 결과값 6을 v2에 저장
        System.out.println(v2);

        String str = "";        // 문자열 초기화 시 ""(빈문자) 사용 가능
        str = 1+2+"3";          // 3+"3" => "33"
        System.out.println(str);

        str = 1 + "2" + 3;      // "12" + 3 => "123"
        System.out.println(str);

        str = "1" + (2+3);      // "1" + 5 = "15"
        System.out.println(str);
    }
}
