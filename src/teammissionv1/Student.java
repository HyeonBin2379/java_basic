package teammissionv1;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int[] record;
    private int total;
    private double average;
    private String grade;

    public Student() {
        this.record = new int[4];
        this.name = "^^";
    }

    @Override
    public String toString() {
        return String.format("%s (총점=%d, 평균=%.1f, 학점=%s)", name, total, average, grade);
    }
}
