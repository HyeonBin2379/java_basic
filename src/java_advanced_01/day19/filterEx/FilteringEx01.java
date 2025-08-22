package java_advanced_01.day19.filterEx;

import java.util.Arrays;
import java.util.List;

public class FilteringEx01 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("신세계", "신세계", "Java", "김민성", "김민서");
        // 중복 요소 제거
        list1.stream().forEach(System.out::println);

        System.out.println();

        list1.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        // list1에서 중복을 제거하고 이름에 "신"이 들어간 사람의 이름을 출력
        // 필터링 적용 전: list1의 모든 요소 출력
        list1.stream().forEach(System.out::println);
        System.out.println();
        // 중복된 이름 제거 & 성이 "신"씨인 사람의 이름 출력
        list1.stream()
                .distinct()
                .filter(name -> name.startsWith("신"))
                .forEach(System.out::println);
    }
}
