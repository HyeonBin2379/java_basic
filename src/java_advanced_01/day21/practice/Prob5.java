package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@AllArgsConstructor
class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 5L;

    private String name;
    private int price;
}

@Data
@AllArgsConstructor
class Order implements Serializable {
    private int orderId;
    private transient Product product;

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.product = (Product) ois.readObject();
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(this.product);
    }
}

public class Prob5 {

    public static void main(String[] args) {
        Path path = Paths.get("order.dat");
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            Product product = new Product("제품", 10000);
            Order order = new Order(1, product);

            oos.writeObject(order);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {
            if (ois.readObject() instanceof Order order) {
                System.out.println(order);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
