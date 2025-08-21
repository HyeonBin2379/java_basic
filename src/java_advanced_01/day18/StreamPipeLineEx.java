package java_advanced_01.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineEx {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("김진우", 90));
        students.add(new Student("이종우", 80));
        students.add(new Student("박진우", 60));

        List<Student> studentList = Arrays.asList(
                new Student("김진우", 90),
                new Student("이종우", 100),
                new Student("박진우", 50)
        );

        // 방법1: 스트림 -> 중간처리 -> 최종처리 -> 학생들의 평균점수
        // 스트림 얻기
        Stream<Student> studentStream1 = students.stream();
        // 중간 처리(학생객체를 점수(정수타입)로 매핑)
        IntStream scoreStream = studentStream1.mapToInt(student -> student.getScore());
        // 최종 처리(평균 구하기)
        double averageScore1 = scoreStream.average().getAsDouble();
        System.out.println(averageScore1);


        // 방법2: 람다식을 주입해서 파이프라인 처리
        double averageScore2 = studentList.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();
        System.out.println(averageScore2);
    }
}
