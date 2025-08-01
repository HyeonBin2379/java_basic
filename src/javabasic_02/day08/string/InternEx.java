package javabasic_02.day08.string;

// intern() : 문자열에 관한 최적화된 관리를 위한 메서드
// 문자열을 리터럴로 선언할 경우, 내부적으로 String의 intern() 메서드를 호출
// : 해당 리터럴이 문자열 상수 pool 내부에 존재하는지를 확인
// : 존재하면 해당 pool의 리터럴을 리턴, 존재하지 않으면 리터럴을 pool 안에 추가 후 새로운 주소값을 반환
public class InternEx {

    public static void main(String[] args) {
        String str1 = "Hello";
        // 문자 배열로 생성한 String 리터럴 값을 str2에 할당
        String str2 = new String(new char[]{'H', 'e', 'l', 'l', 'o'}).intern();
        // 문자열 리터럴은 equals() 없이 문자열 비교 가능
        System.out.println(str1 == str2);

        String str3 = new String("Hi");
        String str4 = "Hi";

        // str3에 할당된 값이 String 리터럴 "Hi"로 해석되어
        // str4가 참조하는 리터럴 값과 동일하므로,결과값으로 true를 출력
        str3 = str3.intern();
        System.out.println(str3 == str4);
    }
}
