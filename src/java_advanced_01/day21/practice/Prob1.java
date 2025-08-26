package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@AllArgsConstructor
@Data
class Person implements Serializable {

    private String name;
    private transient int age;
}

public class Prob1 {

    public static void main(String[] args) {
        String fileName = "C:/Temp/person.dat";

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Person person = new Person("홍길동", 30);

            oos.writeObject(person);
            oos.writeInt(person.getAge());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            if (ois.readObject() instanceof Person person) {
                int age = ois.readInt();
                person.setAge(age);
                System.out.println(person);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
