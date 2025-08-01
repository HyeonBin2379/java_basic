package javabasic_02.day08.string;

public class RefEx03 {

    public static void main(String[] args) {
        // 리터럴 저장 방식: String Constant Pool 영역에 저장
        String str1 = "Java";
        String str2 = "Java";
        System.out.println("---- str1 == str2 ----");
        System.out.println(str1 == str2);   // true - String Constant Pool의 같은 공간을 공유

        // new 연산자 사용 방식: Heap 영역에 저장
        String str3 = new String("Java");
        String str4 = new String("Java");
        System.out.println("---- str3 == str4 ----");
        System.out.println(str3 == str4);           // 주소값 비교 - 할당받은 heap 영역이 서로 다르기 때문에 주소값이 다름
        System.out.println(str3.equals(str4));      // 실제 저장된 값 비교 - true


        // 리터럴과 객체 문자열 비교
        System.out.println("-------리터럴과 객체 문자열 비교------------");
        System.out.println(str1 == str3);       // false - 할당받는 영역이 서로 다르기 때문에 주소값이 다름
        System.out.println(str3.equals(str1));  // true - 실제 값은 둘 다 "Java"로 동일
    }
}
