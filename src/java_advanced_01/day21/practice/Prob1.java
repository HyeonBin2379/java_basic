package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
@Data
class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private transient int age;  // 직렬화 수행 대상에서 제외되는 필드
}

public class Prob1 {

    public static void main(String[] args) {
        Path path = Paths.get("person.dat");

        // 직렬화한 Person 객체의 데이터를 person.dat 파일에 저장
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            Person person = new Person("홍길동", 30);
            oos.writeObject(person);
            oos.writeInt(person.getAge());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // person.dat 파일에 저장된 바이트코드를 Person 객체로 역직렬화
        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {
            if (ois.readObject() instanceof Person person) {
                int age = ois.readInt();
                person.setAge(age);
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
