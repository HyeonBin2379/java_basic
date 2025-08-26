package java_advanced_01.day21.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.Arrays;
import java.util.List;

// Java는 메모리에 생성된 객체를 파일 또는 네트워크로 출력 가능
// 객체를 입출력할 수 있는 보조 스트림
// ObjectInputStream(바이트 스트림과 연결되어 객체로 복원하는 역직렬화)
// ObjectOutputStream(바이트 스트림과 연결되어 객체를 직렬화)

@NoArgsConstructor
@AllArgsConstructor
@Data
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product implements Serializable {
    private String pName;
    private int price;
}

public class ObjectInOutEx {

    public static void main(String[] args) throws Exception {
        // 1. C:/Temp/object.dat 에 관한 파일출력 스트림 객체를 생성
        FileOutputStream fos = new FileOutputStream("C:/Temp/object.dat");

        // 2. 생성된 파일 입력 스트림 객체를 객체 출력 보조 스트림에 주입하여 연결
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 3. 직렬화할 객체 생성
        User user = new User("신세계", 20);
        Product product = new Product("삼성노트북", 1500000);
        Integer[] arr1 = {10, 20, 30};
        List<Product> products = Arrays.asList(product);

        // 4. 생성했던 객체들을 object.dat 파일에 저장
        oos.writeObject(products);
        oos.writeObject(arr1);
        oos.writeObject(product);
        oos.writeObject(user);

        // 5. 출력 스트림 종료
        oos.flush();
        oos.close();
        fos.flush();
        fos.close();

        // object.dat 파일의 바이트스트림을 객체로 복원
//        try (FileInputStream fis = new FileInputStream("C:/Temp/object.dat");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            Object result;
//            while ((result = ois.readObject()) != null) {
//                System.out.println(result);
//            }
//        } catch (EOFException e) {
//            System.out.println("역직렬화가 종료되었습니다.");
//        }

        FileInputStream fis = new FileInputStream("C:/Temp/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (true) {
            try {
                Object result = ois.readObject();
                System.out.println(result);
            } catch (EOFException e) {
                break;
            }
        }
    }
}
