package java_advanced_01.day19.mappingEx;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
class Student {

    private String name;
    private int score;
}

public class MappingEx01 {

    public static void main(String[] args) {
        // 1. 학생 3명 저장
        List<Student> students = new ArrayList<>();
        students.add(new Student("학생1", 60));
        students.add(new Student("학생2", 80));
        students.add(new Student("학생3", 50));

        // 2. 학생들의 점수를 stream()을 사용하여 출력
        students.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);

        // 3. 학생들의 총점을 입력
        int sum = students.stream()
                .mapToInt(Student::getScore)
                .sum();
        System.out.println("총점: " + sum);

        // 4. 학생들의 점수의 평균을 출력
        double average = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();
        System.out.printf("평균: %.1f\n", average);
    }
}
