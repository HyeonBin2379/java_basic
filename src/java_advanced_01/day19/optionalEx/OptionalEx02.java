package java_advanced_01.day19.optionalEx;

import java.util.Optional;

public class OptionalEx02 {

    public static void main(String[] args) {
        // null값이 아닌 문자열을 할당
        String str = "Hello Optional!";

        // Optional 객체로 문자열을 Wrapping
        // .of(): 값이 null이 아닌 경우에만 Optional 객체 생성
        Optional<String> optString = Optional.of(str);
        System.out.println(optString);

        String nullStr = null;
        Optional<String> optNullStr = Optional.ofNullable(nullStr);
        System.out.println(optNullStr);

        // 값을 갖지 않는 빈 Optional 객체 생성
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);
    }
}
