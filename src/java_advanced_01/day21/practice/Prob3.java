package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@AllArgsConstructor
class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    private String name;
    private int grade;
}

public class Prob3 {

    public static void main(String[] args) {
        Path path = Paths.get("students.dat");
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(new Student("김철수", 1));
            oos.writeObject(new Student("박영희", 2));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {
            while (true) {
                if (ois.readObject() instanceof Student student) {
                    System.out.println(student);
                } else {
                    break;
                }
            }
        } catch (EOFException e) {
            System.out.println("파일 읽기를 종료합니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
