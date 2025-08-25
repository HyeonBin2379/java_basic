package java_advanced_01.day20.pratice;

import java.io.*;

//문제 : 10,20,30 을 numbers.dat 파일에 저장하고 다시 읽어 콘솔에 출력하세요
public class Prob12 {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/Temp/numbers.dat"));
        dos.writeInt(10);
        dos.writeInt(20);
        dos.writeInt(30);
        dos.flush();
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("C:/Temp/numbers.dat"));
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        dis.close();
    }
}
