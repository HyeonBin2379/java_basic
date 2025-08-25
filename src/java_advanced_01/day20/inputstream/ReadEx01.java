package java_advanced_01.day20.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx01 {

    public static void main(String[] args) {
        try {
            // 1. 리소스 객체를 대상으로 입력스트림을 생성
            InputStream is = new FileInputStream("C:/Temp/test1.db");

            // 2. 리소스의 데이터가 존재하면 읽어옴
            while (true) {
                int data = is.read();

                // 파일의 끝(EOF) => -1
                if (data == -1) {
                    break;
                }
                System.out.println(data);
            }

            // 3. 다 읽었으면 입력스트림 닫기
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("I/O exception");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
