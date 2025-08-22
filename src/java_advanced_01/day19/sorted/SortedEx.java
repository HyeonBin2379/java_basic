package java_advanced_01.day19.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedEx {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "신세계", "김윤진", "정현주", "남기주"
        );

        // 2. 자연순서로 정렬하여 이름을 출력
        List<String> sortedNames1 = names.stream().sorted().toList();
        System.out.println(sortedNames1);

        // 3. 내림차순 정렬
        List<String> sortedNames2 = names.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedNames2);

        // 4. 중간연산 체이닝
        List<String> names2 = Arrays.asList("Alice", "Bob", "Carl", "Dan", "Eve", "Ddan");
        // names2의 이름 중 "D"로 시작하는 이름을 대문자로 모두 바꾼 다음, 자연 정렬하여 출력
        List<String> sortedNames3 = names2.stream()
                .filter(name -> name.startsWith("D"))
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println(sortedNames3);
    }
}
