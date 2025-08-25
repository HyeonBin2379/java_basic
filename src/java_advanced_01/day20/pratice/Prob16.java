package java_advanced_01.day20.pratice;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//문제 : 3명의 학생 (김철수,21,3.5), (이영희,22,3.9) (박민수, 20,3.2) 학생 정보를 students.dat파일에 저장하고 다시 읽어 출력 ex) 반 총점 = 10.6  반 평균 = 3.5 (소수 첫째자리 표현)을 출력하고 학생정보를 나이순으로 콘솔에 출력하세요
//학생정보
// 박민수 , 20세
// 김철수 , 21세
// 이영희 , 22세
public class Prob16 {

    static class Student {
        private String name;
        private int age;
        private double score;

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getScore() {
            return score;
        }
    }

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/Temp/students.dat"));
        dos.writeUTF(String.format("%s, %d, %.1f\n", "김철수", 21, 3.5));
        dos.writeUTF(String.format("%s, %d, %.1f\n", "이영희", 22, 3.9));
        dos.writeUTF(String.format("%s, %d, %.1f\n", "박민수", 20, 3.2));
        dos.flush();
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("C:/Temp/students.dat"));
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String[] tokens = dis.readUTF().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            double score = Double.parseDouble(tokens[2]);
            students.add(new Student(name, age, score));
        }
        students.sort(Comparator.comparingInt(o -> o.age));

        double total = students.stream().mapToDouble(Student::getScore).sum();
        System.out.println("반 총점 = " + total);
        System.out.printf("반 평균 = %.1f\n", total/students.size());
        System.out.println("학생 정보:");
        students.forEach(student -> System.out.printf("%s , %d\n", student.getName(), student.getAge()));
    }
}
