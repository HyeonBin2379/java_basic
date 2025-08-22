package java_advanced_01.day19.test;

import java.util.Arrays;
import java.util.List;

public class StreamExercise {

    public static void main(String[] args) {
        // 1. 정수리스트에서 짝수를 필터링하는 자바스트림 연산
        List<Integer> intList = Arrays.asList(1,10,5,2,31,17,28);
        List<Integer> evenList = intList.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println(evenList);

        // 2. 리스트의 각 정수를 제곱하기 위해 map 연산을 사용하여 연산결과 출력
        List<Integer> intList2 = Arrays.asList(1,10,5,2,31,17,28);
        List<Integer> squareList = intList2.stream()
                .map(num -> num*num)
                .toList();
        System.out.println(squareList);

        // 3. 문자열 리스트에서 중복요소 제거를 위해 distinct() 사용
        List<String> strings = Arrays.asList("aaa","bbb", "bbbb", "ccc", "bbb", "eee");
        List<String> uniqueStrings = strings.stream()
                .distinct()
                .toList();
        System.out.println(uniqueStrings);
        System.out.println();

        // 4. 스트림을 사용하여 정수 리스트를 오름차순 출력
        intList.stream().sorted().forEach(System.out::println);
        System.out.println();

        // 5. 정수리스트에서 리스트의 모든 짝수의 합을 출력
        List<Integer> intList3 = Arrays.asList(1,10,5,2,31,17,28);
        int sum = intList3.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }
}
