package day02;

public class CharEx {
    public static void main(String[] args) {
        char c1 = 'A';
        System.out.println(c1);

        char c2 = 65;
        System.out.println(c2);     // 65에 매핑되는 문자 출력

        char c3 = ' ';              // char 문자 초기화는 공백문자(32)를 사용할 것 - 빈문자('') 사용 불가
        System.out.println(c3);

        char c4 = '가';
        char c5 = 44032;            // '가'의 유니코드 값
        System.out.println(c4);
        System.out.println(c5);
    }
}
