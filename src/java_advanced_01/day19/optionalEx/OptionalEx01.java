package java_advanced_01.day19.optionalEx;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalEx01 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(avg);


        // 처리 방법1 - Optional
        OptionalDouble optionalDouble = list
                .stream()
                .mapToInt(Integer::intValue)
                .average();
        if (optionalDouble.isPresent()) {
            System.out.println(optionalDouble.getAsDouble());
        } else {
            System.out.println(0.0);
        }

        // 처리 방법2
        double avg2 = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println(avg2);

        // 처리 방법3
        list.stream().mapToInt(Integer::intValue).average().ifPresent(System.out::println);
    }
}
