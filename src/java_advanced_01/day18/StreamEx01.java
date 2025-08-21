package java_advanced_01.day18;

import java.util.*;
import java.util.stream.Stream;

public class StreamEx01 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // 컬렉션과 배열: 요소를 반복처리 할 때는 반복문이나 Iterator를 사용(외부 반복)
        // 아래 for문은 List 컬렉션에 저장된 요소를 1개씩 처리
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            System.out.println(item);
        }
        // 향상된 for문을 이용해서 요소를 1개씩 처리
        for (String item : list) {
            System.out.println(item);
        }
        // Iterator 사용
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String item = iter.next();

            // 요소 처리: 콘솔창에서 요소의 값을 확인
            System.out.println(item);
        }

        // Java 8부터는 Stream을 사용하여 요소들이 하나씩 흘러가면서 처리하는 방법을 제시
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        // 1. Set 컬렉션 names 생성
        Set<String> names = new HashSet<>();
        // 2. 회원의 이름을 names에 저장
        names.add("홍길동");
        names.add("김나무");
        names.add("김꽃분");
        // 3. names에 Stream 방식을 통해 요소를 출력
        Stream<String> users = names.stream();
        users.forEach(System.out::println);
        users.forEach(name -> System.out.println(name));
    }
}
