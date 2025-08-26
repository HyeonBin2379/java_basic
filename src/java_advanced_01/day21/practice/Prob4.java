package java_advanced_01.day21.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
class Account implements Serializable {

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
        String fileName = "C:/Temp/account.dat";
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Account account = new Account("철수", 10000);
            oos.writeObject(account);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
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
