package java_advanced_01.day19.aggEx;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
class Student {
    private String name;
    private int score;
}

public class Main1 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 92),
                new Student("David", 95),
                new Student("Bob", 88)
        );
        // 합계
        int sum1 = students.stream()
                .mapToInt(Student::getScore)
                .sum();
        System.out.println(sum1);

        int sum2 = students.stream()
                .mapToInt(Student::getScore)
                .reduce(0, Integer::sum);
        System.out.println(sum2);

        List<Student> students2 = Arrays.asList();
        int sum3 = students2.stream().mapToInt(Student::getScore).reduce(0, Integer::sum);
        System.out.println(sum3);

        int sum4 = students2.stream().mapToInt(Student::getScore).sum();
        System.out.println(sum4);
    }
}
