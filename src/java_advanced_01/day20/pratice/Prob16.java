package java_advanced_01.day20.pratice;

//문제 : 3명의 학생 (김철수,21,3.5), (이영희,22,3.9) (박민수, 20,3.2) 학생 정보를 students.dat파일에 저장하고 다시 읽어 출력 ex) 반 총점 = 10.6  반 평균 = 3.5 (소수 첫째자리 표현)을 출력하고 학생정보를 나이순으로 콘솔에 출력하세요
//학생정보
// 박민수 , 20세
// 김철수 , 21세
// 이영희 , 22세
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Prob16 {

    public static void main(String[] args) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/Temp/students.dat"))) {
            dos.writeUTF(String.format("%s, %d, %.1f\n", "김철수", 21, 3.5));
            dos.writeUTF(String.format("%s, %d, %.1f\n", "이영희", 22, 3.9));
            dos.writeUTF(String.format("%s, %d, %.1f\n", "박민수", 20, 3.2));
            dos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<Student> students = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("C:/Temp/students.dat"))) {
            for (int i = 0; i < 3; i++) {
                String[] tokens = dis.readUTF().split(", ");
                Student student = Student.builder()
                        .name(tokens[0])
                        .age(Integer.parseInt(tokens[1]))
                        .score(Double.parseDouble(tokens[2]))
                        .build();
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        double total = students.stream()
                .mapToDouble(Student::getScore)
                .sum();
        System.out.println("반 총점 = " + total);
        System.out.printf("반 평균 = %.1f\n", total/students.size());
        System.out.println("학생 정보:");
        students.stream().sorted(Comparator.comparingInt(Student::getAge)).forEach(System.out::println);
    }
}
