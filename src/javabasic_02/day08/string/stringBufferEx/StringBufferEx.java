package javabasic_02.day08.string.stringBufferEx;

// StringBuffer의 주요 메서드
public class StringBufferEx {

    public static void main(String[] args) {
        String str = "abcdefg";

        StringBuffer sb = new StringBuffer(str);
        System.out.println("초기상태 : " + sb);

        // toString(): StringBuffer를 String 타입으로 변환(main 메서드에서는 생략 가능)
        System.out.println("초기상태 : " + sb.toString());
        // substring(): sb에 저장된 문자열에서 "cd" 출력
        System.out.println("문자열 추출 : " + sb.substring(2, 4));

        // insert(): sb에 저장된 문자열의 중간(2번 인덱스)에 지정한 문자열을 추가
        System.out.println("문자열 추가 : " + sb.insert(2, "추가"));

        // delete(): sb에 저장된 문자열의 2번~4번 인덱스의 문자를 삭제
        System.out.println("문자열 삭제 : " + sb.delete(2, 4));

        // append(): sb의 문자열 맨 뒤에 문자열 이어붙이기
        System.out.println("문자열 붙이기 : " + sb.append("hijk"));

        // length(): sb에 저장된 현재 문자열의 길이
        System.out.println("문자열의 길이 : " + sb.length());

        // capacity(): sb에 저장 가능한 최대 용량(새로운 문자열 추가로 용량 초과 시 자동 증가)
        System.out.println("문자열의 용량: " + sb.capacity());

        // reverse(): 현재 문자열을 역순으로 출력
        System.out.println("문자열의 역순 : " + sb.reverse());
    }
}
