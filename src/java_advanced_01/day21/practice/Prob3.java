package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
class Student implements Serializable {

    private String name;
    private int grade;
}

public class Prob3 {

    public static void main(String[] args) {
        String fileName = "C:/Temp/students.dat";
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(new Student("김철수", 1));
            oos.writeObject(new Student("박영희", 2));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                if (ois.readObject() instanceof Student student) {
                    System.out.println(student);
                } else {
                    break;
                }
            }
        } catch (EOFException e) {
            System.out.println("파일 읽기를 종료합니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
