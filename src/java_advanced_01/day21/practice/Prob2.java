package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    private String title;
    private int price;
}

public class Prob2 {

    public static void main(String[] args) {
        Path path = Paths.get("books.dat");
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            List<Book> books = new ArrayList<>();
            books.add(new Book("책1", 8000));
            books.add(new Book("책2", 10000));
            books.add(new Book("책3", 6000));

            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {
            List<Book> books = (ArrayList<Book>) ois.readObject();
            books.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
