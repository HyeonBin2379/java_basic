package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
class Product implements Serializable {
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
        String fileName = "C:/Temp/order.dat";
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Product product = new Product("제품", 10000);
            Order order = new Order(1, product);

            oos.writeObject(order);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            if (ois.readObject() instanceof Order order) {
                System.out.println(order);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
