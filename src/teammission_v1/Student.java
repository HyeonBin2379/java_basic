package teammission_v1;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Integer> record;
    private int total;
    private double average;
    private String grade;

    public Student(String name, List<Integer> record) {
        this.name = name;
        this.record = record;
    }

    public void calculateTotal() {
        this.total = record.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void calculateAverage() {
        this.average = record.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void calculateGrade() {
        if (average >= 90) {
            this.grade = "A";
        } else if (average >= 80) {
            this.grade = "B";
        } else if (average >= 70) {
            this.grade = "C";
        } else if (average >= 60) {
            this.grade = "D";
        } else {
            this.grade = "F";
        }
    }

    @Override
    public String toString() {
        return String.format("%s (총점=%d, 평균=%.1f, 학점=%s)", name, total, average, grade);
    }
}
