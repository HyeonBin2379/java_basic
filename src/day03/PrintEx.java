package day03;

public class PrintEx {

    public static void main(String[] args) {
        // 표준 출력 장치(모니터)에 괄호 안의 값을 출력하고, 줄바꿈을 수행
        System.out.println("리터럴 또는 변수");

        System.out.printf("과목명: %s\n", "자바");
        // 형식문자에 $ 사용: 형식문자에 대입되는 값들 간 순번을 바꿀 때 사용 가능
        System.out.printf("과목명: %1$s 이름: %2$s\n", "자바", "이현빈");
        System.out.printf("과목명: %1$s 이름: %2$s 학번: %3$s\n", "자바", "이현빈", "1234");


        System.out.println("================ 정수 표현 ===============");
        // 정수 123을 printf를 이용하여 출력
        System.out.printf("%d\n", 123);

        // 정수 ___123을 printf를 이용하여 출력
        System.out.printf("%6d\n", 123);    // 6자리 정수를 오른쪽 정렬, 빈 자리는 공백
        System.out.printf("%-6d\n", 123);   // 6자리 정수를 왼쪽 정렬, 빈 자리는 공백

        // 정수 000123을 printf를 이용하여 출력, 왼쪽 빈자리는 0으로 채울 것(이때, 왼쪽 정렬은 불가능)
        System.out.printf("%06d\n", 123);

        System.out.println("================ 실수 표현 ===============");
        // 정수 7자리+소수점+소수2자리, . 왼쪽 빈자리는 공백 ex) ___123.45
        // 전체 길이: 정수 자릿수+소수점+소수점 이하 자릿수의 총합(주의)
        // 소수점 이하 자릿수 지정 시, 기본적으로 반올림 수행
        System.out.printf("%10.2f\n", 123.456);
        System.out.printf("%010.2f\n", 123.456);     // 왼쪽 빈자리를 모두 0으로 채울 경우

        System.out.println("=============== 문자열 표현 ===============");
        // 문자열은 %s 포맷   abc 출력
        System.out.printf("%s\n", "abc");

        // 문자열은 %s 포맷   ___abc 출력
        System.out.printf("%6s\n", "abc");

        // 특수문자 \t, \n, %%
        System.out.printf("소금물의 농도 %% %1d\n", 35);
    }
}
