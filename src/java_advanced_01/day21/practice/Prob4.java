package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@AllArgsConstructor
class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private String owner;
    private transient int balance;

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.balance = ois.readInt();
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(this.balance);
    }
}

public class Prob4 {

    public static void main(String[] args) {
        Path path = Paths.get("account.dat");
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            Account account = new Account("철수", 10000);
            oos.writeObject(account);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {
            if (ois.readObject() instanceof Account account) {
                System.out.println(account);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
