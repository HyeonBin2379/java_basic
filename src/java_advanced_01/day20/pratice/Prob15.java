package java_advanced_01.day20.pratice;

import java.io.*;

//문제 : 학생 이름 "신세계" 나이 25 학점 3.8 을 student.dat파일에 저장하고 다시 읽어 콘솔에 출력하세요
public class Prob15 {
    public static void main(String[] args) throws IOException {
        String fileName = "C:/Temp/student.dat";
        Student student = Student.builder()
                .name("신세계")
                .age(25)
                .score(3.8)
                .build();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
            dos.writeUTF(student.getName());
            dos.writeInt(student.getAge());
            dos.writeDouble(student.getScore());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("C:/Temp/student.dat"))) {
            System.out.println("학생 이름 : " + dis.readUTF());
            System.out.println("나이 : " + dis.readInt());
            System.out.println("학점 : " + dis.readDouble());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
