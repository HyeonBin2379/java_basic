package java_advanced_01.day19.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest01 {

    public static void main(String[] args) {
        // 1. 이름 중 "A"로 시작하는 이름을 수집하여 출력
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 2. 각 이름의 길이를 세어서 출력 -> 출력 시 결과: [5, 4, 7]
        List<String> names2 = Arrays.asList("Alice", "Bobi", "Charlie");
        List<Integer> nameLength = names2.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(nameLength);
    }
}
