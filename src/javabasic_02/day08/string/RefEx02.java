package javabasic_02.day08.string;

public class RefEx02 {

    public static void main(String[] args) {
        // 동일한 변수 a의 주소값을 출력했음에도, 문자열이 변경되면서 주소값이 바뀌었음을 확인
        // 따라서, 문자열의 값 자체는 불변이라 변경할 수 없기 때문에 새로운 문자열 데이터에 객체를 대입하여 새로운 공간에 값을 할당했음을 의미
        String a = "hello";
        System.out.println(a.hashCode());

        a += "Java Programming";
        System.out.println(a.hashCode());
        System.out.println(a);
    }
}
