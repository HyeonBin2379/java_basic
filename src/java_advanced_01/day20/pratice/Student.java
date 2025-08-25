package java_advanced_01.day20.pratice;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private double score;

    @Override
    public String toString() {
        return String.format("%s , %d", name, age);
    }
}
