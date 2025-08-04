package javabasic_02.day08.string.methods;

public class StringEx1 {

    public static void main(String[] args) {
        // 1. charAt(): 문자열에서 원하는 위치의 문자 1개를 추출
        String subject = "자바객체프로그래밍";
        char charValue = subject.charAt(0);
        System.out.println(charValue);

        String ssn = "9701233456789";
        char gender = ssn.charAt(6);
        switch (gender) {
            case '1':
            case '3':
                System.out.println("남성");
                break;
            case '2':
            case '4':
                System.out.println("여성");
                break;
        }

        // 2. length() : 문자열의 길이를 반환 - 내부적으로는 배열처럼 취급되기 때문
        int length = ssn.length();
        System.out.println(length);

        // 3. replace() : 이전 문자열의 일부 문자열을 다른 문자열로 대체
        String oldStr = "신세계 자바 과정";
        System.out.println(oldStr);
        // oldStr의 문자열의 "자바"를 "자바 백엔드"로 변경 요청
        String newStr = oldStr.replace("자바", "자바 백엔드");
        System.out.println(newStr);

        // 4. subString(int beginIndex), subString(int beginIndex, int endIndex)
        // : 기존 문자열에서 일부 문자열을 추출할 때 사용
        String ssn1 = "880815-1234567";

        // - 기준으로 앞의 6자리 숫자와 뒤의 7자리 숫자를 각각 추출
        // 1)
        String front = ssn1.substring(0, 6);
        String back = ssn1.substring(7);
        System.out.println(front + " " + back);

        // 5. indexOf() : 문자열에서 특정 문자나 문자열이 처음 등장한 위치를 찾을 때 사용
        int index = subject.indexOf("프로그래밍");
        if (index == -1) {
            System.out.println("포함되어 있지 않다.");
        } else {
            System.out.println("포함되어 있다.");
        }
        System.out.println(index);

        // 6. contains() : 문자열의 포함 여부만 확인
        boolean result = subject.contains("프로그래밍");
        System.out.println(result);

        // 7. split() : 지정한 구분자를 사용하여 문자열을 여러 개로 분리할 때 사용
        String board = "번호,제목,내용,성명";
        String[] boardStr = board.split(",");
        for (String string : boardStr) {
            System.out.print(string + " ");
        }
    }
}
