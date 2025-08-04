package javabasic_02.day08.string.stringBufferEx;

public class StringEx01 {

    public static void main(String[] args) {
        // String 타입 피연산자에 + 연산자 사용 시, 문자열 간 연결을 수행
        // String은 불변 타입이므로 문자열을 결합할 때마다 새로운 String 인스턴스를 생성하므로
        // 아래 방식으로 문자열을 많이 결합할수록 메모리 낭비 증가
        String result = "";
        result += "Hello";
        result += " ";
        result += "Java Programming";
        System.out.println(result);

        // StringBuffer 클래스는 클래스 내부에 버퍼라는 독립적인 공간을 보유하여
        // 문자열 연산 수행 시 공간 낭비 없이 해당 연산을 빠르게 처리 가능
        StringBuffer sb1 = new StringBuffer();
        sb1.append("hello");
        sb1.append(" ");
        sb1.append("java programming ");
        sb1.append("!!!");

        // main 메서드에서 출력할 시 StringBuffer 클래스의 문자열은 String 타입으로 자동 변환
        // 그러나 별도의 메서드에서 StringBuffer를 사용할 경우, toString() 메서드를 사용하여 String 타입으로의 변환 필요
        System.out.println(sb1);
    }
}
