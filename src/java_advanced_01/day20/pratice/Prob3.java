package java_advanced_01.day20.pratice;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 문제 3: 텍스트 파일에 저장된 문자 수 세기
//         hello.txt 파일의 문자 수를 세어 화면에 출력하세요.
public class Prob3 {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("C:/Temp/hello.txt");
        int totalLength = 0;
        char[] data = new char[100];
        while (true) {
            int readCount = reader.read(data);
            if (readCount == -1) {
                break;
            }
            totalLength += readCount;
        }
        System.out.println(totalLength);
    }
}
