package java_advanced_01.day20.datainoutstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputExt {

    public static void main(String[] args) throws Exception{
        // 입력된 데이터를 타입에 맞게 변환하여 파일에 저장
        FileOutputStream fos = new FileOutputStream("primitive.db");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("이현빈");
        dos.writeInt(10);
        dos.writeDouble(3.14);
        dos.writeBoolean(Boolean.TRUE);

        dos.flush();
        dos.close();
        fos.close();

        // 파일에 저장된 데이터를 타입에 맞게 변환하여 읽어오기
        FileInputStream fis = new FileInputStream("primitive.db");
        DataInputStream dis = new DataInputStream(fis);
        String name = dis.readUTF();
        int age = dis.readInt();
        double price = dis.readDouble();
        boolean flag = dis.readBoolean();
        System.out.println(name + " " + age + " " + price + " " + flag);

        dis.close();
        fis.close();
    }
}
